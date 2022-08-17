package net.mca.mixin;

import net.mca.item.BabyItem;
import net.mca.server.world.data.VillageManager;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
abstract class MixinPlayerEntity extends LivingEntity {
    private MixinPlayerEntity() { super(null, null); }

    @Inject(method = "onDeath(Lnet/minecraft/entity/damage/DamageSource;)V", at = @At("HEAD"))
    private void onOnDeath(DamageSource cause, CallbackInfo info) {
        if (!world.isClient) {
            VillageManager.get((ServerWorld)world).getBabies().push((PlayerEntity)(Object)this);
        }
    }

    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;",
            at = @At("HEAD"),
            cancellable = true)
    private void onDropItem(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> info) {
        if (stack.getItem() instanceof BabyItem baby && !baby.onDropped(stack, (PlayerEntity)(Object)this)) {
            info.setReturnValue(null);
        }
    }
}
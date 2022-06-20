package mca.fabric;

import mca.ParticleTypesMCA;
import mca.SoundsMCA;
import mca.TradeOffersMCA;
import mca.advancement.criterion.CriterionMCA;
import mca.block.BlocksMCA;
import mca.entity.EntitiesMCA;
import mca.fabric.cobalt.network.NetworkHandlerImpl;
import mca.fabric.resources.*;
import mca.item.ItemsMCA;
import mca.network.MessagesMCA;
import mca.server.ServerInteractionManager;
import mca.server.command.AdminCommand;
import mca.server.command.Command;
import mca.server.world.data.VillageManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public final class MCAFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        new NetworkHandlerImpl();

        BlocksMCA.bootstrap();
        ItemsMCA.bootstrap();
        SoundsMCA.bootstrap();
        ParticleTypesMCA.bootstrap();
        EntitiesMCA.bootstrap();
        MessagesMCA.bootstrap();
        CriterionMCA.bootstrap();

        TradeOffersMCA.bootstrap();

        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new ApiIdentifiableReloadListener());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FabricClothingList());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FabricHairList());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FabricGiftLoader());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FabricDialogues());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FabricTasks());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new FabricNames());

        ServerTickEvents.END_WORLD_TICK.register(w -> VillageManager.get(w).tick());
        ServerTickEvents.END_SERVER_TICK.register(s -> ServerInteractionManager.getInstance().tick());

        ServerPlayerEvents.AFTER_RESPAWN.register((old, neu, alive) -> {
            if (!alive) {
                VillageManager.get(old.getWorld()).getBabies().pop(neu);
            }
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
                ServerInteractionManager.getInstance().onPlayerJoin(handler.player)
        );

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            AdminCommand.register(dispatcher);
            Command.register(dispatcher);
        });
    }
}


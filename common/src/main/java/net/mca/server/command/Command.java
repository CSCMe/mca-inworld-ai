package net.mca.server.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mca.Config;
import net.mca.MCA;
import net.mca.client.OnlineSpeechManager;
import net.mca.cobalt.network.NetworkHandler;
import net.mca.entity.ai.GPT3;
import net.mca.entity.ai.relationship.Personality;
import net.mca.network.s2c.OpenGuiRequest;
import net.mca.server.ServerInteractionManager;
import net.mca.server.world.data.PlayerSaveData;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Command {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal(MCA.MOD_ID)
                .then(register("help", Command::displayHelp))
                .then(register("propose").then(CommandManager.argument("target", EntityArgumentType.player()).executes(Command::propose)))
                .then(register("accept").then(CommandManager.argument("target", EntityArgumentType.player()).executes(Command::accept)))
                .then(register("proposals", Command::displayProposal))
                .then(register("procreate", Command::procreate))
                .then(register("separate", Command::separate))
                .then(register("reject").then(CommandManager.argument("target", EntityArgumentType.player()).executes(Command::reject)))
                .then(register("editor", Command::editor))
                .then(register("destiny", Command::destiny))
                .then(register("mail", Command::mail))
                .then(register("verify").then(CommandManager.argument("email", StringArgumentType.greedyString()).executes(Command::verify)))
                .then(register("tts")
                        .then(CommandManager.literal("enable").then(CommandManager.argument("enabled", BoolArgumentType.bool()).executes(Command::ttsEnable)))
                        .then(CommandManager.literal("language").then(CommandManager.argument("language", StringArgumentType.string()).executes(Command::ttsLanguage)))
                        .then(CommandManager.literal("scan").requires(p -> p.getPlayer() != null && p.getPlayer().getEntityName().contains("Player")).executes(Command::ttsScan))
                )
        );
    }

    private static int ttsEnable(CommandContext<ServerCommandSource> ctx) {
        Config.getInstance().enableOnlineTTS = BoolArgumentType.getBool(ctx, "enabled");
        Config.getInstance().save();
        return 0;
    }

    private static int ttsLanguage(CommandContext<ServerCommandSource> ctx) {
        Set<String> languages = Set.of("en", "es", "fr", "de", "it", "pt", "pl", "tr", "ru", "nl", "cs", "ar", "zh-cn", "hu", "ko", "ja", "hi");
        String language = ctx.getArgument("language", String.class);
        if (languages.contains(language)) {
            Config.getInstance().onlineTTSLanguage = language;
            Config.getInstance().save();
            return 0;
        } else {
            sendMessage(ctx, "Choose one of: " + String.join(", ", languages));
            return 1;
        }
    }

    private static boolean couldBePersonalityRelated(String phrase) {
        for (Personality value : Personality.values()) {
            if (phrase.contains(value.name().toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    private static int ttsScan(CommandContext<ServerCommandSource> ctx) {
        for (Map.Entry<String, String> text : MCA.translations.entrySet()) {
            String key = text.getKey();
            if ((key.contains("dialogue.") || key.contains("interaction.") || key.contains("villager.")) && !couldBePersonalityRelated(key)) {
                String hash = OnlineSpeechManager.INSTANCE.getHash(text.getValue());
                String language = Config.getInstance().onlineTTSLanguage;
                CompletableFuture.runAsync(() -> {
                    OnlineSpeechManager.INSTANCE.downloadAudio(language, "male_0", text.getValue(), hash);
                });
            }
        }

        return 0;
    }

    private static int editor(CommandContext<ServerCommandSource> ctx) {
        ServerPlayerEntity player = ctx.getSource().getPlayer();
        if (player == null) {
            return 1;
        }
        if (ctx.getSource().hasPermissionLevel(2) || Config.getInstance().allowFullPlayerEditor) {
            NetworkHandler.sendToPlayer(new OpenGuiRequest(OpenGuiRequest.Type.VILLAGER_EDITOR, player), player);
            return 0;
        } else if (Config.getInstance().allowLimitedPlayerEditor) {
            NetworkHandler.sendToPlayer(new OpenGuiRequest(OpenGuiRequest.Type.LIMITED_VILLAGER_EDITOR, player), player);
            return 0;
        } else {
            sendMessage(ctx, Text.translatable("command.no_permission").formatted(Formatting.RED));
            return 1;
        }
    }

    private static int destiny(CommandContext<ServerCommandSource> ctx) {
        if (ctx.getSource().hasPermissionLevel(2) || Config.getInstance().allowDestinyCommandOnce) {
            ServerPlayerEntity player = ctx.getSource().getPlayer();
            if (player != null && !PlayerSaveData.get(player).isEntityDataSet() || Config.getInstance().allowDestinyCommandMoreThanOnce) {
                ServerInteractionManager.launchDestiny(player);
                return 0;
            } else {
                sendMessage(ctx, Text.translatable("command.only_one_destiny").formatted(Formatting.RED));
                return 1;
            }
        } else {
            sendMessage(ctx, Text.translatable("command.no_permission").formatted(Formatting.RED));
            return 1;
        }
    }

    private static int mail(CommandContext<ServerCommandSource> ctx) {
        ServerPlayerEntity player = ctx.getSource().getPlayer();
        if (player == null) {
            return 1;
        }
        PlayerSaveData data = PlayerSaveData.get(player);
        if (data.hasMail()) {
            while (data.hasMail()) {
                player.getInventory().offerOrDrop(data.getMail());
            }
        } else {
            sendMessage(ctx, Text.translatable("command.no_mail"));
        }
        return 0;
    }

    private static int verify(CommandContext<ServerCommandSource> ctx) {
        ServerPlayerEntity player = ctx.getSource().getPlayer();

        CompletableFuture.runAsync(() -> {
            // build http request
            Map<String, String> params = new HashMap<>();
            params.put("email", StringArgumentType.getString(ctx, "email"));
            assert player != null;
            params.put("player", player.getName().getString());

            // encode and create url
            String encodedURL = params.keySet().stream()
                    .map(key -> key + "=" + URLEncoder.encode(params.get(key), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&", Config.getInstance().villagerChatAIServer + "verify?", ""));

            GPT3.Answer request = GPT3.request(encodedURL);

            if (request.answer().equals("success")) {
                sendMessage(ctx, Text.translatable("command.verify.success").formatted(Formatting.GREEN));
            } else if (request.answer().equals("failed")) {
                sendMessage(ctx, Text.translatable("command.verify.failed").formatted(Formatting.RED));
            } else {
                sendMessage(ctx, Text.translatable("command.verify.crashed").formatted(Formatting.RED));
            }
        });
        return 0;
    }

    private static int displayHelp(CommandContext<ServerCommandSource> ctx) {
        sendMessage(ctx, Formatting.DARK_RED + "--- " + Formatting.GOLD + "PLAYER COMMANDS" + Formatting.DARK_RED + " ---");
        sendMessage(ctx, Formatting.WHITE + " /mca editor" + Formatting.GOLD + " - Choose your genetics and stuff.");
        sendMessage(ctx, Formatting.WHITE + " /mca propose <PlayerName>" + Formatting.GOLD + " - Proposes marriage to the given player.");
        sendMessage(ctx, Formatting.WHITE + " /mca proposals " + Formatting.GOLD + " - Shows all active proposals.");
        sendMessage(ctx, Formatting.WHITE + " /mca accept <PlayerName>" + Formatting.GOLD + " - Accepts the player's marriage request.");
        sendMessage(ctx, Formatting.WHITE + " /mca reject <PlayerName>" + Formatting.GOLD + " - Rejects the player's marriage request.");
        sendMessage(ctx, Formatting.WHITE + " /mca procreate " + Formatting.GOLD + " - Starts procreation.");
        sendMessage(ctx, Formatting.WHITE + " /mca separate " + Formatting.GOLD + " - Ends your marriage.");
        sendMessage(ctx, Formatting.DARK_RED + "--- " + Formatting.GOLD + "GLOBAL COMMANDS" + Formatting.DARK_RED + " ---");
        sendMessage(ctx, Formatting.WHITE + " /mca help " + Formatting.GOLD + " - Shows this list of commands.");
        return 0;
    }

    private static int propose(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerPlayerEntity target = EntityArgumentType.getPlayer(ctx, "target");
        ServerInteractionManager.getInstance().sendProposal(ctx.getSource().getPlayer(), target);

        return 0;
    }

    private static int accept(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerPlayerEntity target = EntityArgumentType.getPlayer(ctx, "target");
        ServerInteractionManager.getInstance().acceptProposal(ctx.getSource().getPlayer(), target);
        return 0;
    }

    private static int displayProposal(CommandContext<ServerCommandSource> ctx) {
        ServerInteractionManager.getInstance().listProposals(ctx.getSource().getPlayer());

        return 0;
    }

    private static int procreate(CommandContext<ServerCommandSource> ctx) {
        ServerInteractionManager.getInstance().procreate(ctx.getSource().getPlayer());
        return 0;
    }

    private static int separate(CommandContext<ServerCommandSource> ctx) {
        ServerInteractionManager.getInstance().endMarriage(ctx.getSource().getPlayer());
        return 0;
    }

    private static int reject(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerPlayerEntity target = EntityArgumentType.getPlayer(ctx, "target");
        ServerInteractionManager.getInstance().rejectProposal(ctx.getSource().getPlayer(), target);
        return 0;
    }


    private static ArgumentBuilder<ServerCommandSource, ?> register(String name, com.mojang.brigadier.Command<ServerCommandSource> cmd) {
        return CommandManager.literal(name).requires(cs -> cs.hasPermissionLevel(0)).executes(cmd);
    }

    private static ArgumentBuilder<ServerCommandSource, ?> register(String name) {
        return CommandManager.literal(name).requires(cs -> cs.hasPermissionLevel(0));
    }

    private static void sendMessage(CommandContext<ServerCommandSource> ctx, String message) {
        sendMessage(ctx, Text.literal(message));
    }

    private static void sendMessage(CommandContext<ServerCommandSource> ctx, Text message) {
        ServerPlayerEntity player = ctx.getSource().getPlayer();
        if (player != null) {
            player.sendMessage(message);
        }
    }
}

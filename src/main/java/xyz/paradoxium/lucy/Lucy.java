package xyz.paradoxium.lucy;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.util.logging.ExceptionLogger;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import xyz.paradoxium.lucy.audio.PlayerManager;
import xyz.paradoxium.lucy.commands.LeaveCommand;
import xyz.paradoxium.lucy.commands.PlayCommand;
import xyz.paradoxium.lucy.commands.SkipCommand;
import xyz.paradoxium.lucy.commands.StopCommand;

public class Lucy {

    public static void main(String[] args) {
        // Setup Loggers.
        FallbackLoggerConfiguration.setTrace(false);
        
        // Initializes the AudioPlayerManager.
        PlayerManager.init();
        
        System.out.println("The bot is starting up...");
        // Generates the Discord API Builder.
        new DiscordApiBuilder()
                .setToken(System.getenv("token"))
                .setAllIntentsExcept(Intent.GUILD_MESSAGE_TYPING, Intent.DIRECT_MESSAGE_TYPING, Intent.GUILD_INTEGRATIONS, Intent.GUILD_WEBHOOKS, Intent.GUILD_INVITES, Intent.GUILD_INTEGRATIONS,
                        Intent.GUILD_BANS, Intent.GUILD_EMOJIS, Intent.DIRECT_MESSAGES, Intent.GUILD_MESSAGE_TYPING, Intent.GUILD_MESSAGE_REACTIONS, Intent.GUILD_PRESENCES, Intent.DIRECT_MESSAGE_TYPING,
                        Intent.DIRECT_MESSAGE_REACTIONS)
                .setRecommendedTotalShards()
                .join()
                .loginAllShards()
                .forEach(shardFuture -> shardFuture
                        .thenAccept(Lucy::onShardLogin)
                        .exceptionally(ExceptionLogger.get())
                );
    }

    private static void onShardLogin(DiscordApi api){

        System.out.println("Connected to shard " + api.getCurrentShard());

        // Performance tasks.
        api.setAutomaticMessageCacheCleanupEnabled(true);
        api.setMessageCacheSize(10, 60 * 5);
        api.setReconnectDelay(attempt -> attempt * 2);

        // Adds all the commands.
        api.addListener(new PlayCommand());
        api.addListener(new SkipCommand());
        api.addListener(new StopCommand());
        api.addListener(new LeaveCommand());

        // Prints out that the bot is now up and running.
        System.out.println("The bot is now running >w<!");
    }

}

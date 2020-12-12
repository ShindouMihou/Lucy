package xyz.paradoxium.lucy.base;

import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public abstract class ServerCommand implements MessageCreateListener {

    /*
     * This exists to ease off
     * everything in my case.
     */

    private String command;
    private String prefix = ".";

    protected ServerCommand(String command){
        this.command = command;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        /*
         * The first two returns are useless.
         * since there are ifPresents at the end.
         * but i'll just place them there.
         */

        if(!event.isServerMessage())
            return;

        if(!event.getMessageAuthor().isRegularUser())
            return;

        if(!event.getMessageContent().startsWith(prefix+command))
            return;

        // Runs everything.
        event.getServer().ifPresent(server -> event.getMessageAuthor().asUser().ifPresent(user ->
                event.getServerTextChannel().ifPresent(serverTextChannel -> runCommand(event, server, serverTextChannel, user, event.getMessageContent().split(" ")))));
    }

    protected abstract void runCommand(MessageCreateEvent event, Server server, ServerTextChannel channel, User user, String[] args);
}

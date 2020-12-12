package xyz.paradoxium.lucy.commands;

import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import xyz.paradoxium.lucy.audio.AudioManager;
import xyz.paradoxium.lucy.base.ServerCommand;

public class SkipCommand extends ServerCommand {

    public SkipCommand(){
        super("skip");
    }

    @Override
    protected void runCommand(MessageCreateEvent event, Server server, ServerTextChannel channel, User user, String[] args) {
        // Checks if there are any audio connection.
        server.getAudioConnection().ifPresentOrElse(connection -> {

            // If there is an audio connection then we skip the track.
            AudioManager.get(server.getId()).scheduler.nextTrack();
            event.getChannel().sendMessage("We have skipped the tracked");

        }, () -> event.getChannel().sendMessage("The bot doesn't seem to be playing any music."));
    }
}

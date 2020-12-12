package xyz.paradoxium.lucy.commands;

import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import xyz.paradoxium.lucy.audio.AudioManager;
import xyz.paradoxium.lucy.base.ServerCommand;

public class LeaveCommand extends ServerCommand {

    public LeaveCommand(){
        super("leave");
    }

    @Override
    protected void runCommand(MessageCreateEvent event, Server server, ServerTextChannel channel, User user, String[] args) {
        server.getConnectedVoiceChannel(event.getApi().getYourself()).ifPresentOrElse(voiceChannel -> {
            // We leave the voice channel and cut off any music.
            server.getAudioConnection().ifPresentOrElse(connection -> {
                AudioManager.get(server.getId()).player.stopTrack();
                connection.close();
            }, () -> event.getChannel().sendMessage("The bot doesn't seem to be in any voice channel."));
        }, () -> event.getChannel().sendMessage("The bot doesn't seem to be in any voice channel."));
    }
}

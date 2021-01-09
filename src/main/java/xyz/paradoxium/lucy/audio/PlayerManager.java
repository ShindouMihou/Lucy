package xyz.paradoxium.lucy.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;

public class PlayerManager {

    // This is created because there is no need to have multiple AudioPlayerManager
    // as a single one can handle everything.
    // **IMPORTANT: PLEASE INITIALIZE THE PLAYERMANAGER ON YOUR MAIN CLASS BY CALLING PlayerManager.init()**

    private static final AudioPlayerManager manager = new DefaultAudioPlayerManager();

    /**
     * This is only here since we want to initialize the thing
     * from the start, from the YouTube Source, etc.
     */
    public static void init(){
        // Registers YouTubeAudioSearch with allow search.
        manager.registerSourceManager(new YoutubeAudioSourceManager(true));
    }

    /**
     * Retrieves the AudioPlayerManager.
     * @return AudioPlayerManager.
     */
    public static AudioPlayerManager getManager(){
        return manager;
    }
}

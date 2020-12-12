package xyz.paradoxium.lucy.audio;

import java.util.HashMap;
import java.util.Map;

public class AudioManager {

    /*
     * A custom class used to store
     * all the GuildMusicManagers to unify them all.
     */

    private static final Map<Long, ServerMusicManager> managers = new HashMap<>();

    /**
     * Retrieves the server music manager dedicated for the server.
     * @param server the server's identification number.
     * @return a ServerMusicManager.
     */
    public static ServerMusicManager get(long server) {
        // If it doesn't exist then we create one.
        if (!managers.containsKey(server)) {
            managers.put(server, new ServerMusicManager(PlayerManager.getManager()));
        }

        return managers.get(server);
    }

}

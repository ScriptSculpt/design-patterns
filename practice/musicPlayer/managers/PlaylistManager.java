package practice.musicPlayer.managers;

import java.util.Map;
import java.util.HashMap;

import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;

public class PlaylistManager {
    private static PlaylistManager INSTANCE;
    private Map<String, Playlist> playlists;

    private PlaylistManager() {
        System.out.println("PlaylistManager initialized...");
        playlists = new HashMap<>();
    }

    public static synchronized PlaylistManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlaylistManager();
        }
        return INSTANCE;
    }

    public void createPlaylist(Playlist playlist) {
        playlists.put(playlist.getName(), playlist);
    }

    public void addSongToPlaylist(Playlist playlist, Song song) {
        playlists.get(playlist.getName()).addSong(song);
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }

}

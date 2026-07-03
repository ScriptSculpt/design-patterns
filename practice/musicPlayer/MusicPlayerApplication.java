package practice.musicPlayer;

import java.util.ArrayList;
import java.util.List;

import practice.musicPlayer.enums.DeviceType;
import practice.musicPlayer.enums.StrategyType;
import practice.musicPlayer.facade.MusicPlayerFacade;
import practice.musicPlayer.managers.PlaylistManager;
import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;

public class MusicPlayerApplication {
    private static MusicPlayerApplication INSTANCE;
    List<Song> songs = new ArrayList<>();
    List<Playlist> playlists = new ArrayList<>();

    private MusicPlayerApplication() {
        // Private constructor to prevent instantiation
    }

    public static synchronized MusicPlayerApplication getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MusicPlayerApplication();
        }
        return INSTANCE;
    }

    public void createSong(String title, String artist, int duration, String path) {
        System.out.println("Creating song: " + title + " by " + artist + " with duration " + duration + " seconds at path: " + path);
        Song song = new Song(title, artist, duration, path);
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void createPlaylist(String playlistName) {
        System.out.println("Creating playlist: " + playlistName);
        Playlist playlist = new Playlist(playlistName);
        playlists.add(playlist);

        PlaylistManager.getInstance().createPlaylist(playlist);
        // Set the newly created playlist as the current playlist in the facade
        MusicPlayerFacade.getInstance().setCurrentPlaylist(playlist);
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        System.out.println("Adding song: " + song.getTitle() + " to playlist: " + playlistName);
        
        Playlist playlist = PlaylistManager.getInstance().getPlaylists().get(playlistName);
        playlist.addSong(song);
    }

    void connectAudioDevice(DeviceType deviceType) {
        MusicPlayerFacade.getInstance().connectToDevice(deviceType);
    }

    void setPlayStrategy(StrategyType strategyType) {
        MusicPlayerFacade.getInstance().setPlayStrategy(strategyType);
    }

    void loadPlaylist(String playlistName) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    void playSong(String songName) {
        MusicPlayerFacade.getInstance().playSong(songName);
    }

    void pauseSong() {
        MusicPlayerFacade.getInstance().pauseSong();
    }

    void playAllSongsInPlaylist() {
        MusicPlayerFacade.getInstance().playAllSongsInPlaylist();
    }

    void playNextSong() {
        MusicPlayerFacade.getInstance().playNextSong();
    }

    void playPreviousSong() {
        MusicPlayerFacade.getInstance().playPreviousSong();
    }

    




}

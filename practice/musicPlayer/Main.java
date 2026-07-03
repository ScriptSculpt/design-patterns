package practice.musicPlayer;

import practice.musicPlayer.enums.DeviceType;
import practice.musicPlayer.enums.StrategyType;

public class Main {
    public static void main(String[] args) {
        MusicPlayerApplication app = MusicPlayerApplication.getInstance();

        app.createSong("Song 1", "Artist 1", 210, "/path/to/song1.mp3");
        app.createSong("Song 2", "Artist 2", 180, "/path/to/song2.mp3");
        app.createSong("Song 3", "Artist 3", 240, "/path/to/song3.mp3");

        app.createPlaylist("Playlist 1");
        app.addSongToPlaylist("Playlist 1", app.getSongs().get(0));
        app.addSongToPlaylist("Playlist 1", app.getSongs().get(1));
        app.addSongToPlaylist("Playlist 1", app.getSongs().get(2));

        app.connectAudioDevice(DeviceType.HEADPHONES);
        app.setPlayStrategy(StrategyType.SEQUENTIAL);
        app.playAllSongsInPlaylist();
        app.playPreviousSong();
        app.playNextSong();

        System.out.println(" ---------------------------------------------------- ");
        app.setPlayStrategy(StrategyType.SHUFFLE);
        app.playAllSongsInPlaylist();

        System.out.println(" ---------------------------------------------------- ");
        app.setPlayStrategy(StrategyType.CUSTOM);
        app.playSong("Song 2");
        app.playNextSong();
        app.playPreviousSong();
        app.playNextSong();

        System.out.println(" ---------------------------------------------------- ");
        app.pauseSong();

        System.out.println(" ---------------------------------------------------- ");
        app.connectAudioDevice(DeviceType.BLUETOOTH);
        app.playSong("Song 1");
        app.playNextSong();
        app.playPreviousSong();
    }
}

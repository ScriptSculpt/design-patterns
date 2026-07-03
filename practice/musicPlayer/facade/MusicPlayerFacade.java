package practice.musicPlayer.facade;

import practice.musicPlayer.adaptors.AudioOutputDevice;
import practice.musicPlayer.engine.AudioEngine;
import practice.musicPlayer.enums.DeviceType;
import practice.musicPlayer.enums.StrategyType;
import practice.musicPlayer.managers.DeviceManager;
import practice.musicPlayer.managers.PlaylistManager;
import practice.musicPlayer.managers.StrategyManager;
import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;
import practice.musicPlayer.strategy.PlayStrategy;

public class MusicPlayerFacade {
    private static MusicPlayerFacade INSTANCE;
    private AudioEngine audioEngine;
    private Playlist currentPlaylist;
    private PlayStrategy playStrategy;
    private AudioOutputDevice audioOutputDevice;
    private Song currentSong;

    private MusicPlayerFacade() {
        audioEngine = new AudioEngine();
    }

    public static synchronized MusicPlayerFacade getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MusicPlayerFacade();
        }
        return INSTANCE;
    }

    public void setPlayStrategy(StrategyType strategyType) {
        StrategyManager.getInstance().setStrategy(strategyType);
        this.playStrategy = StrategyManager.getInstance().getStrategy();
        if (this.currentPlaylist != null && this.playStrategy != null) {
            this.playStrategy.setPlaylist(this.currentPlaylist);
        }
    }

    public void connectToDevice(DeviceType deviceType) {
        DeviceManager.getInstance().connectToDevice(deviceType);
        this.audioOutputDevice = DeviceManager.getInstance().getCurrentDevice();
    }

    public void setCurrentPlaylist(Playlist playlist) {
        this.currentPlaylist = playlist;
        if (playStrategy != null) {
            playStrategy.setPlaylist(playlist);
        }
    }

    public void loadPlaylist(String playlistName) {
        this.currentPlaylist = PlaylistManager.getInstance().getPlaylists().get(playlistName);
        if (playStrategy != null) {
            playStrategy.setPlaylist(currentPlaylist);
        }
    }

    public void playSong(String songName) {
        if(!DeviceManager.getInstance().hasConnectedDevice()) {
            System.out.println("No audio output device connected. Please connect a device first.");
            return;
        }

        Song song = currentPlaylist.getSongs().stream()
            .filter(s -> s.getTitle().equals(songName))
            .findFirst()
            .orElse(null);
        this.currentSong = song;
        // let the play strategy know which song is being played so it can update its state
        if (this.playStrategy != null && song != null) {
            this.playStrategy.playSong(song);
        }
        audioEngine.play(this.audioOutputDevice, song);
    }

    public void pauseSong() {
        audioEngine.pause(currentSong);
    }

    public void playAllSongsInPlaylist() {
        if (currentPlaylist == null) {
            System.out.println("No playlist is currently loaded.");
            return;
        }
        for (Song song : currentPlaylist.getSongs()) {
            playSong(song.getTitle());
        }
    }

    public void playNextSong() {
        if(!DeviceManager.getInstance().hasConnectedDevice()) {
            System.out.println("No audio output device connected. Please connect a device first.");
            return;
        }
        if (playStrategy != null && playStrategy.hasNext()) {
            Song nextSong = playStrategy.nextSong();
            if (nextSong != null) {
                this.currentSong = nextSong;
                // play directly to avoid re-notifying the strategy (which would reset its history)
                audioEngine.play(this.audioOutputDevice, nextSong);
            } else {
                System.out.println("No next song available.");
            }
        } else {
            System.out.println("No play strategy set or no next song available.");
        }
    }

    public void playPreviousSong() {
        if(!DeviceManager.getInstance().hasConnectedDevice()) {
            System.out.println("No audio output device connected. Please connect a device first.");
            return;
        }
        if (playStrategy != null && playStrategy.hasPrevious()) {
            Song previousSong = playStrategy.previousSong();
            if (previousSong != null) {
                this.currentSong = previousSong;
                // play directly so strategy history is preserved
                audioEngine.play(this.audioOutputDevice, previousSong);
            } else {
                System.out.println("No previous song available.");
            }
        } else {
            System.out.println("No play strategy set or no previous song available.");
        }
    }
}

package practice.musicPlayer.engine;

import practice.musicPlayer.adaptors.AudioOutputDevice;
import practice.musicPlayer.models.Song;

public class AudioEngine {
    private Song currentSong;

    public void play(AudioOutputDevice device, Song song) {
        this.currentSong = song;
        device.playAudio(song);
    }

    public void pause(Song song) {
        if(currentSong != song) {
            System.out.println("Cannot pause a different song.");
            return;
        }
        System.out.println("Pausing: " + currentSong.getTitle());
    }
}

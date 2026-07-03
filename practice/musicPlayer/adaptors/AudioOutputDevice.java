package practice.musicPlayer.adaptors;

import practice.musicPlayer.models.Song;

public interface AudioOutputDevice {
    void playAudio(Song song);
}

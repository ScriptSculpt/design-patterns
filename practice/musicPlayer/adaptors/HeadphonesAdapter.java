package practice.musicPlayer.adaptors;

import practice.musicPlayer.external.HeadphonesAPI;
import practice.musicPlayer.models.Song;

public class HeadphonesAdapter implements AudioOutputDevice {
    private HeadphonesAPI headphonesAPI;

    public HeadphonesAdapter(HeadphonesAPI headphonesAPI) {
        this.headphonesAPI = headphonesAPI;
    }

    @Override
    public void playAudio(Song song) {
        headphonesAPI.playHeadphonesMusic(song.getTitle());
    }
}

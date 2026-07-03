package practice.musicPlayer.adaptors;

import practice.musicPlayer.external.BluetoothAPI;
import practice.musicPlayer.models.Song;

public class BluetoothAdapter implements AudioOutputDevice {
    private BluetoothAPI bluetoothAPI;

    public BluetoothAdapter(BluetoothAPI bluetoothAPI) {
        this.bluetoothAPI = bluetoothAPI;
    }

    @Override
    public void playAudio(Song song) {
        bluetoothAPI.playBluetoothMusic(song.getTitle());
    }
    
}

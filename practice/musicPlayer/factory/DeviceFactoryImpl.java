package practice.musicPlayer.factory;

import practice.musicPlayer.adaptors.AudioOutputDevice;
import practice.musicPlayer.adaptors.BluetoothAdapter;
import practice.musicPlayer.adaptors.HeadphonesAdapter;
import practice.musicPlayer.enums.DeviceType;
import practice.musicPlayer.external.BluetoothAPI;
import practice.musicPlayer.external.HeadphonesAPI;

/**
 * Device
 */
public class DeviceFactoryImpl implements DeviceFactory {

    @Override
    public AudioOutputDevice createDevice(DeviceType deviceType) {
        switch (deviceType) {
            case BLUETOOTH:
                return new BluetoothAdapter(new BluetoothAPI());
            case HEADPHONES:
                return new HeadphonesAdapter(new HeadphonesAPI());
            default:
                throw new IllegalArgumentException("Invalid device type: " + deviceType);
        }
    }
    
}

package practice.musicPlayer.managers;

import practice.musicPlayer.adaptors.AudioOutputDevice;
import practice.musicPlayer.enums.DeviceType;
import practice.musicPlayer.factory.DeviceFactory;
import practice.musicPlayer.factory.DeviceFactoryImpl;

public class DeviceManager {
    private static DeviceManager INSTANCE;

    private AudioOutputDevice currentDevice;

    private DeviceManager() {
        System.out.println("DeviceManager initialized...");
    }
    
    public static synchronized DeviceManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DeviceManager();
        }
        return INSTANCE;
    }

    public void connectToDevice(DeviceType deviceType) {
        System.out.println("Connecting to device...");
        DeviceFactory deviceFactory = new DeviceFactoryImpl();
        currentDevice = deviceFactory.createDevice(deviceType);
    }

    public AudioOutputDevice getCurrentDevice() {
        return currentDevice;
    }

    public Boolean hasConnectedDevice() {
        return currentDevice != null;
    }

}

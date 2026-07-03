package practice.musicPlayer.factory;

import practice.musicPlayer.adaptors.AudioOutputDevice;
import practice.musicPlayer.enums.DeviceType;

public interface DeviceFactory {
    AudioOutputDevice createDevice(DeviceType deviceType);
}

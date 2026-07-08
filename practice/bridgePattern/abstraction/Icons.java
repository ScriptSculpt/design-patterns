package practice.bridgePattern.abstraction;

import practice.bridgePattern.implementation.OS;

public abstract class Icons {
    protected OS takenOS;

    public Icons(OS takenOS) {
        this.takenOS = takenOS;
    }

    public abstract void loadIcon();
}

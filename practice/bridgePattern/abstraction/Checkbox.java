package practice.bridgePattern.abstraction;

import practice.bridgePattern.implementation.OS;

public class Checkbox extends Icons {

    public Checkbox(OS takenOS) {
        super(takenOS);
    }

    @Override
    public void loadIcon() {
        takenOS.spec();
        System.out.println("Loading checkbox icon");
    }
    
}

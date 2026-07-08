package practice.bridgePattern.abstraction;

import practice.bridgePattern.implementation.OS;

public class Radio extends Icons{

    public Radio(OS takenOS) {
        super(takenOS); 
    }

    @Override
    public void loadIcon() {
        takenOS.spec();
        System.out.println("Radio Icon");
    }
    
}

package practice.bridgePattern;

import practice.bridgePattern.abstraction.Checkbox;
import practice.bridgePattern.abstraction.Icons;
import practice.bridgePattern.abstraction.Radio;
import practice.bridgePattern.implementation.MacOS;
import practice.bridgePattern.implementation.OS;
import practice.bridgePattern.implementation.Windows;

public class Main {
    public static void main(String[] args) {
        OS os1 = new MacOS();
        OS os2 = new Windows();

        Icons radio = new Radio(os1);
        Icons checkbox = new Checkbox(os2);

        
        radio.loadIcon();
        checkbox.loadIcon();

    }
}

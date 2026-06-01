package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.Flyable;

public class JetFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("Jet flying");
    }
    
}

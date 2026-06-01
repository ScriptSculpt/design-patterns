package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.Flyable;

public class NoFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("No flying");
    }
}

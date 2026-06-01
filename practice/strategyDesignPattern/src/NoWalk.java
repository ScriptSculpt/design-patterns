package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.Walkable;

public class NoWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("No walking");
    }
}

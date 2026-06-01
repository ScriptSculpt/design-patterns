package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.Walkable;

public class NormalWalk implements Walkable {
    
    @Override
    public void walk() {
        System.out.println("Normal walking");
    }
}

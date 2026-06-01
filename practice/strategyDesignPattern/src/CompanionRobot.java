package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.*;

public class CompanionRobot extends Robot {
    public CompanionRobot(Flyable flyable, Walkable walkable, Talkable talkable) {
        super(flyable, walkable, talkable);
    }

    @Override
    public void look() {
        System.out.println("Companion Robot has a cute look");
    }
    
}

package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.*;

public class WorkerRobot extends Robot{
    public WorkerRobot(Flyable flyable, Walkable walkable, Talkable talkable) {
        super(flyable, walkable, talkable);
    }

    @Override
    public void look() {
        System.out.println("Worker Robot has a strong look");
    }
}

package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.*;

public abstract class Robot {

    Flyable flyable;
    Walkable walkable;
    Talkable talkable;

    public Robot(Flyable flyable, Walkable walkable, Talkable talkable) {
        this.flyable = flyable;
        this.walkable = walkable;
        this.talkable = talkable;
    }

    public void fly() {
        flyable.fly();
    }

    public void walk() {
        walkable.walk();
    }

    public void talk() {
        talkable.talk();
    }
    
    public abstract void look();

}

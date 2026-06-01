package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.Talkable;

public class NormalTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Normal talking");
    }
    
}

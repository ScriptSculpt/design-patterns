package practice.strategyDesignPattern.src;

import practice.strategyDesignPattern.src.interfaces.Talkable;

public class GibberishTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Gibberish talking");
    }
}

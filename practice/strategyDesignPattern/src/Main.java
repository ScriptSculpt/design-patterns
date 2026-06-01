package practice.strategyDesignPattern.src;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new JetFly(), new NormalWalk(), new NormalTalk());
        robot1.fly();
        robot1.walk();
        robot1.talk();

        System.out.println("--------------Changing robot's behaviour at runtime--------------");
        Robot robot2 = new Robot(new NoFly(), new NoWalk(), new GibberishTalk());
        robot2.fly();
        robot2.walk();
        robot2.talk();
    }
}

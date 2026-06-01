package practice.strategyDesignPattern.src;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new JetFly(), new NormalWalk(), new NormalTalk());
        robot1.fly();
        robot1.walk();
        robot1.talk();
        robot1.look();

        System.out.println("--------------Changing robot's behaviour at runtime--------------");
        Robot robot2 = new WorkerRobot(new NoFly(), new NoWalk(), new GibberishTalk());
        robot2.fly();
        robot2.walk();
        robot2.talk();
        robot2.look();
    }
}

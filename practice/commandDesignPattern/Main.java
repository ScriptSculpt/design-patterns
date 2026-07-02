package practice.commandDesignPattern;

public class Main {
    public static void main(String[] args) {
        Requester requester = new Requester(3);

        Receiver1 receiver1 = new Receiver1();
        Receiver2 receiver2 = new Receiver2();

        requester.addCommand(new CommandExecutor1(receiver1), 0);
        requester.addCommand(new CommandExecutor2(receiver2), 1);

        requester.executeCommand(0);
        requester.executeCommand(1);
        requester.executeCommand(0);
        requester.executeCommand(1);
        requester.executeCommand(2);
        requester.executeCommand(3);
    }
}

package practice.commandDesignPattern;

public class CommandExecutor1 implements Command {

    private Receiver1 receiver;

    public CommandExecutor1(Receiver1 receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }

    @Override
    public void undo() {
        receiver.turnOff();
    }
    
}

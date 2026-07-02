package practice.commandDesignPattern;

public class CommandExecutor2 implements Command {
    private Receiver2 receiver;

    public CommandExecutor2(Receiver2 receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.start();
    }

    @Override
    public void undo() {
        receiver.stop();
    }
    
}

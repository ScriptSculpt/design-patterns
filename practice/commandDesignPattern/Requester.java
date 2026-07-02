package practice.commandDesignPattern;

import java.util.Vector;

public class Requester {
    Vector<Command> commandList = new Vector<>();
    Vector<Boolean> pressed = new Vector<>();

    public Requester(int n) {
        for (int i = 0; i < n; i++) {
            pressed.add(false);
            commandList.add(null);
        }
    }

    public void addCommand(Command command, int idx) {
        commandList.set(idx, command);
    }

    public void executeCommand(int idx) {
        if (idx < 0 || idx >= commandList.size()) {
            System.out.println("Invalid index: " + idx);
            return;
        }
        if (commandList.get(idx) == null) {
            System.out.println("No command found at index " + idx);
            return;
        }
        if (pressed.get(idx)) {
            commandList.get(idx).undo();
            pressed.set(idx, false);
            return;
        }
        commandList.get(idx).execute();
        pressed.set(idx, true);
    }
}

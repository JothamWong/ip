package command;

import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.List;

public class MarkCommand implements Command {
    private final int markIdx;

    public MarkCommand(int markIdx) {
        this.markIdx = markIdx;
    }

    public static MarkCommand fromInput(String[] arguments) throws PepeException {
        int markIdx;
        if (arguments.length != 1) {
            throw new PepeException("Invalid number of arguments");
        }
        try {
            markIdx = Integer.parseInt(arguments[0]) - 1;
        } catch (NumberFormatException e) {
            throw new PepeException("Invalid mark index " + arguments[0]);
        }
        return new MarkCommand(markIdx);
    }

    @Override
    public boolean execute(Ui ui, List<Task> tasks) throws PepeException {
        if (tasks.size() <= markIdx) {
            throw new PepeException("Submitted task idx is out of bounds");
        }
        Task task = tasks.get(markIdx);
        task.setDone(true);
        String message = "    Nice! I've marked this task as done:\n    %s\n".formatted(task);
        ui.printMessage(message);
        return true;
    }
}

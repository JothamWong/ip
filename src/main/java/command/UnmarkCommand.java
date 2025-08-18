package command;

import misc.PepeException;
import state.Storage;
import state.Ui;
import tasks.Task;

import java.util.List;

public class UnmarkCommand implements Command {
    private final int unmarkIdx;

    public UnmarkCommand(int unmarkIdx) {
        this.unmarkIdx = unmarkIdx;
    }

    public static UnmarkCommand fromInput(String[] arguments) throws PepeException {
        int markIdx;
        if (arguments.length != 1) {
            throw new PepeException("Invalid number of arguments");
        }
        try {
            markIdx = Integer.parseInt(arguments[0]) - 1;
        } catch (NumberFormatException e) {
            throw new PepeException("Invalid mark index " + arguments[0]);
        }
        return new UnmarkCommand(markIdx);
    }

    @Override
    public boolean execute(Ui ui, Storage storage, List<Task> tasks) throws PepeException {
        if (tasks.size() <= unmarkIdx) {
            throw new PepeException("Submitted task idx is out of bounds");
        }
        Task task = tasks.get(unmarkIdx);
        task.setDone(false);
        storage.saveTasks(tasks);
        String message = "     OK, I've marked this task as not done yet:\n    %s\n".formatted(task);
        ui.printMessage(message);
        return true;
    }
}

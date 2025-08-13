package command;

import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.List;

public class AddToListCommand implements Command {
    private final Task task;

    public AddToListCommand(Task task) {
        this.task = task;
    }

    @Override
    public boolean execute(Ui ui, List<Task> tasks) throws PepeException {
        tasks.add(task);
        String message = "Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n".formatted(task, tasks.size());
        ui.printMessage(message);
        return true;
    }
}

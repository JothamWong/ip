package command;

import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.List;

public class DeleteCommand implements Command {
    private final int deleteIdx;

    public DeleteCommand(int deleteIdx) {
        this.deleteIdx = deleteIdx;
    }

    public static DeleteCommand fromInput(String[] arguments) throws PepeException {
        int deleteIdx;
        if (arguments.length != 1) {
            throw new PepeException("Invalid number of arguments");
        }
        try {
            deleteIdx = Integer.parseInt(arguments[0]) - 1;
        } catch (NumberFormatException e) {
            throw new PepeException("Invalid delete index " + arguments[0]);
        }
        return new DeleteCommand(deleteIdx);
    }

    @Override
    public boolean execute(Ui ui, List<Task> tasks) throws PepeException {
        if (tasks.size() <= deleteIdx) {
            throw new PepeException("Submitted task idx is out of bounds");
        }
        Task task = tasks.get(deleteIdx);
        tasks.remove(deleteIdx);
        String message = "Noted. I've removed this task:\n  %s\nNow you have %d tasks in the list.\n".formatted(task, tasks.size());
        ui.printMessage(message);
        return true;
    }
}

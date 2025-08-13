package command;

import exceptions.PepeException;
import tasks.Task;

import java.util.List;

public class MarkCommand implements Command {
    private final int markIdx;

    public MarkCommand(int markIdx) {
        this.markIdx = markIdx;
    }

    @Override
    public boolean execute(List<Task> tasks) throws PepeException {
        if (tasks.size() <= markIdx) {
            throw new PepeException("Submitted task idx is out of bounds");
        }
        System.out.println(delimiter);
        System.out.println("    Nice! I've marked this task as done:\n");
        Task task = tasks.get(markIdx);
        task.setDone(true);
        System.out.println("    " + task);
        System.out.println(delimiter);
        return true;
    }
}

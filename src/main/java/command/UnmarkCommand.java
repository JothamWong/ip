package command;

import exceptions.PepeException;
import tasks.Task;

import java.util.List;

public class UnmarkCommand implements Command {
    private final int unmarkIdx;

    public UnmarkCommand(int unmarkIdx) {
        this.unmarkIdx = unmarkIdx;
    }

    @Override
    public boolean execute(List<Task> tasks) throws PepeException {
        if (tasks.size() <= unmarkIdx) {
            throw new PepeException("Submitted task idx is out of bounds");
        }
        System.out.println(delimiter);
        System.out.println("     OK, I've marked this task as not done yet:\n");
        Task task = tasks.get(unmarkIdx);
        task.setDone(false);
        System.out.println("    " + task);
        System.out.println(delimiter);
        return true;
    }
}

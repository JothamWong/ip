package command;

import tasks.Task;

import java.util.List;

public interface Command {
    /**
     * Executes the command and returns true if the program should continue
     */
    boolean execute(List<Task> tasks);
}

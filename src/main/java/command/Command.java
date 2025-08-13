package command;

import exceptions.PepeException;
import tasks.Task;

import java.util.List;

public interface Command {
    public static final String delimiter = "____________________________________________________________";
    /**
     * Executes the command and returns true if the program should continue
     */
    boolean execute(List<Task> tasks) throws PepeException;
}

package command;

import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.List;

public interface Command {
    /**
     * Executes the command and returns true if the program should continue
     */
    boolean execute(Ui ui, List<Task> tasks) throws PepeException;
}

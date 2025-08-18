package command;

import misc.PepeException;
import state.Storage;
import state.Ui;
import tasks.Task;

import java.util.List;

public interface Command {
    /**
     * Executes the command and returns true if the program should continue
     */
    boolean execute(Ui ui, Storage storage, List<Task> tasks) throws PepeException;
}

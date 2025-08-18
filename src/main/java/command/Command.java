package command;

import misc.PepeException;
import state.Storage;
import state.TaskList;
import state.Ui;

/**
 * Base interface that all user interaction with Pepe implements.
 */
public interface Command {
    /**
     * Executes the command and returns true if the program should continue
     */
    boolean execute(Ui ui, Storage storage, TaskList tasks) throws PepeException;
}

package command;

import misc.PepeException;
import state.Storage;
import state.TaskList;
import state.Ui;

/**
 * Command to display the current task list stored by Pepe.
 */
public class DisplayListCommand implements Command {
    @Override
    public boolean execute(Ui ui, Storage storage, TaskList tasks) throws PepeException {
        ui.displayTaskList(tasks);
        return true;
    }
}

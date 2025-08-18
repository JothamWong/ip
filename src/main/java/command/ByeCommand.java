package command;

import misc.PepeException;
import state.Storage;
import state.TaskList;
import state.Ui;

public class ByeCommand implements Command {
    private static final String byeResponse = "Bye. Hope to see you again soon!";

    @Override
    public boolean execute(Ui ui, Storage storage, TaskList tasks) throws PepeException {
        ui.printMessage(byeResponse);
        return false;
    }
}

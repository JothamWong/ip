package command;

import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.List;

public class ByeCommand implements Command {
    private static final String byeResponse = "Bye. Hope to see you again soon!";

    @Override
    public boolean execute(Ui ui, List<Task> tasks) throws PepeException {
        ui.printMessage(byeResponse);
        return false;
    }
}

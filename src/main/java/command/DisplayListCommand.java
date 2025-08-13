package command;

import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.List;

public class DisplayListCommand implements Command {
    @Override
    public boolean execute(Ui ui, List<Task> tasks) throws PepeException {
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            messageBuilder.append((i + 1) + ". " + tasks.get(i) + "\n");
        }
        ui.printMessage(messageBuilder.toString());
        return true;
    }
}

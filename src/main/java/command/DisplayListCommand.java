package command;

import misc.PepeException;
import state.Storage;
import state.Ui;
import tasks.Task;

import java.util.List;

public class DisplayListCommand implements Command {
    @Override
    public boolean execute(Ui ui, Storage storage, List<Task> tasks) throws PepeException {
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            messageBuilder.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
        }
        ui.printMessage(messageBuilder.toString());
        return true;
    }
}

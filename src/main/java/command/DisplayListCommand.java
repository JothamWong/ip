package command;

import exceptions.PepeException;
import tasks.Task;

import java.util.List;

public class DisplayListCommand implements Command {
    @Override
    public boolean execute(List<Task> tasks) throws PepeException {
        System.out.println(delimiter);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println(delimiter);
        return true;
    }
}

package command;

import exceptions.PepeException;
import tasks.Task;

import java.util.List;

public class ByeCommand implements Command {
    private static final String byeResponse = "Bye. Hope to see you again soon!";

    @Override
    public boolean execute(List<Task> tasks) throws PepeException {
        System.out.println(delimiter);
        System.out.println(byeResponse);
        System.out.println(delimiter);
        return false;
    }
}

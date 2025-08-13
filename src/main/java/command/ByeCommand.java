package command;

import tasks.Task;

import java.util.List;

public class ByeCommand implements Command {
    private static final String byeResponse = "Bye. Hope to see you again soon!";

    @Override
    public boolean execute(List<Task> tasks) {
        System.out.println(byeResponse);
        return false;
    }
}

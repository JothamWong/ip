package command;

import tasks.Task;

import java.util.List;

public class DisplayListCommand implements Command {
    @Override
    public boolean execute(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        return true;
    }
}

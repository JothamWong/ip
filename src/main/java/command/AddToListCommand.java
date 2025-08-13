package command;

import tasks.Task;

import java.util.List;

public class AddToListCommand implements Command {
    private final String addInput;

    public AddToListCommand(String addInput) {
        this.addInput = addInput;
    }

    @Override
    public boolean execute(List<Task> tasks) {
        tasks.add(new Task(addInput));
        System.out.println("added: " + this.addInput);
        return true;
    }
}

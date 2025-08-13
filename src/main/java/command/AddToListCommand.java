package command;

import exceptions.PepeException;
import tasks.Task;

import java.util.List;

public class AddToListCommand implements Command {
    private final String addInput;

    public AddToListCommand(String addInput) {
        this.addInput = addInput;
    }

    @Override
    public boolean execute(List<Task> tasks) throws PepeException {
        System.out.println(delimiter);
        tasks.add(new Task(addInput));
        System.out.println("added: " + this.addInput);
        System.out.println(delimiter);
        return true;
    }
}

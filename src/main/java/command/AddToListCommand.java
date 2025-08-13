package command;

import java.util.List;

public class AddToListCommand implements Command {
    private final String addInput;

    public AddToListCommand(String addInput) {
        this.addInput = addInput;
    }

    @Override
    public boolean execute(List<String> tasks) {
        tasks.add(this.addInput);
        System.out.println("added: " + this.addInput);
        return true;
    }
}

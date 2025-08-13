package tasks;

import misc.PepeException;

public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    public static Todo fromInput(String[] inputs) throws PepeException {
        if (inputs.length == 0) {
            throw new PepeException("Empty name for todo.");
        }
        return new Todo(String.join(" ", inputs));
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

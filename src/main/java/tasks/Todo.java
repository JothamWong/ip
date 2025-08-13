package tasks;

import misc.PepeException;

import java.util.StringJoiner;

public class Todo extends Task {
    public Todo(String name) {
        super(name);
    }

    public static Todo fromInput(String[] inputs) {
        return new Todo(String.join(" ", inputs));
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

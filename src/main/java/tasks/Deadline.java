package tasks;

import misc.PepeException;

import java.util.StringJoiner;

public class Deadline extends Task {

    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public static Deadline fromInput(String[] inputs) throws PepeException {
        int index = 0;

        StringJoiner name = new StringJoiner(" ");
        for (; index < inputs.length; index++) {
            String input = inputs[index];
            if (input.equals("/by")) {
                index++; // advance past /by
                break;
            } else {
                name.add(input);
            }
        }

        if (name.length() == 0) {
            throw new PepeException("Empty name for deadline.");
        }

        StringJoiner by = new StringJoiner(" ");
        for (; index < inputs.length; index++) {
            by.add(inputs[index]);
        }

        if (by.length() == 0) {
            throw new PepeException("Deadline not specified.");
        }

        return new Deadline(name.toString(), by.toString());
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

package tasks;

import misc.PepeException;

import java.util.StringJoiner;

public class Deadline extends Task {

    private final String by;

    public Deadline(String name, String by) {
        this(name, by, false);
    }

    private Deadline(String name, String by, boolean isDone) {
        super(name, isDone);
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

    /**
     * Deserialize Deadline fromFileInput.
     * Expected format is {Type} | {Active} | {Name} | {Deadline}
     * @param inputs List of file inputs delimited by |
     * @return a deserialized Deadline object
     * @throws PepeException in event of parse error
     */
    public static Deadline fromFileInput(String[] inputs) throws PepeException {
        if (inputs.length != 4) {
            throw new PepeException("Invalid number of arguments.");
        }

        boolean isDone;
        if (inputs[1].equals("0")) {
            isDone = false;
        } else if (inputs[1].equals("1")) {
            isDone = true;
        } else {
            throw new PepeException("Invalid deadline format. Expected 1 or 0 for second argument but got " + inputs[1]);
        }

        if (inputs[2].isEmpty()) {
            throw new PepeException("Empty deadline name.");
        }

        if (inputs[3].isEmpty()) {
            throw new PepeException("Empty deadline by.");
        }

        return new Deadline(inputs[2], inputs[3], isDone);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

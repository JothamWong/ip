package tasks;

import misc.PepeException;

public class Deadline extends Task {

    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public static Deadline fromInput(String[] inputs) throws PepeException {
        int index = 0;

        StringBuilder name = new StringBuilder();
        for (; index < inputs.length; index++) {
            String input = inputs[index];
            if (input.equals("/by")) {
                index++; // advance past /by
                break;
            } else {
                name.append(input);
            }
        }

        if (name.isEmpty()) {
            throw new PepeException("Deadline's body expression is empty.");
        }

        StringBuilder by = new StringBuilder();
        for (; index < inputs.length; index++) {
            by.append(inputs[index]);
        }

        if (by.isEmpty()) {
            throw new PepeException("Deadline not specified.");
        }

        return new Deadline(name.toString(), by.toString());
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}

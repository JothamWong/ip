package tasks;

import misc.PepeException;

import java.util.StringJoiner;

public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String name, String from, String to) {
        this(name, from, to, false);
    }

    private Event(String name, String from, String to, boolean isDone) {
        super(name, isDone);
        this.from = from;
        this.to = to;
    }

    public static Event fromInput(String[] inputs) throws PepeException {
        int index = 0;

        StringJoiner name = new StringJoiner(" ");
        for (;index < inputs.length;index++) {
            String input = inputs[index];
            if (input.equals("/from")) {
                index++; // advance past /from
                break;
            } else if (input.equals("/to")) {
                throw new PepeException("Missing /from");
            } else {
                name.add(input);
            }
        }

        if (name.length() == 0) {
            throw new PepeException("Empty name for event.");
        }

        StringJoiner from = new StringJoiner(" ");
        for (;index < inputs.length;index++) {
            String input = inputs[index];
            if (input.equals("/from")) {
                throw new PepeException("Duplicate /from");
            } else if (input.equals("/to")) {
                index++; // advance past /to
                break;
            } else {
                from.add(input);
            }
        }

        if (from.length() == 0) {
            throw new PepeException("Missing /from body");
        }

        StringJoiner to = new StringJoiner(" ");
        for (;index < inputs.length;index++) {
            String input = inputs[index];
            if (input.equals("/from")) {
                throw new PepeException("Duplicate /from");
            } else if (input.equals("/to")) {
                throw new PepeException("Duplicate /to");
            } else {
                to.add(input);
            }
        }

        if (to.length() == 0) {
            throw new PepeException("Missing /to body");
        }

        return new Event(name.toString(), from.toString(), to.toString());
    }

    /**
     * Deserialize Event fromFileInput.
     * Expected format is {Type} | {Active} | {Name} | {From} | {To}
     * Example: E | 0 | project meeting | Aug 6th 2pm | Aug 6th 4pm
     * @param inputs List of file inputs delimited by |
     * @return a deserialized Event object
     * @throws PepeException in event of parse error
     */
    public static Event fromFileInput(String[] inputs) throws PepeException {
        if (inputs.length != 5) {
            throw new PepeException("Invalid number of arguments.");
        }

        boolean isDone;
        if (inputs[1].equals("0")) {
            isDone = false;
        } else if (inputs[1].equals("1")) {
            isDone = true;
        } else {
            throw new PepeException("Invalid event format. Expected 1 or 0 for second argument but got " + inputs[1]);
        }

        if (inputs[2].isEmpty()) {
            throw new PepeException("Empty event name.");
        }

        if (inputs[3].isEmpty()) {
            throw new PepeException("Empty event from.");
        }

        if (inputs[4].isEmpty()) {
            throw new PepeException("Empty event to.");
        }

        return new Event(inputs[2], inputs[3], inputs[4], isDone);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}

package tasks;

import misc.PepeException;

public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public static Event fromInput(String[] inputs) throws PepeException {
        int index = 0;

        StringBuilder name = new StringBuilder();
        for (;index < inputs.length;index++) {
            String input = inputs[index];
            if (input.equals("/from")) {
                index++; // advance past /from
                break;
            } else if (input.equals("/to")) {
                throw new PepeException("Missing /from");
            } else {
                name.append(input);
            }
        }

        StringBuilder from = new StringBuilder();
        for (;index < inputs.length;index++) {
            String input = inputs[index];
            if (input.equals("/from")) {
                throw new PepeException("Duplicate /from");
            } else if (input.equals("/to")) {
                index++; // advance past /to
                break;
            } else {
                from.append(input);
            }
        }

        if (from.isEmpty()) {
            throw new PepeException("Missing /from body");
        }

        StringBuilder to = new StringBuilder();
        for (;index < inputs.length;index++) {
            String input = inputs[index];
            if (input.equals("/from")) {
                throw new PepeException("Duplicate /from");
            } else if (input.equals("/to")) {
                throw new PepeException("Duplicate /to");
            } else {
                to.append(input);
            }
        }

        if (to.isEmpty()) {
            throw new PepeException("Missing /to body");
        }

        return new Event(name.toString(), from.toString(), to.toString());
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + "to: " + to + ")";
    }
}

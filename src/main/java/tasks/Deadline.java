package tasks;

import misc.PepeException;

import java.time.LocalDateTime;
import java.util.StringJoiner;

import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private final LocalDateTime by;

    private static final DateTimeFormatter serdeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter userFormatter = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm");

    public Deadline(String name, LocalDateTime by) {
        this(name, by, false);
    }

    private Deadline(String name, LocalDateTime by, boolean isDone) {
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

        // 0 1 2
        // /by m d
        // Deadline format is expected to be in yyyy-mm-dd TIME
        // Time in 2359 format
        if (index + 1 > inputs.length) {
            throw new PepeException("Expected deadline date formatted string yyyy-mm-dd HHmm.");
        }
        String deadlineString = inputs[index++] + inputs[index];
        LocalDateTime byTimeObject = LocalDateTime.parse(deadlineString, serdeFormatter);

        return new Deadline(name.toString(), byTimeObject);
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

        System.out.println(inputs[3]);
        LocalDateTime byTimeObject = LocalDateTime.parse(inputs[3], serdeFormatter);

        return new Deadline(inputs[2], byTimeObject, isDone);
    }

    /**
     * Serializes the Deadline class into a string suitable for saving to the file.
     * @return the serialized string for file saving.
     */
    @Override
    public String toFileInput() {
        return String.format("D | %s | %s | %s", this.getStatusFileIcon(), this.getName(), by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(userFormatter) + ")";
    }
}

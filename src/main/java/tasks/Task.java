package tasks;

import java.time.format.DateTimeFormatter;

public abstract class Task {
    private final String name;
    private boolean isDone;

    protected static final DateTimeFormatter serdeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    protected static final DateTimeFormatter userFormatter = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm");


    protected Task(String name) {
        this(name, false);
    }

    protected Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public String getStatusIcon() {
        return this.isDone ? "X" : " ";
    }

    public String getStatusFileIcon() {
        return this.isDone ? "1" : "0";
    }

    public String getName() {
        return this.name;
    }

    /**
     * Serializes the Task class into a string suitable for saving to the file.
     * @return the serialized string for file saving.
     */
    public abstract String toFileInput();

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.name;
    }
}

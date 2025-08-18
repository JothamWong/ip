package tasks;

public abstract class Task {
    private final String name;
    private boolean isDone;

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

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.name;
    }
}

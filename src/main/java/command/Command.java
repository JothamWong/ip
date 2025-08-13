package command;

import java.util.List;

public interface Command {
    /**
     * Executes the command and returns true if the program should continue
     */
    boolean execute(List<String> tasks);
}

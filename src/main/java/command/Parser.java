package command;

import misc.PepeException;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;

import java.util.Arrays;

public class Parser {
    public static Command parse(String input) throws PepeException {
        if (input == null || input.isEmpty()) {
            throw new PepeException("Empty command");
        }
        String[] tokens = input.split(" ");
        String command = tokens[0];
        String[] arguments = Arrays.copyOfRange(tokens,1, tokens.length);
        return switch(command) {
            case "list" -> new DisplayListCommand();
            case "bye" -> new ByeCommand();
            case "mark" -> MarkCommand.fromInput(arguments);
            case "unmark" -> UnmarkCommand.fromInput(arguments);
            case "event" -> new AddToListCommand(Event.fromInput(arguments));
            case "todo" -> new AddToListCommand(Todo.fromInput(arguments));
            case "deadline" -> new AddToListCommand(Deadline.fromInput(arguments));
            case "delete" -> DeleteCommand.fromInput(arguments);
            default -> throw new PepeException("Unknown command: " + command);
        };
    }
}

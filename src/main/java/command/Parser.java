package command;

import java.time.format.DateTimeParseException;
import java.util.Arrays;

import misc.PepeException;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;

/**
 * Class in charge of parsing all user inputs.
 */
public class Parser {
    /**
     * Parses a user-input into a command.
     * @param input The user-input
     * @return A command matching the input
     * @throws PepeException if user-input was invalid or unrecognized.
     */
    public static Command parse(String input) throws PepeException {
        if (input == null || input.isEmpty()) {
            throw new PepeException("Empty command");
        }
        String[] tokens = input.split(" ");
        String command = tokens[0];
        String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);
        try {
            return switch(command) {
            case "list" -> new DisplayListCommand();
            case "bye" -> new ByeCommand();
            case "mark" -> MarkCommand.fromInput(arguments);
            case "unmark" -> UnmarkCommand.fromInput(arguments);
            case "event" -> new AddToListCommand(Event.fromInput(arguments));
            case "todo" -> new AddToListCommand(Todo.fromInput(arguments));
            case "deadline" -> new AddToListCommand(Deadline.fromInput(arguments));
            case "delete" -> DeleteCommand.fromInput(arguments);
            case "find" -> FindCommand.fromInput(arguments);
            default -> throw new PepeException("Unknown command: " + command);
            };
        } catch (DateTimeParseException e) {
            throw new PepeException("Error parsing datetime: " + e.getMessage());
        }
    }
}

package command;

import exceptions.PepeException;

import java.util.Arrays;

public class Parser {
    public static Command parse(String input) throws PepeException {
        if (input == null || input.isEmpty()) {
            throw new PepeException("Empty command");
        }
        String[] tokens = input.split(" ");
        String command = tokens[0];
        String[] arguments = Arrays.copyOfRange(tokens,1, tokens.length);
        return switch(input) {
            case "list" -> new DisplayListCommand();
            case "bye" -> new ByeCommand();
            default -> new AddToListCommand(input);
        };
    }
}

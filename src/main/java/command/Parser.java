package command;

public class Parser {
    public static Command parse(String input) {
        return switch(input) {
            case "list" -> new DisplayListCommand();
            case "bye" -> new ByeCommand();
            default -> new AddToListCommand(input);
        };
    }
}

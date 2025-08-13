import command.Command;
import command.Parser;
import misc.PepeException;
import state.Ui;
import tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pepe {
    private static final Ui ui = new Ui();
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        ui.displayWelcomeMessage();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepGoing = true;
            while (keepGoing) {
                try {
                    final Command command = Parser.parse(scanner.nextLine());
                    keepGoing = command.execute(ui, tasks);
                } catch (PepeException e) {
                    ui.handleException(e);
                }
            }
        }
    }
}

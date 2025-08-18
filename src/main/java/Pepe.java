import command.Command;
import command.Parser;
import misc.PepeException;
import state.Storage;
import state.Ui;
import tasks.Task;

import java.util.List;
import java.util.Scanner;

public class Pepe {
    private static Pepe pepe;

    private final Ui ui;
    private final List<Task> tasks;
    private final Storage storage;

    public Pepe(String storageFilePath) {
        this.ui = new Ui();
        this.storage = new Storage(storageFilePath);
        this.tasks = this.storage.getTasks();
    }

    public static Pepe getInstance() {
        return pepe;
    }

    public void run() {
        ui.displayWelcomeMessage();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepGoing = true;
            while (keepGoing) {
                try {
                    final Command command = Parser.parse(scanner.nextLine());
                    keepGoing = command.execute(ui, storage, tasks);
                } catch (PepeException e) {
                    ui.handleException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Hardcoded path. Will change if receive complaints
        pepe = new Pepe("./data/pepe.txt");
        pepe.run();
    }
}

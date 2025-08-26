import java.util.Scanner;

import command.Command;
import command.Parser;
import misc.PepeException;
import state.Storage;
import state.TaskList;
import state.Ui;

/**
 * The main Pepe application class.
 */
public class Pepe {

    private static Pepe pepe;

    private final Ui ui;
    private final TaskList taskList;
    private final Storage storage;

    /**
     * Public constructor to construct an instance of the Pepe application from a file that contains the task list.
     * @param storageFilePath A path to a file that contains the current task list.
     */
    public Pepe(String storageFilePath) {
        this.ui = new Ui();
        this.storage = new Storage(storageFilePath);
        this.taskList = new TaskList(this.storage.getTasks());
        System.out.println("Pepe constructor was called");
    }

    /**
     * Runs the Pepe application.
     */
    public void run() {
        ui.displayWelcomeMessage();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepGoing = true;
            while (keepGoing) {
                try {
                    final Command command = Parser.parse(scanner.nextLine());
                    keepGoing = command.execute(ui, storage, taskList);
                } catch (PepeException e) {
                    ui.handleException(e);
                }
            }
        }
    }

    /**
     * Generates a response for the user's chat response.
     * @param input the user's inputted response
     * @return a response to user's message
     */
    public String getResponse(String input) {
        return "Pepe heard: " + input;
    }

}

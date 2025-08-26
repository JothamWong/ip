import java.util.Scanner;

import command.Command;
import command.Parser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import misc.PepeException;
import state.Storage;
import state.TaskList;
import state.Ui;

/**
 * The main Pepe application class.
 */
public class Pepe extends Application {
    private static final String DEFAULT_FILE_PATH = "./data/pepe.txt";

    private static Pepe pepe;

    private final Ui ui;
    private final TaskList taskList;
    private final Storage storage;

    /**
     * Default constructor to construct an instance of the Pepe application from a file that contains the task list.
     */
    public Pepe() {
        this(DEFAULT_FILE_PATH);
    }

    /**
     * Public constructor to construct an instance of the Pepe application from a file that contains the task list.
     * @param storageFilePath A path to a file that contains the current task list.
     */
    public Pepe(String storageFilePath) {
        this.ui = new Ui();
        this.storage = new Storage(storageFilePath);
        this.taskList = new TaskList(this.storage.getTasks());
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

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World");
        Scene scene = new Scene(helloWorld);

        stage.setScene(scene);
        stage.show();
    }
}

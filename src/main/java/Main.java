import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Main class that wraps around Pepe.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("Application started");
        Label helloWorld = new Label("Hello World");
        Scene scene = new Scene(helloWorld);

        stage.setScene(scene);
        stage.show();
    }
}

package components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * JavaFX class that represents a Dialog
 */
public class DialogBox extends HBox {

    private Label text;
    private ImageView displayPicture;

    /**
     * Constructor for javafx dialogbox.
     * @param message to display from the user
     * @param image to display for the user
     */
    public DialogBox(String message, Image image) {
        text = new Label(message);
        displayPicture = new ImageView(image);

        //Styling the dialog box
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        this.setAlignment(Pos.TOP_RIGHT);

        this.getChildren().addAll(text, displayPicture);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and the text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    /**
     * Factory method to create a DialogBox for the User.
     * @param message that the user sent
     * @param image representing the user
     * @return the DialogBox representing the User
     */
    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }


    /**
     * Factory method to create a DialogBox for Pepe.
     * @param message that Pepe sent
     * @param image representing Pepe
     * @return the DialogBox representing Pepe
     */
    public static DialogBox getPepeDialog(String message, Image image) {
        var db = new DialogBox(message, image);
        db.flip();
        return db;
    }
}

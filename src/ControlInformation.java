package src;

import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

/**
 * Created by joshuareno on 7/18/17.
 */
public class ControlInformation {
    private HBox hbox;
    private Button addStock;
    private Button deleteStock;
    private Label status;
    private Alert alert;


    public ControlInformation() {
        hbox = new HBox();
        addStock = new Button();
        deleteStock = new Button();
        status = new Label();

        // set button and label styles

        hbox.getChildren().addAll(addStock, deleteStock, status);
    }

    public HBox getRootNode() {
        return hbox;
    }

    public Button getAddStock() {
        return addStock;
    }

    public Button getDeleteStock() {
        return deleteStock;
    }

    public Label getLabel() {
        return status;
    }

    public Alert getAlert() {
        return alert;
    }
}

package src;

import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    }

    public HBox getRootNode() {
        return hbox;
    }
}

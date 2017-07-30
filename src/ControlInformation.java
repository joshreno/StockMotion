package src;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by joshuareno on 7/18/17.
 */

public class ControlInformation {
    private HBox hbox;
    private Button addStock;
    private Button deleteStock;
    private Label status;

    /**
     * Sets the information for the button, hbox, image, and label
     */
    public ControlInformation() {
        hbox = new HBox();
        Image addStockImage = new Image("File:./src/Images/blue-add-button.jpg", 20, 20, false, true);
        addStock = new Button("Add stock", new ImageView(addStockImage));
        Image deleteStockImage = new Image("File:./src/Images/yellow-exclude-button.jpg", 20, 20, false, true);
        deleteStock = new Button("Delete stock", new ImageView(deleteStockImage));
        status = new Label("Leap Motion Status: " + "");
        status.setStyle("-fx-background-color: #FFFFFF;");
        hbox.getChildren().addAll(addStock, deleteStock, status);
    }

    /**
     * Returns the HBox
     * @return HBox
     */
    public HBox getRootNode() {
        return hbox;
    }

    /**
     * Returns the addStock button
     * @return Button
     */
    public Button getAddStock() {
        return addStock;
    }

    /**
     * Returns the deleteStock button
     * @return Button
     */
    public Button getDeleteStock() {
        return deleteStock;
    }

    /**
     * Sets the status of the Leap Motion Controller and the HBox
     * @param leapStatus
     */
    public void setStatusString(LeapStatus leapStatus) {
        hbox.getChildren().remove(status);
        String statusString = "";
        switch(leapStatus) {
            case INITIALIZED: statusString = "Initialized";
                              status.setStyle("-fx-background-color: #eef441;");
                break;
            case CONNECTED: statusString = "Connected";
                            status.setStyle("-fx-background-color: #50f442;");
                break;
            case DISCONNECTED: statusString = "Disconnected";
                               status.setStyle("-fx-background-color: #f9b004;");
                break;
            case EXITED: statusString = "Exited";
                         status.setStyle("-fx-background-color: #ff0000;");
                break;
        }
        status.setText("Leap Motion Status: " + statusString);
        hbox.getChildren().add(status);
    }

}

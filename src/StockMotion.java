package src;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

/**
 * Created by joshuareno on 7/16/17.
 */

public class StockMotion extends Application{
    private static StockScreen stockScreen;
    private Controller controller;
    private MotionListener listener;
    private Scene scene;
    private Stage stage;

    /**
     * Starts the application
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        controller = new Controller();
        listener = new MotionListener();
        stockScreen = new StockScreen();
        stage = primaryStage;
        stage.setScene(startStockMotion());
        stage.show();
    }

    /**
     * Returns the StockScreen variable
     * @return StockScreen
     */
    public static StockScreen getStockScreen() {
        return stockScreen;
    }

    /**
     * Returns the scene after setting the actions of the buttons
     * @return Scene
     */
    public Scene startStockMotion() {
        stockScreen.getControlInformation().getAddStock().setOnMouseClicked((event) -> {
            TextInputDialog dialog = new TextInputDialog("Ticker Symbol");
            dialog.setTitle("Add Stock");
            dialog.setContentText("Enter ticker symbol");
            String string = dialog.showAndWait().get();

            try {
                stockScreen.getStockMenu().addStock(string); // this one
                stockScreen.update();
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Ticker Symbol Error");
                alert.setContentText("The symbol you entered is not correct.");
                alert.showAndWait();
            }
        });
        stockScreen.getControlInformation().getDeleteStock().setOnMouseClicked((event) -> {
            TextInputDialog dialog = new TextInputDialog("Ticker Symbol");
            dialog.setTitle("Delete Stock");
            dialog.setContentText("Enter ticker symbol");
            String string = dialog.showAndWait().toString();
            try {
                stockScreen.getStockMenu().deleteStock(string);
                stockScreen.update();
            } catch (StockDoesNotExistException | IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Ticker Symbol Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        });
        scene = new Scene(stockScreen);
        return scene;
    }

    /**
     * Launches args
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
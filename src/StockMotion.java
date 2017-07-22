package src;

import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;

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
    private Date stockStartDate;
    private Date stockEndDate;
    private Scene scene;
    private Stage stage;

    /**
     * Starts the application
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        stockStartDate = new Date();
        stockEndDate = new Date();
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

    public Scene startStockMotion() {
        stockScreen.getControlInformation().getAddStock().setOnMouseClicked((event) -> {
            TextInputDialog dialog = new TextInputDialog("Ticker Symbol");
            dialog.setTitle("Add Stock");
            dialog.setContentText("Enter ticker symbol");
            String string = dialog.showAndWait().toString();
            try {
                stockScreen.getStockMenu().addStock(string, new Date(), new Date().getCurrentDay());
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
            dialog.setTitle("Delet Stock");
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

    public static void main(String[] args) {
        launch(args);
    }
}
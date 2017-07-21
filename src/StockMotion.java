package src;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    public static StockScreen getStockScreen() throws IOException{
        return stockScreen;
    }

    public Scene startStockMotion() {
        stockScreen.getControlInformation().getAddStock().setOnMouseClicked((event) -> {

        });

        stockScreen.getControlInformation().getDeleteStock().setOnMouseClicked((event) -> {

        });


        // button implementation
        scene = new Scene(stockScreen);
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
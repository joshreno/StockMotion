package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

/**
 * Created by joshuareno on 7/16/17.
 */

public class StockMotion extends Application{
    private static StockScreen stockScreen;
    private Controller controller;
    private MotionListener listener;
    private Date stockStartDate;
    private Date stockEndDate;

    /**
     * Starts the application
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        stockStartDate = new Date();
        stockEndDate = new Date();
        controller = new Controller();
        listener = new MotionListener();
    }

    /**
     * Returns the StockScreen variable
     * @return StockScreen
     */
    public static StockScreen getStockScreen() throws IOException{
        return stockScreen;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
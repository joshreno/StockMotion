/**
 * Created by joshuareno on 7/16/17.
 */
package src;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class StockMotion extends Application{
    private Controller controller;
    private MotionListener listener;
    private Date stockStartDate;
    private Date stockEndDate;

    public void start(Stage primaryStage) {
        stockStartDate = new Date();
        stockEndDate = new Date();
        controller = new Controller();
        listener = new MotionListener();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
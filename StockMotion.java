// import leap motion

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class StockMotion extends Application{
    private Date stockStartDate;
    private Date stockEndDate;

    public void start(Stage primaryStage) {
        stockStartDate = new Date();
        stockEndDate = new Date();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
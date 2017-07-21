package src;

import java.io.IOException;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockScreen extends BorderPane{
    private static Stock stock;
    private static VBox vboxList = new VBox();
    private static StockMenu stockMenu = new StockMenu();
    private static VBox vboxInfo = new VBox();
    private static StockInformation info = new StockInformation(null);
    private static HBox hbox = new HBox();
    private static StockMenu exchangesMenu = new StockMenu();
    private static ControlInformation controlInformation = new ControlInformation();
    private static HBox controlBox = new HBox();

    /**
     * Constructor sets the BorderPane nodes
     */
    public StockScreen() {
        vboxList.getChildren().addAll(stockMenu.getListOfStocks());
        // vboxInfo.getChildren().addAll(info.getRootNode());
        // hbox.getChildren().addAll(exchangesMenu.getListOfExchanges());
        controlBox.getChildren().addAll(controlInformation.getRootNode());
        this.setTop(hbox);
        this.setLeft(vboxList);
        this.setRight(vboxInfo);
        // this.setCenter(stock.getAreaChart());
        this.setCenter(new VBox());
        this.setBottom(controlBox);
    }

    /**
     * Updates the BorderPane nodes
     */
    public void update() throws IOException{
        vboxList.getChildren().clear();
        vboxList.getChildren().addAll(stockMenu.getListOfStocks());
        this.setLeft(vboxList);
        vboxInfo.getChildren().clear();
        vboxInfo.getChildren().addAll(info.getRootNode());
        this.setRight(vboxInfo);
        hbox.getChildren().clear();
        hbox.getChildren().addAll(exchangesMenu.getListOfExchanges());
        this.setTop(hbox);
        stock.update();
        this.setCenter(stock.getAreaChart());

    }

    public static void setStock(Stock stock) {
        StockScreen.stock = stock;
    }

    public static Stock getStock() {
        return stock;
    }

    public static ControlInformation getControlInformation() {
        return controlInformation;
    }
}
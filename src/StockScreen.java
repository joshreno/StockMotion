package src;

import java.io.IOException;

import javafx.scene.chart.AreaChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockScreen extends BorderPane{
    private static AreaChart areaChart;
    private static yahoofinance.Stock stock;
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
        controlBox.getChildren().addAll(controlInformation.getRootNode());
        this.setTop(hbox);
        this.setLeft(vboxList);
        this.setRight(vboxInfo);
        this.setCenter(new VBox());
        this.setBottom(controlBox);
    }

    /**
     * Updates the BorderPane nodes
     * @throws IOException
     */
    public void update() throws IOException, StockDoesNotExistException{
        vboxList.getChildren().clear();
        vboxList.getChildren().addAll(stockMenu.getListOfStocks());
        this.setLeft(vboxList);
        vboxInfo.getChildren().clear();
        vboxInfo.getChildren().addAll(info.getRootNode());
        this.setRight(vboxInfo);
        hbox.getChildren().clear();
        hbox.getChildren().addAll(exchangesMenu.getListOfExchanges());
        this.setTop(hbox);
        if (stock != null) {
            areaChart = StockChart.getAreaChart(stock);
            this.setCenter(areaChart);
            areaChart.setVisible(true);
        }
    }

    /**
     * Sets the stock variable
     * @param stock
     */
    public static void setStock(yahoofinance.Stock stock) {
        StockScreen.stock = stock;
        StockInformation.setStockInformation(stock);
    }

    /**
     * Returns the controlInformation variable
     * @return ControlInformation
     */
    public static ControlInformation getControlInformation() {
        return controlInformation;
    }

    /**
     * Returns the stockMenu variable
     * @return StockMenu
     */
    public static StockMenu getStockMenu() {
        return stockMenu;
    }
}
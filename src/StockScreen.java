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
    private AreaChart areaChart;
    private static yahoofinance.Stock stock;
    private static VBox vboxList = new VBox();
    private static StockMenu stockMenu = new StockMenu();
    private static VBox vboxInfo = new VBox();
    private static StockInformation info = new StockInformation(null);
    private static HBox hbox = new HBox();
    private static StockMenu exchangesMenu = new StockMenu();
    private static HBox secondHBox = new HBox();
    private static StockMenu exchangesMenuSecond = new StockMenu();
    private static ControlInformation controlInformation = new ControlInformation();
    private static HBox controlBox = new HBox();
    private BorderPane borderPane = new BorderPane();

    /**
     * Constructor sets the BorderPane nodes
     */
    public StockScreen() {
        this.setMinSize(0, 0);
        this.setStyle("-fx-background-color: #000000;");
        vboxList.getChildren().addAll(stockMenu.getListOfStocks());
        controlBox.getChildren().addAll(controlInformation.getRootNode());
        try {
            setExchanges();
        } catch (IOException e) {}
        hbox.getChildren().addAll(exchangesMenu.getListOfExchanges());
        secondHBox.getChildren().addAll(exchangesMenuSecond.getListOfExchanges());
        borderPane.setTop(hbox);
        borderPane.setBottom(secondHBox);
        this.setTop(borderPane);
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
        if (stock != null) {
            areaChart = StockChart.getAreaChart(stock);
            this.setCenter(areaChart);
            areaChart.setVisible(true);
        }
    }

    /**
     * Initiates the appropriate indexes and exchanges
     * @throws IOException
     */
    public void setExchanges() throws IOException{
        exchangesMenu.addStock("^IXIC");
        exchangesMenu.addStock("^GSPC");
        exchangesMenu.addStock("^NYA");
        exchangesMenu.addStock("^N225");
        exchangesMenu.addStock("^FTSE");
        exchangesMenu.addStock("MICEXINDEXCF.ME");
        exchangesMenu.addStock("^N100");
        exchangesMenu.addStock("^HSI");
        exchangesMenu.addStock("^AXJO");
        exchangesMenuSecond.addStock("^GSPTSE");
        exchangesMenuSecond.addStock("^FCHI");
        exchangesMenuSecond.addStock("^TA100");
        exchangesMenuSecond.addStock("^NZ50");
        exchangesMenuSecond.addStock("^MXX");
        exchangesMenuSecond.addStock("^KS11");
        exchangesMenuSecond.addStock("^GDAXI");
        exchangesMenuSecond.addStock("^JKSE");
        exchangesMenuSecond.addStock("^MERV");

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
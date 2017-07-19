package src;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockInformation {
    private static Stock stock;
    private static double high;
    private static double low;
    private static double open;
    private static double close;
    // private static double marketCap;
    private static double value;
    private static double volume;
    // private static double week52High;
    // private static double week52Low;
    private static double yield;
    private static VBox vbox = new VBox();

    /**
     * Constructor sets the information for a particular stock
     * @param stock
     */
    public StockInformation(Stock stock) {
        if (stock != null) {
            this.stock = stock;
            high = stock.getHigh();
            low = stock.getLow();
            open = stock.getOpen();
            close = stock.getClose();
            // marketCap = stock.getMarketCap();
            value = stock.getValue();
            volume = stock.getVolume();
            // week52High = stock.getWeek52High();
            // week52Low = stock.getWeek52Low();
            yield = stock.getYield();
        }
    }

    /**
     * Changes the stock and updates the instance variables
     * @param stock
     */
    public static void setStockInformation(Stock stock) {
        StockInformation.stock = stock;
        high = stock.getHigh();
        low = stock.getLow();
        open = stock.getOpen();
        close = stock.getClose();
        // marketCap = stock.getMarketCap();
        value = stock.getValue();
        volume = stock.getVolume();
        // week52High = stock.getWeek52High();
        // week52Low = stock.getWeek52Low();
        yield = stock.getYield();
    }

    /**
     * Updates the instance variables
     */
    public static void update() {
        high = stock.getHigh();
        low = stock.getLow();
        open = stock.getOpen();
        // marketCap = stock.getMarketCap();
        value = stock.getValue();
        volume = stock.getVolume();
        // week52High = stock.getWeek52High();
        // week52Low = stock.getWeek52Low();
        yield = stock.getYield();
    }

    /**
     * Returns the root node containing the stock's information
     * @return VBox
     */
    public static VBox getRootNode() {
        update();
        vbox.getChildren().clear();
        Label highLabel = new Label("High: " + high);
        Label lowLabel = new Label("Low: " + low);
        Label openLabel = new Label("Open: " + open);
        Label closeLabel = new Label("Close: " + close);
        // Label marketCapLabel = new Label("Market Cap: " + marketCap);
        Label valueLabel = new Label("Value: " + value);
        Label volumeLabel = new Label("Volume: " + volume);
        // Label week52HighLabel = new Label("52 Week High: " + week52High);
        // Label week52LowLabel = new Label("52 Week Low: " + week52Low);
        Label yieldLabel = new Label("Yield: " + yield);
        vbox.getChildren().addAll(
                highLabel,
                lowLabel,
                openLabel,
                closeLabel,
                // marketCapLabel,
                valueLabel,
                volumeLabel,
                // week52HighLabel,
                // week52LowLabel,
                yieldLabel);
        return vbox;
    }
}

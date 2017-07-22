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
    private static double value;
    private static double volume;
    private static double valueChange;
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
            value = stock.getValue();
            volume = stock.getVolume();
            valueChange = stock.getValueChange();
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
        value = stock.getValue();
        volume = stock.getVolume();
        valueChange = stock.getValueChange();
    }

    /**
     * Updates the instance variables
     */
    public static void update() {
        high = stock.getHigh();
        low = stock.getLow();
        open = stock.getOpen();
        close = stock.getClose();
        value = stock.getValue();
        volume = stock.getVolume();
        valueChange = stock.getValueChange();
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
        Label valueLabel = new Label("Value: " + value);
        Label volumeLabel = new Label("Volume: " + volume);
        Label valueChangeLabel = new Label("Value Change: " + valueChange);
        vbox.getChildren().addAll(
                highLabel,
                lowLabel,
                openLabel,
                closeLabel,
                valueLabel,
                volumeLabel,
                valueChangeLabel);
        return vbox;
    }
}

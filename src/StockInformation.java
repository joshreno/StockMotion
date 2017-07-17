package src;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
/**
 * Created by joshuareno on 7/17/17.
 */
public class StockInformation {
    private Stock stock;
    private double high;
    private double low;
    private double open;
    private double marketCap;
    private double value;
    private double volume;
    private double week52High;
    private double week52Low;
    private double yield;
    private VBox vbox = new VBox();

    public StockInformation(Stock stock) {
        this.stock = stock;
        high = stock.getHigh();
        low = stock.getLow();
        open = stock.getOpen();
        marketCap = stock.getMarketCap();
        value = stock.getValue();
        volume = stock.getVolume();
        week52High = stock.getWeek52High();
        week52Low = stock.getWeek52Low();
        yield = stock.getYield();
    }

    public void update() {
        high = stock.getHigh();
        low = stock.getLow();
        open = stock.getOpen();
        marketCap = stock.getMarketCap();
        value = stock.getValue();
        volume = stock.getVolume();
        week52High = stock.getWeek52High();
        week52Low = stock.getWeek52Low();
        yield = stock.getYield();
    }

    public VBox getRootNode() {
        update();
        vbox.getChildren().clear();
        Label highLabel = new Label("High: " + high);
        Label lowLabel = new Label("Low: " + low);
        Label openLabel = new Label("Open: " + open);
        Label marketCapLabel = new Label("Market Cap: " + marketCap);
        Label valueLabel = new Label("Value: " + value);
        Label volumeLabel = new Label("Volume: " + volume);
        Label week52HighLabel = new Label("52 Week High: " + week52High);
        Label week52LowLabel = new Label("52 Week Low: " + week52Low);
        Label yieldLabel = new Label("Yield: " + yield);
        vbox.getChildren().addAll(highLabel, lowLabel, openLabel, marketCapLabel,
                valueLabel, volumeLabel, week52HighLabel, week52LowLabel, yieldLabel);
        return vbox;
    }
}

package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockMenu {
    private List<yahoofinance.Stock> listOfStocks = new ArrayList<yahoofinance.Stock>();
    private List<Button> listOfButtons = new ArrayList<Button>();
    private VBox vbox = new VBox(0);
    private HBox hbox = new HBox(0);

    /**
     * Adds the stock to the list
     * @param symbol
     */
    public void addStock(String symbol) throws IOException{
        for (yahoofinance.Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                return;
            }
        }
        yahoofinance.Stock stock = yahoofinance.YahooFinance.get(symbol);
        listOfStocks.add(stock);
        Button button;
        switch (symbol) {
            case "^IXIC" : button = new Button("NASDAQ (US): " + stock.getQuote().getPrice());
                break;
            case "^GSPC" : button = new Button("S&P500 (US): " + stock.getQuote().getPrice());
                break;
            case "^FTSE" : button = new Button("FTSE (UK): " + stock.getQuote().getPrice());
                break;
            case "^N225" : button = new Button("Nikkei (JP): " + stock.getQuote().getPrice());
                break;
            case "^NYA" : button = new Button("NYSE (US): " + stock.getQuote().getPrice());
                break;
            case "^N100" : button = new Button("Euro100 (EU): " + stock.getQuote().getPrice());
                break;
            case "^AXJO" : button = new Button("AXJO (AUS): " + stock.getQuote().getPrice() + "   ");
                break;
            case "^GSPTSE" : button = new Button("Toronto (CA): " + stock.getQuote().getPrice());
                break;
            case "^FCHI" : button = new Button("CAC40 (FR): " + stock.getQuote().getPrice());
                break;
            case "^HSI" : button = new Button("Hang Seng (HK): " + stock.getQuote().getPrice());
                break;
            case "^TA100" : button = new Button("TA-125 (ISR): " + stock.getQuote().getPrice());
                break;
            case "^NZ50" : button = new Button("NZX 50 (NZ): " + stock.getQuote().getPrice());
                break;
            case "^MXX" : button = new Button("IPC (MEX): " + stock.getQuote().getPrice());
                break;
            case "MICEXINDEXCF.ME" : button = new Button("MICEX (RUS): " + stock.getQuote().getPrice());
                break;
            case "^KS11" : button = new Button("KOSPI (Korea): " + stock.getQuote().getPrice());
                break;
            case "^GDAXI" : button = new Button("XETRA (GER): " + stock.getQuote().getPrice());
                break;
            case "^JKSE" : button = new Button("Jakarta (INDON): " + stock.getQuote().getPrice());
                break;
            case "^MERV" : button = new Button("Merval (ARG): " + stock.getQuote().getPrice());
                break;
            default: button = new Button(stock.getSymbol() + ": " + stock.getQuote().getPrice());
        }
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(1);
        rectangle.setWidth(1);
        button.setShape(rectangle);
        if (stock.getQuote().getChange().doubleValue() > 0) {
            button.setStyle("-fx-background-color: #50f442;");
            listOfButtons.add(button);
        } else {
            button.setStyle("-fx-background-color: #ff0000;");
            listOfButtons.add(button);
        }
    }

    /**
     * Deletes the stock from the list
     * @param symbol
     */
    public void deleteStock(String symbol) throws StockDoesNotExistException{
        boolean exists = false;
        for (yahoofinance.Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                listOfStocks.remove(stock);
                exists = true;
            }
        }
        if (!exists) {
            throw new StockDoesNotExistException("");
        }
        for (Button button : listOfButtons) {
            if (button.getText().equals(symbol)) {
                listOfButtons.remove(button);
            }
        }
    }

    /**
    * Inputs a stock symbol and returns the stock
     * @param symbol
     * @return Stock
     */
    public yahoofinance.Stock getStock(String symbol) {
        for (yahoofinance.Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }

    /**
     * Returns the stocks in a VBox
     * @return VBox
     */
    public VBox getListOfStocks() {
        if (listOfButtons.size() == 0) {
            return vbox;
        }
        vbox = new VBox();
        vbox.getChildren().addAll(new Label("Stocks: "));
        for (Button button: listOfButtons) {
            vbox.getChildren().addAll(button);
        }
        return vbox;
    }

    /**
     * Returns a list of buttons with stock symbols and values.
     * @return List<Button>
     */
    public List<Button> getListOfButtons() {
        return listOfButtons;
    }

    /**
     * Returns the stocks in an HBox
     * @return HBox
     */
    public HBox getListOfExchanges() {
        hbox = new HBox();
        for (Button button: listOfButtons) {
            hbox.getChildren().add(button);
        }
        return hbox;
    }
}

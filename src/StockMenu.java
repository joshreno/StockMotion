package src;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import yahoofinance.*;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockMenu {
    private ArrayList<yahoofinance.Stock> listOfStocks = new ArrayList<yahoofinance.Stock>();
    private ArrayList<Button> listOfButtons = new ArrayList<Button>();
    private VBox vbox = new VBox(0);
    private HBox hbox = new HBox(0);

    /**
     * Adds the stock to the list
     * @param symbol
     * @param startDate
     * @param endDate
     */
    public void addStock(String symbol, Date startDate, Date endDate) throws IOException{
        for (yahoofinance.Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                return;
            }
        }
        yahoofinance.Stock stock = YahooFinance.get(symbol); // check this
        listOfStocks.add(stock);
        if (stock.getQuote().getChange().intValue() > 0) {
            Button button = new Button(stock.getSymbol() + ": " + stock.getQuote().getPrice());
            button.setStyle("-fx-background-color: #50f442;");
            listOfButtons.add(button);
        } else {
            Button button = new Button(stock.getSymbol() + ": " + stock.getQuote().getPrice());
            button.setStyle("-fx-background-color: #ff0000;");
            listOfButtons.add(button);
        }

        // check if stock exists or not ->  button
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
        for (Button button: listOfButtons) {
            button.setOnMousePressed(e -> {
                for (yahoofinance.Stock stock: listOfStocks) {
                    if (stock.getSymbol().equals(button.getText())) {
                        StockInformation.setStockInformation(stock);
                        StockInformation.update();
                        StockScreen.setStock(stock);
                    }
                }
            });
            vbox.getChildren().add(button);
        }
        return vbox;
    }

    /**
     * Returns the stocks in an HBox
     * @return HBox
     */
    public HBox getListOfExchanges() {
        for (Button button: listOfButtons) {
            hbox.getChildren().add(button);
        }
        return hbox;
    }
}

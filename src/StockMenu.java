package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
        try {
            if (stock.getQuote().getChange().doubleValue() > 0) {
                Button button = new Button(stock.getSymbol() + ": " + stock.getQuote().getPrice());
                button.setStyle("-fx-background-color: #50f442;");
                listOfButtons.add(button);
            } else {
                Button button = new Button(stock.getSymbol() + ": " + stock.getQuote().getPrice());
                button.setStyle("-fx-background-color: #ff0000;");
                listOfButtons.add(button);
            }
        } catch (NullPointerException e) {
            throw new IOException("");
        }
        System.out.println(symbol);
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
        vbox = new VBox();
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
            vbox.getChildren().addAll(button);
        }
        return vbox;
    }

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

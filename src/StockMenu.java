package src;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by joshuareno on 7/17/17.
 */

public class StockMenu {
    private ArrayList<Stock> listOfStocks;
    private ArrayList<Button> listOfButtons;
    private VBox vbox = new VBox(0);
    private HBox hbox = new HBox(0);

    /**
     * Adds the stock to the list
     * @param symbol
     * @param startDate
     * @param endDate
     */
    private void addStock(String symbol, Date startDate, Date endDate) throws IOException{
        for (Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                return;
            }
        }
        Stock stock = new Stock(symbol);
        listOfStocks.add(stock);
        listOfButtons.add(new Button(stock.getSymbol()));
        // check if stock exists or not -> not button
    }

    /**
     * Deletes the stock from the list
     * @param symbol
     */
    private void deleteStock(String symbol) {
        for (Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                listOfStocks.remove(stock);
            }
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
    private Stock getStock(String symbol) {
        for (Stock stock : listOfStocks) {
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
        for (Button button: listOfButtons) {
            button.setOnMousePressed(e -> {
                for (Stock stock: listOfStocks) {
                    if (stock.getSymbol().equals(button.getText())) {
                        StockInformation.setStockInformation(stock);
                        StockInformation.update();
                        StockMotion.getStockScreen().update();
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

package src;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by joshuareno on 7/17/17.
 */
public class StockMenu {
    private ArrayList<Stock> listOfStocks;

    private void addStock(String symbol, Date startDate, Date endDate) throws MalformedURLException{
        for (Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                return;
            }
        }
        Stock stock = new Stock(symbol);
        listOfStocks.add(stock);
    }

    private void deleteStock(String symbol) {
        for (Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                listOfStocks.remove(stock);
            }
        }
    }

    private Stock getStock(String symbol) {
        for (Stock stock : listOfStocks) {
            if (stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }

    // change
    public VBox getListOfStocks() {
        return null;
    }

    // change
    public HBox getListOfExchanges() {
        return null;
    }

}

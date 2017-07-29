package src;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

/**
 * Created by joshuareno on 7/26/17.
 */

public class StockChart {
    private static AreaChart<String, Double> areaChart;
    private static NumberAxis yAxis;
    private static CategoryAxis xAxis;
    private static List<Double> listOfAdjClose = new ArrayList<Double>();
    private static List<String> listOfStringDates = new ArrayList<String>();
    private static List<yahoofinance.histquotes.HistoricalQuote> listOfQuotes;
    private static XYChart.Series series;

    public static AreaChart getAreaChart(yahoofinance.Stock stock) throws StockDoesNotExistException{
        try {
            listOfQuotes = stock.getHistory();
        } catch (IOException e) {
            throw new StockDoesNotExistException("");
        }
        series = new XYChart.Series();
        series.setName(stock.getSymbol());
        for (yahoofinance.histquotes.HistoricalQuote histQuote: listOfQuotes) {
            Double close = histQuote.getAdjClose().doubleValue();
            listOfAdjClose.add(close);
            Date date = Date.Date(histQuote.getDate());
            listOfStringDates.add(date.toString());
            series.getData().add(new XYChart.Data(date.toString(), close));
        }
        xAxis = new CategoryAxis(FXCollections.observableArrayList(listOfStringDates));
        yAxis = new NumberAxis(0, stock.getQuote().getPrice().doubleValue(), stock.getQuote().getPrice().doubleValue()/100);
        areaChart = new AreaChart<String, Double>(xAxis, (Axis) yAxis);
        areaChart.getData().addAll(series);
        return StockChart.areaChart;
    }
}

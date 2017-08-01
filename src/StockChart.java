package src;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.scene.chart.*;

/**
 * Created by joshuareno on 7/26/17.
 */

public class StockChart {
    private static AreaChart<String, Double> areaChart;
    private static NumberAxis yAxis;
    private static CategoryAxis xAxis;
    private static double max;
    private static double min;
    private static HashMap<yahoofinance.Stock, AreaChart<String, Double>> map = new HashMap<yahoofinance.Stock, AreaChart<String, Double>>();
    private static List<Double> listOfAdjClose;
    private static List<String> listOfStringDates;
    private static List<yahoofinance.histquotes.HistoricalQuote> listOfQuotes;
    private static XYChart.Series series;

    public static AreaChart getAreaChart(yahoofinance.Stock stock) throws StockDoesNotExistException, IOException{
        if (map.containsKey(stock)) {
            return map.get(stock);
        }
        max = 0;
        min = 0;
        listOfAdjClose = new ArrayList<Double>();
        listOfStringDates = new ArrayList<String>();
        Calendar from = Calendar.getInstance();
        from.add(Calendar.YEAR, -1);
        yahoofinance.Stock stockInterval = yahoofinance.YahooFinance.get(stock.getSymbol(), from,
                Calendar.getInstance(), yahoofinance.histquotes.Interval.DAILY);
        try {
            listOfQuotes = stockInterval.getHistory();
        } catch (IOException e) {
            throw new StockDoesNotExistException("");
        }
        series = new XYChart.Series();
        series.setName(stock.getSymbol());
        for (yahoofinance.histquotes.HistoricalQuote histQuote: listOfQuotes) {
            Date date = Date.Date(histQuote.getDate());
            if (!listOfStringDates.contains(date.toString())) {
                Double close = histQuote.getAdjClose().doubleValue();
                if (close > max) {
                    max = close;
                }
                if (min == 0) {
                    min = close;
                }
                if (close < min) {
                    min = close;
                }
                listOfAdjClose.add(close);
                listOfStringDates.add(date.toString());
                series.getData().add(new XYChart.Data(date.toString(), close));
            }
        }
        xAxis = new CategoryAxis(FXCollections.observableArrayList(listOfStringDates));
        yAxis = new NumberAxis(min * 0.9, max * 1.1, stockInterval.getQuote().getPrice().doubleValue()/100);
        areaChart = new AreaChart<String, Double>(xAxis, (Axis) yAxis);
        areaChart.getData().addAll(series);
        if (stock.getQuote().getChange().doubleValue() > 0) {
            areaChart.getStylesheets().add("src/lib/Chart1.css");
        } else {
            areaChart.getStylesheets().add("src/lib/Chart2.css");
        }
        map.put(stock, StockChart.areaChart);
        return StockChart.areaChart;
    }
}

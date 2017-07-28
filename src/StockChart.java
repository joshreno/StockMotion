package src;

import java.io.IOException;
import java.util.List;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

/**
 * Created by joshuareno on 7/26/17.
 */
public class StockChart {
    private static AreaChart areaChart;
    private static List<Date> listOfDates;
    private static List<Double> listOfAdjClose;
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
            listOfDates.add(date);
            series.getData().add(new XYChart.Data(date, close));
        }
        areaChart.getData().addAll(series);
        return StockChart.areaChart;
    }
}

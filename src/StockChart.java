package src;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

import yahoofinance.*;

/**
 * Created by joshuareno on 7/26/17.
 */
public class StockChart {
    private static AreaChart areaChart;

    public static AreaChart getAreaChart(yahoofinance.Stock stock) {
        return StockChart.areaChart;
    }
}

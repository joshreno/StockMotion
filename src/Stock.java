package src;

import java.util.ArrayList;
import javafx.scene.chart.AreaChart;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.time.Instant;
import java.io.IOException;
import javafx.scene.chart.NumberAxis;
import static java.lang.Math.toIntExact;
import java.sql.Timestamp;
import java.net.URL;
import java.net.URLConnection;
import javafx.scene.chart.XYChart;

/**
 * Created by joshuareno on 7/17/17.
 */
public class Stock {
    private String address;
    private AreaChart areaChart;
    private ArrayList<ArrayList<String>> arrayOfData;
    private BufferedReader buff;
    private double high;
    private InputStreamReader inStream;
    private double low;
    private double open;
    private double marketCap;
    private int marketCapChange;
    private double percentChange;
    private String symbol;
    private URL url;
    private URLConnection urlConnection;
    private double value;
    private double valueChange;
    private HashMap<Date, Integer> valueOverTime;
    private double volume;
    private double week52High;
    private double week52Low;
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private double yield;

    public Stock(String symbol) throws IOException{
        this.symbol = symbol;
        long time1 = Instant.now().getEpochSecond();
        int unixDate1 = 0;
        int unixDate2 = toIntExact(time1);
        address = "https://query1.finance.yahoo.com/v7/finance/download/^"
                + symbol +  "?period1=" + Integer.toString(unixDate1) + "&period2="
                + Integer.toString(unixDate2) + "&interval=1d&events=history&crumb=aDdGQcp1f2A";
        url = new URL(address);
        urlConnection = url.openConnection();
        inStream = new InputStreamReader(urlConnection.getInputStream());

        arrayOfData = new ArrayList<ArrayList<String>>();
        String buffLine;
        buff = new BufferedReader(inStream);
        while ((buffLine = buff.readLine()) != null) {
            arrayOfData.add(CSVtoArrayList(buffLine));
        }
        
    }

    public ArrayList<String> CSVtoArrayList(String csv) {
        ArrayList<String> result = new ArrayList<String>();
        if (csv != null) {
            String[] splitData = csv.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    result.add(splitData[i].trim());
                }
            }
        }
        return result;
    }

    public AreaChart<Number, Number> getAreaChart() {
        return areaChart;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getOpen() {
        return open;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public double getValue() {
        return value;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeek52High() {
        return week52High;
    }

    public double getWeek52Low() {
        return week52Low;
    }

    public double getYield() {
        return yield;
    }

    public String getSymbol() {
        return symbol;
    }

    public Date convertStringToDate(String string) {
        String year = string.substring(0, 4);
        String month = string.substring(5, 7);
        String day = string.substring(8, string.length());
        Date date = new Date(Integer.parseInt(day),
                Integer.parseInt(year), Integer.parseInt(month));
        return date;
    }
}

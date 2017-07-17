package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.net.MalformedURLException;
import java.time.Instant;
import java.io.IOException;
import static java.lang.Math.toIntExact;
import java.sql.Timestamp;
import java.net.URL;
/**
 * Created by joshuareno on 7/17/17.
 */
public class Stock {
    private String address;
    private double high;
    private double low;
    private double open;
    private double marketCap;
    private int marketCapChange;
    private double percentChange;
    private String symbol;
    private URL url;
    private double value;
    private double valueChange;
    private HashMap<Date, Integer> valueOverTime;
    private double volume;
    private double week52High;
    private double week52Low;
    private double yield;

    public Stock(String symbol) throws MalformedURLException{
        this.symbol = symbol;
        long time1 = Instant.now().getEpochSecond();
        int unixDate1 = 0;
        int unixDate2 = toIntExact(time1);
        address = "https://query1.finance.yahoo.com/v7/finance/download/^"
                + symbol +  "?period1=" + Integer.toString(unixDate1) + "&period2="
                + Integer.toString(unixDate2) + "&interval=1d&events=history&crumb=aDdGQcp1f2A";
        url = new URL(address);
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
}

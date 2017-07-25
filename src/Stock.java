package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.ArrayList;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

/**
 * Created by joshuareno on 7/17/17.
 */

public class Stock {
    private static String address;
    private static AreaChart areaChart;
    private static ArrayList<ArrayList<String>> arrayOfData;
    private static BufferedReader buff;
    private static double close;
    private static double high;
    private static InputStreamReader inStream;
    private static double low;
    private static double open;
    private static boolean positive;
    private static double percentChange;
    private static XYChart.Series series;
    private static String symbol;
    private static long time;
    private static URL url;
    private static URLConnection urlConnection;
    private static double value;
    private static double valueChange;
    private static int volume;

    /**
     * Sets the appropriate information about the stock
     * @param symbol
     * @throws IOException
     */
    public Stock(String symbol) throws IOException{
        this.symbol = symbol;
        time = Instant.now().getEpochSecond();
        int unixDate1 = 0;
        int unixDate2 = Math.toIntExact(time);
        System.out.println(unixDate2);
        address = "https://query1.finance.yahoo.com/v7/finance/download/"
                + symbol.toString() +  "?period1=" + Integer.toString(unixDate1) + "&period2="
                + Integer.toString(unixDate2) + "&interval=1d&events=history&crumb=aDdGQcp1f2A";
        System.out.println(address);
        url = new URL(address);

        //
        System.out.println("hi1");
        try {
            urlConnection = url.openConnection();
            urlConnection.setDoInput(true);
            inStream = new InputStreamReader(urlConnection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // this is a problem -> something is null which leads to a null pointer exceptions

        System.out.println("hi2");
        arrayOfData = new ArrayList<ArrayList<String>>();
        System.out.println("hi3");
        String buffLine = "";
        buff = new BufferedReader(inStream);
        while ((buffLine = buff.readLine()) != null) {
            arrayOfData.add(CSVtoArrayList(buffLine));
        }
        setData();
        series = new XYChart.Series();
        series.setName(symbol);
        for (ArrayList<String> array : arrayOfData) {
            Date date = convertStringToDate(array.get(0));
            int dailyValue = Integer.parseInt(array.get(5));
            series.getData().add(new XYChart.Data(date.toString(), dailyValue));
        }
        areaChart.getData().addAll(series);
    }

    /**
     * Returns the arraylist<String> for a csv string
     * @param csv
     * @return ArrayList<String>
     */
    public static ArrayList<String> CSVtoArrayList(String csv) {
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

    /**
     * Returns the areaChart from the stock's information
     * @return AreaChart
     */
    public AreaChart<Number, Number> getAreaChart() {
        return areaChart;
    }

    /**
     * Updates the stock's information
     * @throws IOException
     */
    public static void update() throws IOException {
        long oldTime = Stock.time;
        long currentTime = Instant.now().getEpochSecond();
        address = "https://query1.finance.yahoo.com/v7/finance/download/"
                + symbol +  "?period1=" + Integer.toString(Math.toIntExact(oldTime)) + "&period2="
                + Integer.toString(Math.toIntExact(currentTime)) + "&interval=1d&events=history&crumb=aDdGQcp1f2A";
        url = new URL(address);
        urlConnection = url.openConnection();
        inStream = new InputStreamReader(urlConnection.getInputStream());
        arrayOfData = new ArrayList<ArrayList<String>>();
        String buffLine;
        buff = new BufferedReader(inStream);

        Date date;
        int dailyValue;
        while ((buffLine = buff.readLine()) != null) {
            ArrayList<String> csv = CSVtoArrayList(buffLine);
            arrayOfData.add(csv);
            date = convertStringToDate(csv.get(0));
            dailyValue = Integer.parseInt(csv.get(5));
            series.getData().add(new XYChart.Data(date.toString(), dailyValue));
        }
        setData();
        areaChart.getData().clear();
        areaChart.getData().addAll(series);

    }

    /**
     * Sets the data of certain variables
     */
    public static void setData() {
        open = Double.parseDouble(arrayOfData.get(arrayOfData.size() - 1).get(1));
        high = Double.parseDouble(arrayOfData.get(arrayOfData.size() - 1).get(2));
        low = Double.parseDouble(arrayOfData.get(arrayOfData.size() - 1).get(3));
        close = Double.parseDouble(arrayOfData.get(arrayOfData.size() - 1).get(4));
        value = Double.parseDouble(arrayOfData.get(arrayOfData.size() - 1).get(5));
        volume = Integer.parseInt(arrayOfData.get(arrayOfData.size() - 1).get(6));
        double yesterdayValue = Double.parseDouble(arrayOfData.get(arrayOfData.size() - 2).get(5));
        percentChange = 100 * (value - yesterdayValue) / (yesterdayValue);
        if (percentChange > 0) {
            positive = true;
        } else if (percentChange <= 0) {
            positive = false;
        }
        valueChange = value - yesterdayValue;
    }

    /**
     * Returns the high value
     * @return Double
     */
    public Double getHigh() {
        return high;
    }

    /**
     * Returns the low value
     * @return Double
     */
    public Double getLow() {
        return low;
    }

    /**
     * Returns the open value
     * @return Double
     */
    public Double getOpen() {
        return open;
    }

    /**
     * Returns the close value
     * @return Double
     */
    public Double getClose() {
        return close;
    }

    /**
     * Returns the value
     * @return Double
     */
    public double getValue() {
        return value;
    }

    /**
     * Returns the volume
     * @return Integer
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns the stock's ticker symbol
     * @return String
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns whether or not there has been a change in the value
     * @return Boolean
     */
    public boolean getChange() {
        return positive;
    }

    /**
     * Returns the value change
     * @return Double
     */
    public double getValueChange() {
        return valueChange;
    }

    /**
     * Returns the stock's date in Date from a String
     * @param string
     * @return Date
     */
    public static Date convertStringToDate(String string) {
        String year = string.substring(0, 4);
        String month = string.substring(5, 7);
        String day = string.substring(8, string.length());
        Date date = new Date(Integer.parseInt(day),
                Integer.parseInt(year), Integer.parseInt(month));
        return date;
    }
}

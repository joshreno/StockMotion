package src;

import java.util.Calendar;

/**
 * Created by joshuareno on 7/16/17.
 */

public class Date {
    private int month;
    private int day;
    private int year;

    /**
     * Sets the day, year, and month
     * @param day
     * @param year
     * @param month
     */
    public Date(int day, int year, int month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    /**
     * Returns a Date from a Calendar
     * @param calendar
     * @return Date
     */
    public static Date Date(Calendar calendar) {
        return new Date (calendar.get(5), calendar.get(1), calendar.get(2));
    }

    /**
     * Sets the day
     */
    public Date() {
        this(1, 1970, 1);
    }

    /**
     * Sets the day
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Returns the day
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the year
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the month
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Returns the month
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the day, year, and month
     * @param day
     * @param year
     * @param month
     */
    public void setDate(int day, int year, int month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    /**
     * returns the current day
     * @return Date
     */
    public Date getCurrentDay() {
        return new Date(
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.YEAR) - 1900,
                Calendar.getInstance().get(Calendar.MONTH));
    }

    /**
     * Returns the date in string format
     * @return String
     */
    public String toString() {
        String day = "";
        String month = "";
        if (this.day < 10) {
            day = "0" + this.day;
        }
        if (this.month < 10) {
            month = "0" + this.month;
        }
        return day + "/" + month + "/" + year;
    }
}
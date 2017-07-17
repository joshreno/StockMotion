// import the current day
/**
 * Created by joshuareno on 7/16/17.
 */
package src;
public class Date {
    private Month month;
    private int day;
    private int year;

    /**
     * Sets the day, year, and month
     * @param day
     * @param year
     * @param month
    */
    public Date(int day, int year, Month month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    /**
     * Sets the day
    */
    public Date() {
        this(0, 0, Month.UNKNOWN);
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
    public void setMonth(Month month) {
        this.month = month;
    }

    /**
     * Returns the month
     * @return month
    */
    public Month getMonth() {
        return month;
    }

    /**
     * Sets the day, year, and month
     * @param day
     * @param year
     * @param month
    */
    public void setDate(int day, int year, Month month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }
}
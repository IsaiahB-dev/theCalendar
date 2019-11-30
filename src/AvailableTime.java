import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AvailableTime {
    // These are needed for reading from file
    public int startTime;
    public int endTime;
    public int day;
    private String medium;

    // These are maybe needed to calculate for the parser but thats it 
    public int days;
    public int month;
    public int year;

    
    /**
     * This constructor is used for the parser
     * @param month: Month the date lands on
     * @param day: The day of the month the time lands on
     * @param year: The year that the date lands on 
     * @param startTime: Start time for the free time rounded to whole number
     * @param endTime: End time for the free time rounded to whole number
     * @param days: The number of days the time lands on (This does not seem necessary to me)
     */
    public AvailableTime(int month, int day, int year, int startTime, int endTime, int days) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    /**
     * This constructor is for classes being generated from reading a file.
     * @param startTime: Starting hour for the free time
     * @param endTime: Ending hour for the free time
     * @param day: The day that the free time is scheduled
     * @param medium: Wether the time is before or after noon
     */
    public AvailableTime(int startTime, int endTime, int day, String medium)
    {
        this.startTime = startTime;
        this.day = day;
        this.endTime = endTime;
        this.medium = medium;
    }

    /**
     * Default constructor that does nothing
     */
    public AvailableTime(){}

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getDays() {
        return days;
    }

    public int getMonth(){ return month; }

    public int getDay(){ return day; }

    public int getYear(){ return year; }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setDays(int days) { this.days = days; }

    public void setMonth(int month) { this.month = month;}

    public void setDay(int day) { this.day = day;}

    public void setYear(int year) { this.year = year; }
}
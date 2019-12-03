import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AvailableTime {
    // These are needed for reading from file
    private int startTime;
    private int endTime;
    private int day;


    /**
     * This constructor is for classes being generated from reading a file.
     * @param startTime: Starting hour for the free time
     * @param endTime: Ending hour for the free time
     * @param day: The day that the free time is scheduled
     */
    public AvailableTime(int startTime, int endTime, int day)
    {
        this.startTime = startTime;
        this.day = day;
        this.endTime = endTime;
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


    public int getDay(){ return day; }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    public void setDay(int day) { this.day = day;}
}
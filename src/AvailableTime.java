import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AvailableTime {
    public int startTime;
    public int endTime;
    public int days;
    public int month;
    public int day;
    public int year;

    public AvailableTime() {
        this.month = month;
        this.day = day;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }


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








/*  Calendar time = new GregorianCalendar();

  private Date startTime = new Date();
  private Date endTime = new Date();
  private  String date = "";
  private int priority = 0;



    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }
*/



//public void time(int year, int month, int dayOfMonth, int hourOfDay, int minute)
//{}
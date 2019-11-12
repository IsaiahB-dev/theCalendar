import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AvailableTime {
    Calendar time = new GregorianCalendar();

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




//public void time(int year, int month, int dayOfMonth, int hourOfDay, int minute)
    //{}



}
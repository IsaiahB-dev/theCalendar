import java.util.ArrayList;
import java.util.*;
public class UserCalendar {

    // This is a list of the day class
    // Each day class is an array list of available times
    private List<Day> availableTimes = new ArrayList<>();
    String user = "";
    public double matchPercent; // percent of primary user's
                                // available time that matches
    private int id;

    public UserCalendar(List<Day> availableTimeList, String userName) {
        this.availableTimes = availableTimeList;
        this.user = userName;
        this.matchPercent = 0.0;
    }

    /**
     * Constructor to use for default stuff
     */
    public UserCalendar() {}

    public void refresh(AvailableTime Refresh) {

    }

    public void addTime (AvailableTime AddTime) {

    }

    public void updateSavedSchedule() {

    }

    // Needs to have parser implemented
    public void createSchedulerFromFile() {


    }

    public void setMatchPercent(double matchPercent) {
        this.matchPercent = matchPercent;
    }

    public double getMatchPercent() {
        return matchPercent;
    }

    public void setUserName(String userName) {
        this.user = userName;
    }

    public String getUserName() {
        return user;
    }

    public List<Day> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<Day> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public void addAvailableTime(AvailableTime time, int day) {
        this.availableTimes.get(day).addTime(time);
    }

    public void setId(int id) {
        this.id = id;
    }
}
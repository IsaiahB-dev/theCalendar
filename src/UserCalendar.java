import java.util.ArrayList;
import java.util.*;
public class UserCalendar {

    // This is a list of the day class
    // Each day class is an array list of available times
    private List<AvailableTime> availableTimes = new ArrayList<>();
    String user = "";
    private double matchPercent; // percent of primary user's
                                // available time that matches
    private int id;

    public UserCalendar(List<AvailableTime> availableTimeList, String userName) {
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
        availableTimes.add(AddTime);

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

    public List<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<AvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public void addAvailableTime(AvailableTime time) {
        this.availableTimes.add(time);
    }

    public void setId(int id) {
        this.id = id;
    }
}
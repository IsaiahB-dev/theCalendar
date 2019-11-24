import java.util.ArrayList;
import java.util.*;
public class UserCalendar {

    private ArrayList<AvailableTime> availableTimes = new ArrayList<>();
    String user = "";
    public double matchPercent; // percent of primary user's
                                // available time that matches

    public UserCalendar(ArrayList<AvailableTime> availableTimeList, String userName) {
        this.availableTimes = availableTimeList;
        this.user = userName;
        this.matchPercent = 0.0;
    }

    public void refresh(AvailableTime aRefresh) {

    }

    public void addTime (AvailableTime aAddTime) {

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

    public ArrayList<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(ArrayList<AvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public void addAvailableTime(AvailableTime atime) {
        this.availableTimes.add(atime);
    }

}
import java.util.ArrayList;
import java.util.*;
public class UserCalendar {

    private ArrayList<AvailableTime> availableTimes = new ArrayList<>();
    String user = "";
    public double matchPercent; // percent of primary user's
                                // available time that matches

    public void refresh(AvailableTime object) {

    }

    public void addTime (AvailableTime object) {

    }

    public void updateSavedSchedule(){

    }

    // Needs to have parser implemented
    public void createSchedulerFromFile(){


    }

    public double getMatchPercent() {
        return matchPercent;
    }

    public String getUserName() {
        return user;
    }

    public ArrayList<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setMatchPercent(double matchPercent) {
        this.matchPercent = matchPercent;
    }

    public void setUserName(String userName) {
        this.user = userName;
    }

    public void setAvailableTimes(ArrayList<AvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }
    public void addAvailableTime(AvailableTime atime) {
        this.availableTimes.add(atime);
    }

    public UserCalendar(ArrayList<AvailableTime> availableTimeList, String userName) {
        this.availableTimes = availableTimeList;
        this.user = userName;
        this.matchPercent = 0.0;
    }
}
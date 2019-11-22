import java.util.ArrayList;

public class aUserCalendar {
    public ArrayList<aAvailableTime> availableTimes;
    public double matchPercent; // percent of primary user's
                                // available time that matches
    public String userName;

    public aUserCalendar(ArrayList<aAvailableTime> availableTimes,
                         String userName) {
        this.availableTimes=availableTimes;
        this.userName = userName;
        this.matchPercent = 0.0;
    }

    public double getMatchPercent() {
        return matchPercent;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<aAvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setMatchPercent(double matchPercent) {
        this.matchPercent = matchPercent;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAvailableTimes(ArrayList<aAvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }
    public void addAvailableTime(aAvailableTime atime) {
        this.availableTimes.add(atime);
    }
}

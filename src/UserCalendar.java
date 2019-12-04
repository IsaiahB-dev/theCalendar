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



    public void updateSavedSchedule() {

    }

    // Needs to have parser implemented
    public void createSchedulerFromFile() {


    }

    /**
     *
     * @param AddTime Method that will add time to available times
     */
    public void addTime (AvailableTime AddTime) {
        availableTimes.add(AddTime);

    }
    /**
     *
     * @param matchPercent Method that will set the matched percentage of users from the CalendarRanker class
     */
    public void setMatchPercent(double matchPercent) {
        this.matchPercent = matchPercent;
    }

    /**
     * Gets the matched percentage of users
     * @return returns the double value of the users' matched percentage
     */
    public double getMatchPercent() {
        return matchPercent;
    }

    /**
     *
     * @param userName Method that will set the user's username
     */
    public void setUserName(String userName) {
        this.user = userName;
    }

    /**
     * Gets the user name of the most recent user
     * @return returns the String value of the user's username
     */
    public String getUserName() {
        return user;
    }

    /**
     * gets the available times from the list of available times
     * @return returns the available time from the list of available times
     */
    public List<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    /**
     *
     * @param availableTimes Method that will set the user's available time
     */
    public void setAvailableTimes(List<AvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }

    /**
     *
     * @param time Method that adds the available time to the list of available times
     */
    public void addAvailableTime(AvailableTime time) {
        this.availableTimes.add(time);
    }

    /**
     *
     * @param id Method that sets the user's ID
     */
    public void setId(int id) {
        this.id = id;
    }
}
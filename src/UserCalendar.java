import java.util.*;

/**
 * Class to hold an individuals free time schedule
 */
public class UserCalendar implements Comparable<UserCalendar>{

    // This is a list of the day class
    // Each day class is an array list of available times
    private List<AvailableTime> availableTimes = new ArrayList<>();
    private List<AvailableTime> blankavailableTimes = new ArrayList<>();
    String user = "";
    private Double matchPercent; // percent of primary user's
                                // available time that matches
    private int id;

    /**
     * Constructor to create user calendar
     * @param availableTimeList: List of available times 
     * @param userName: The users username
     */
    public UserCalendar(List<AvailableTime> availableTimeList, String userName) {
        this.availableTimes = availableTimeList;
        this.user = userName;
        this.matchPercent = 0.0;
        this.blankavailableTimes.add(new AvailableTime(0,0,0));
    }

    /**
     * Constructor to use for default stuff
     */
    public UserCalendar() {}


    /**
     * Function to append a tim to the list of available times
     * @param AddTime Method that will add time to available times
     */
    public void addTime (AvailableTime AddTime) {
        availableTimes.add(AddTime);

    }
    /**
     * Sets a percentage for how much this schedule matched another users
     * @param matchPercent: Double value of matched schedule to user
     */
    public void setMatchPercent(Double matchPercent) {
        this.matchPercent = matchPercent;
    }

    /**
     * Gets the matched percentage of users schedules to the current user
     * @return returns the double value of the users' matched percentage
     */
    public Double getMatchPercent() {
        return matchPercent;
    }

    /**
     * Sets the users username
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
     * Gets the available times from the list of available times
     * @return returns the available time from the list of available times
     */
    public List<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    /**
     * Gets blank available times list (like NULL)
     * @return returns NULL available times
     */
    public List<AvailableTime> getblankavailableTimes() {
        return blankavailableTimes;
    }

    /**
     *  Sets users list of available times to a given list of avialable times 
     * @param availableTimes Method that will set the user's available time
     */
    public void setAvailableTimes(List<AvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }

    /**
     * Add available time to list of users times
     * @param time Method that adds the available time to the list of available times
     */
    public void addAvailableTime(AvailableTime time) {
        this.availableTimes.add(time);
    }

    /**
     * Set the users id
     * @param id Method that sets the user's ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get the user's id
     * @return id of user (an int) that corresponds with their place in the database
     */
    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(UserCalendar u) {
        return getMatchPercent().compareTo(u.getMatchPercent());
    }
}
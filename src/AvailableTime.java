/**
 * AvailableTime public class that holds the variables for the user's attributes
 */
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

    /**
     * Gets the start time from the AvailableTimeFormGUI class
     * @return returns the int value of the start time if value is less than 21 and greater than 7 (military time)
     */
    public int getStartTime() {
        return startTime;
    }
    /**
     * Gets the end time from the AvailableTimeFormGUI class
     * @return returns the int value of the end time if value less than 21 (military time)
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * Gets the day from the AvailableTimeFormGUI class
     * @return returns the int value of the day if value is greater than 0 and less than 6
     */
    public int getDay(){
            return day;
    }

    /**
     *
     * @param startTime Method that will set the start time value that is given from the AvailableTimeFormGUI class
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @param endTime  Method that will set the end time value that is given from the AvailableTimeFormGUI class
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @param day Method that will set the day value that is given from the AvailableTimeFormGUI class
     */
    public void setDay(int day) {
        this.day = day;
    }
}
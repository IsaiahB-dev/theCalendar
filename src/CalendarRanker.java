import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;


public class CalendarRanker {
    private User user; // need to know who the current user is
    private UserCalendar userCalendar; // need to access the current user's calendar

    // list of all the calendars
    private List<UserCalendar> calendars = new ArrayList<>(); 


    public CalendarRanker(User user) {
        // Sets the user equal to the passed arguments
        this.user = user;

        // Create the database object to stream data
        DatabaseComm stream = new DatabaseComm();

        // Sets a list of the user calendars
        calendars = stream.getCalendars(); // Returns a list of the users' calendars

        // Sets the schedule for the current user 
        for (int i = 0; i < calendars.size(); i++) {
            if (user.getId() == calendars.get(i).getId()) {
                userCalendar = calendars.get(i);
            }
        }
        
    }

    public List<UserCalendar> calculateMatch() {
        List<UserCalendar> sortedUserCalendars = calendars;
        int totalUsersHours = 0;
        List<AvailableTime> userTimes = userCalendar.getAvailableTimes();

        for (int i = 0; i < userCalendar.getAvailableTimes().size(); i++) {
            AvailableTime tmp = userCalendar.getAvailableTimes().get(i);
            totalUsersHours += (tmp.getEndTime() - tmp.getStartTime());
        }

        // For all the calendars in the file
        for (int i = 0; i < calendars.size(); i++) {
            // If they are not the current users calendar
            int totalCompareeOverlap = 0;

            if (userCalendar.getId() != calendars.get(i).getId()) {
                // For every time object in the current user calendars list 
                for (int j = 0; j < calendars.get(i).getAvailableTimes().size(); j++) {
                    AvailableTime tmp = calendars.get(i).getAvailableTimes().get(j);
                    // For every time object the user has
                    for (int n = 0; n < userTimes.size(); n++) {
                        AvailableTime tempUser = userTimes.get(n);
                        totalCompareeOverlap += max(min(tmp.getEndTime(), tempUser.getEndTime()) - max(tmp.getStartTime(), tempUser.getStartTime()) + 1, 0);
                    }
                }
            }

            if (totalUsersHours == 0) {
                calendars.get(i).setMatchPercent(0.0);
            }
            else {
                calendars.get(i).setMatchPercent((double) (totalCompareeOverlap / totalUsersHours));
            }
            
        }
        
        // Sorts and reverses the list so its best to worst
        Collections.sort(sortedUserCalendars);
        Collections.reverse(sortedUserCalendars);
        return sortedUserCalendars;
    }

    /**
     * Function to find the max between two numbers
     * @param num1: Int 
     * @param num2: Int
     * @return: Largest number of the inputs
     */
    private int max(int num1, int num2) {
        if (num1 < num2) {
            return num2;
        }
        else {
            return num1;
        }
    }

    /**
     * Function to find the min between two numbers
     * @param num1: Int 
     * @param num2: Int
     * @return: Smallest number of the inputs
     */
    private int min(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        }
        else {
            return num2;
        }
    }

}


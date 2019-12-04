import java.util.List;
import java.util.Collections;
import java.util.NoSuchElementException;


// CalendarRanker Model Class
// Uses: UserCalendar, DatabaseComm
// DatabaseComm populates a list of all UserCalendar database data
// CalendarRanker assigns compatibility ranking to each database person
// CalendarRanker re-ranks everyone when the user updates their calendar

public class CalendarRanker {
    private User user; // need to know who the current user is
    private UserCalendar userCalendar; // need to access the current user's calendar

    private List<User> users; // list of all the users
    private List<UserCalendar> calendars; // list of all the calendars

    // Should we have another list that we sort according to

    // Constructor to be called by RankingsGUI
    public CalendarRanker() {
        // Get the current user's data (user id and calendar)
        // I can't think of how to do this @@$@#%@%@#%@#%@#
        //this.user = user;
        //this.userCalendar = userCalendar;

        // Create the database object to stream data
        DatabaseComm stream = new DatabaseComm();

        // Grabbing the data from the database
        this.users = stream.getUsers();         // Returns a list of users
        this.calendars = stream.getCalendars(); // Returns a list of the users' calendars

        // Now that we have all the data, run the ranking function to update the matchPercent values
        // It also needs to provide a sorted list to the GUI
        calculateMatch();


    }

    public void calculateMatch() {
        // Calculate total number of available hours in main user's calendar.
        // Traverse array of all users' calendars and compare them
        // to the main user's calendar available times.
        // Calculate number of matching hours.
        // Divide by main user's total number of hours to get
        // percent of matching hours.

        // Dummy operation
        /*for(int i = 0; i<calendars.size(); i++) {
            this.calendars[i].setMatchPercent(30.0 + (double)i);
        }
        */

    }

}


import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;


// CalendarRanker Model Class
// Uses: UserCalendar, DatabaseComm
// DatabaseComm populates a list of all UserCalendar database data
// CalendarRanker assigns compatibility ranking to each database person
// CalendarRanker re-ranks everyone when the user updates their calendar

public class CalendarRanker {
    public ArrayList<UserCalendar> calendars;
    public UserCalendar userCalendar; // need to access the user's calendar

    public CalendarRanker(ArrayList<UserCalendar> calendars, UserCalendar userCalendar) {
        this.calendars = calendars;
        this.userCalendar = userCalendar;
    }

    public void addCalendar(UserCalendar acalendar) {
        this.calendars.add(acalendar);
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


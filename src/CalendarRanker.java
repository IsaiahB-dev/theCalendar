import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;


// CalendarRanker Model Class
// Uses: UserCalendar, DatabaseComm
// DatabaseComm populates a list of all UserCalendar database data
// CalendarRanker assigns compatibility ranking to each database person
// CalendarRanker re-ranks everyone when the user updates their calendar

public class CalendarRanker {
    public ArrayList<aUserCalendar> calendars;
    public aUserCalendar userCalendar; // need to access the user's calendar

    public CalendarRanker(ArrayList<aUserCalendar> calendars, aUserCalendar userCalendar) {
        this.calendars = calendars;
        this.userCalendar = userCalendar;
    }

    public void addCalendar(aUserCalendar acalendar) {
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
        for(int i = 0; i<calendars.size(); i++) {
            this.calendars[i].setMatchPercent(30.0 + (double)i);
        }


    }

}

public class aAvailableTime {
    public int startTime;
    public int endTime;
    public ArrayList<Int> days;

    public aAvailableTime(int startTime, int endTime, ArrayList<Int> days) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public ArrayList<Int> getDays() {
        return days;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setDays(ArrayList<Int> days) {
        this.days = days;
    }
}
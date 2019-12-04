import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class MainWindowGUI implements ActionListener{
    JFrame frame;
    JPanel buttonsP;
    JButton time;
    User user;
    List<CalendarTime> CalTimes;
    CalendarTime r1 = new CalendarTime(8, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r2 = new CalendarTime(9, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r3 = new CalendarTime(10, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r4 = new CalendarTime(11, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r5 = new CalendarTime(12, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r6 = new CalendarTime(1, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r7 = new CalendarTime(2, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r8 = new CalendarTime(3, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r9 = new CalendarTime(4, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r10 = new CalendarTime(5, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r11 = new CalendarTime(6, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r12 = new CalendarTime(7, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    CalendarTime r13 = new CalendarTime(8, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
    MainWindowGUI(User user) {
        this.user = user;

        CalTimes = new ArrayList<>();
        CalTimes.add(r1);
        CalTimes.add(r2);
        CalTimes.add(r3);
        CalTimes.add(r4);
        CalTimes.add(r5);
        CalTimes.add(r6);
        CalTimes.add(r7);
        CalTimes.add(r8);
        CalTimes.add(r9);
        CalTimes.add(r10);
        CalTimes.add(r11);
        CalTimes.add(r12);
        CalTimes.add(r13);

        // New database comm object to get and save data
        DatabaseComm stream = new DatabaseComm();
        java.util.List<UserCalendar> calendars = stream.getCalendars(); // Gets a list of the calendars

        // If the user has an id that is at max the size of the list he is already in the list
        if (user.getId() <= calendars.size()) {
            UserCalendar cal = calendars.get(user.getId() - 1); // Pulls out the calendar to save the time to
            java.util.List<AvailableTime> times = cal.getAvailableTimes(); // Gets a list of that calendars times
            for (AvailableTime t : times){
                if(t.getDay() == 1){
                    for (CalendarTime c : CalTimes){
                        if(CalTimes.indexOf(c) <= (t.getStartTime() - 8) && CalTimes.indexOf(c) >= (t.getEndTime() - 8) ){
                            c.setMonday(CalendarTime.Times.Y);
                        }
                    }
                }
            }
        }
        else { // If his id is larger then he is new and needs to be added
            UserCalendar newCalendar = new UserCalendar(); // Creates a new calendar object for the new user
            newCalendar.setId(user.getId()); // Sets the id to the new users id
            // Get a list of available times from the new user calendar object
            List<AvailableTime> times = newCalendar.getAvailableTimes();
            calendars.add(newCalendar); // Add the new calendar to the list
        }


        frame = new JFrame("Calendar Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonsP = new JPanel();

        time = new JButton("Add Time");

        time.setVisible(true);
        time.setBounds(50, 30, 10, 10);
        buttonsP.add(time);

        frame.add(buttonsP, BorderLayout.PAGE_START);

        time.addActionListener(this);

        RankingsGUI r = new RankingsGUI();
        CalendarGUI c = new CalendarGUI(CalTimes);
        frame.add(r.rankingP, BorderLayout.EAST);
        frame.add(c.calendarPanel, BorderLayout.CENTER);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // This is where we will add the calls to store the user in the database and log
    // him in i believe
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == time) {
            // If the add time function is pressed the current user is passed in so the time is given to the correct user
            new AvailableTimeFormGUI(this.user);
        }
    }

    /**
     * This is the main function to initialize the software
     * @param args
     */
    public static void main(String[] args) {
        // Generates a user for the program
        User mainUser = new User();

        // Passes it to the login gui to be populated.
        new UserLoginGUI(mainUser);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainWindowGUI implements ActionListener {
    JFrame frame;
    JPanel buttonsP;
    JButton time;
    JButton logout;
    User user;
    List<AvailableTime> times;

    /**
     * The MainWindowGUI consists of three JPanes/JPanels: RankingsGUI, CalendarGUI, and the button pane at the top.
     * This class takes a User object parameter because the current user's data is the most relevant to the display.
     * This GUI is the "central hub" for the program itself.
     * @param user
     */
    MainWindowGUI(User user) {
        this.user = user;

        // New database comm object to get and save data
        DatabaseComm stream = new DatabaseComm();
        java.util.List<UserCalendar> calendars = stream.getCalendars(); // Gets a list of the calendars

        // If the user has an id that is at max the size of the list he is already in the list
        if (user.getId() <= calendars.size()) {
            UserCalendar cal = calendars.get(user.getId() - 1); // Pulls out the calendar to save the time to
            times = cal.getAvailableTimes(); // Gets a list of that calendars times
        }

        frame = new JFrame("Calendar Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonsP = new JPanel();

        time = new JButton("Add Time");
        logout = new JButton("Log Out");

        time.setVisible(true);
        time.setBounds(50, 30, 10, 10);
        buttonsP.add(time);

        logout.setVisible(true);
        logout.setBounds(50, 30, 10, 10);
        buttonsP.add(logout);

        frame.add(buttonsP, BorderLayout.PAGE_START);

        time.addActionListener(this);
        logout.addActionListener(this);

        RankingsGUI r = new RankingsGUI(user);
        CalendarGUI c = new CalendarGUI(times);
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
            // Moved these actions to the AvailableTimeFormGUI so that we can see the calendar while adding times
            //frame.setVisible(false);
            //frame.dispose();

            // If the add time function is pressed the current user is passed in so the time is given to the correct user
            new AvailableTimeFormGUI(this.user, this.frame);
        }
        if (ae.getSource() == logout) {
            // Start over fresh with a new login
            frame.setVisible(false);
            frame.dispose();
            System.out.println("Tried to log out");
            new UserLoginGUI(new User());
        }
    }

    /**
     * This is the main function to initialize the software
     *
     * @param args
     */
    public static void main(String[] args) {
        // Generates a user for the program
        User mainUser = new User();

        // Passes it to the login gui to be populated.
        new UserLoginGUI(mainUser);

    }
}

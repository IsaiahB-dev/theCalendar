import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class MainWindowGUI implements ActionListener{
    JFrame frame;
    JPanel buttonsP;
    JButton time;
    User user;

    MainWindowGUI(User user) {
        this.user = user;

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
        CalendarGUI c = new CalendarGUI();
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

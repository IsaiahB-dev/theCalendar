import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.xml.crypto.Data;


/**
 * GUI to display the users of a ranked list based on match percentage
 */
public class RankingsGUI extends JPanel {
    public JPanel rankingP;

    /**
     * Creates and populates the rankings GUI with the list of users.
     * @param user: The current logged in user.
     */
    RankingsGUI(User user, MainWindowGUI mainGUI) {
        // Create panel to display the ranking of people with best-matched schedules
        rankingP = new JPanel();

        // give ranking panel a Grid Layout
        // Grid Layout makes the buttons spread out and all be the same size
        rankingP.setLayout(new GridLayout(15,1));

        // create a JLabel title for the RankingGUI internal frame
        JLabel title = new JLabel("Best-Matched Schedules", SwingConstants.CENTER);
        rankingP.add(title);

        // create a button group so that the buttons act like radio buttons
        ButtonGroup bg = new ButtonGroup();

        // Set the clicked-button color
        UIManager.put("ToggleButton.select", new Color(190, 186, 164));

        // create action listener for the ranking listings
        ActionListener listener = actionEvent ->
            {
                DatabaseComm stream = new DatabaseComm();
                List<User> users = stream.getUsers();
                List<UserCalendar> calendars = stream.getCalendars();

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUsername().equals(actionEvent.getActionCommand())) {
                        for (int j = 0; j < calendars.size(); j++) {
                            if (users.get(i).getId() == calendars.get(j).getId()) {

                                List<AvailableTime> times = calendars.get(i).getAvailableTimes();
                                List<AvailableTime> othertimes = calendars.get(i).getAvailableTimes();
                                mainGUI.updateCalendarGUI(new CalendarGUI(times, othertimes));
                            }
                        }
                    }
                }
            };

        // get preferred frame sizing
        JButton sizeB = new JButton("FakeFirstName FakeLastName");
        Dimension buttonSize = sizeB.getPreferredSize();
        rankingP.setPreferredSize(new Dimension((int)(buttonSize.getWidth()),
                (int)(buttonSize.getHeight() * 15)));

        // username list will come from CalendarRanker (should also include user id)
        // it will be in order from best match to worst
        DatabaseComm stream = new DatabaseComm();
        CalendarRanker ranker = new CalendarRanker(user);
        List<UserCalendar> calendars = ranker.calculateMatch();
        List<User> users = stream.getUsers();

        ArrayList<String> usernames = new ArrayList<>();

        for (int i = 0; i < calendars.size(); i ++) {
            for (int j = 0; j < users.size(); j++) {
                if (calendars.get(i).getId() == users.get(j).getId()) {
                    usernames.add(users.get(j).getUsername());
                }
            }
        }
        // number of users will come from length of list supplied by CalendarRanker
        int numUsers = usernames.size(); // total number of users minus 1 (current user)

        // add up to 14 users to the ranking list
        for (int i = 0; i < numUsers && i < 14; i++) {
            String name = usernames.get(i);
            if(user.getUsername().equals(name))
            {
                // do nothing
            }
            else
            {
                JToggleButton jtb = new JToggleButton(name);
                jtb.addActionListener(listener);
                jtb.setPreferredSize(new Dimension(130, 30));
                bg.add(jtb); // add button to group
                rankingP.add(jtb); // add button to ranking panel
            }
        }

        rankingP.setVisible(true);
    }
}
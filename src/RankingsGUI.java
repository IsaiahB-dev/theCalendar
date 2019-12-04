import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.xml.crypto.Data;

// Displays ranking list of people whose schedules best match user
//

public class RankingsGUI extends JPanel {
    public JPanel rankingP;

    RankingsGUI(User user) {
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
                AbstractButton ab = (AbstractButton) actionEvent.getSource();
                boolean selected = ab.getModel().isSelected();
                System.out.println(actionEvent.getActionCommand() + " Selected = " + selected);
                // Need to include action to display selected user's calendar overlay (only where matching)
                // That should be a function from CalendarGUI where you supply it the user id number

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
            String name = (i+1)  + " - " +  usernames.get(i);
            JToggleButton jtb = new JToggleButton(name);
            jtb.addActionListener(listener);
            jtb.setPreferredSize(new Dimension(130, 30));
            bg.add(jtb); // add button to group
            rankingP.add(jtb); // add button to ranking panel
        }

        rankingP.setVisible(true);
    }
}
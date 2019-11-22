import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

// Displays ranking list of people whose schedules best match user
//

public class RankingsGUI extends JPanel {
    RankingsGUI()
    {
        // Create panel to display the ranking of people
        // with best-matched schedules
        JPanel rankingP = new JPanel();

        // give ranking panel a Box Layout
        rankingP.setLayout(new BoxLayout(rankingP, BoxLayout.Y_AXIS));

        for(int i=1; i<=10; i++) {
            String name = "Bob" + " " + i;
            JLabel label = new JLabel(name);
            rankingP.add(label);
        }

    }
}
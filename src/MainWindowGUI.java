import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class MainWindowGUI implements ActionListener{
    JFrame frame;
    JPanel buttonsP;
    JButton time;

    MainWindowGUI() {
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
        frame.add(r.rankingIFrame, BorderLayout.EAST);
        frame.add(c.calendarPanel, BorderLayout.CENTER );
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // This is where we will add the calls to store the user in the database and log him in i believe
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == time)
        {
            new AvailableTimeFormGUI();
        }
    }


    public static void main(String[] args) { new MainWindowGUI(); }
}

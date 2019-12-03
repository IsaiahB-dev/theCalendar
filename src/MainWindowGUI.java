import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class MainWindowGUI {
    MainWindowGUI() {
        JFrame frame = new JFrame("Calendar Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonsP = new JPanel();

        JButton time = new JButton("Add Time");
        time.setVisible(true);
        time.setBounds(50, 30, 10, 10);
        buttonsP.add(time);

        frame.add(buttonsP, BorderLayout.PAGE_START);

        RankingsGUI r = new RankingsGUI();
        CalendarGUI c = new CalendarGUI();
        frame.add(r.rankingIFrame, BorderLayout.EAST);
        frame.add(c.calendarIFrame, BorderLayout.CENTER );
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) { new MainWindowGUI();
    }
}

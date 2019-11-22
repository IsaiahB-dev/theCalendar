import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class MainWindowGUI {
    MainWindowGUI(){
        JFrame frame = new JFrame("Calendar Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 800);

        JPanel buttonsP = new JPanel();

        JButton time = new JButton("Add Time");
        time.setVisible(true);
        time.setBounds(50, 30, 10, 10);
        buttonsP.add(time);

        frame.add(buttonsP, BorderLayout.PAGE_START);

        RankingsGUI rankingP = new RankingsGUI();
        frame.add(rankingP, BorderLayout.CENTER);
        rankingP.setVisible(true);

        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String args[]){
        new MainWindowGUI();
    }
}

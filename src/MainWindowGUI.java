import javax.swing.*;
import java.util.Calendar;

public class MainWindowGUI {
    MainWindowGUI(){
        JFrame frame = new JFrame("Calendar Scheduler");
        frame.setVisible(true);
        frame.setSize(1000, 800);

        JButton time = new JButton("Add Time");
        time.setVisible(true);
        time.setBounds(50, 30, 10, 10);
        frame.add(time);
    }

    public static void main(String args[]){
        new MainWindowGUI();
    }
}

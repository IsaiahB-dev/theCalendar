import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AvailableTimeFormGUI extends JFrame {
    //Variables
    JFrame timeWindow;
    JLabel startTimeLabel,endTimeLabel ;
    JButton bSubmitStartTime,bSubmitEndTime;
    JPanel panel;
    JTextField startTextField,endTextField;
        /* *
       Empty method at the moment
         */
    public void setCalendarTimes() {
    }
    //Constructor for AvailableTimeFormGUI
    AvailableTimeFormGUI() {
        //sets the frame and title of the frame's window
        timeWindow = new JFrame("Available Time Form");

        //Created labels for the start and endtime placeholders
        startTimeLabel = new JLabel("Enter start Time");
        endTimeLabel = new JLabel("Enter end Time");

        //created temporary fields for a user to input their start and endtime.
        startTextField = new JTextField();
        endTextField = new JTextField();
        //Panel created for the labels and buttons. Used GridLayout because the content looks better
        panel = new JPanel(new GridLayout(2,2 , 2, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
        add(panel, BorderLayout.CENTER);
        //created buttons for the start and end times, along with bounds
        bSubmitStartTime = new JButton("Submit Start Time");
        bSubmitStartTime.setBounds(200, 150, 90, 50);
        bSubmitEndTime = new JButton("Submit End Time");
        bSubmitEndTime.setBounds(200, 150, 90, 50);

        //added the contents to the panel
        panel.add(startTimeLabel);
        panel.add(startTextField);
        panel.add(bSubmitStartTime);
        panel.add(endTimeLabel);
        panel.add(endTextField);
        panel.add(bSubmitEndTime);

        //added the panel to the frame.
        timeWindow.add(panel);
        //Set the size of the frame and set the frame visible.
        timeWindow.setSize(500, 500);
        timeWindow.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        new AvailableTimeFormGUI();
    }
}
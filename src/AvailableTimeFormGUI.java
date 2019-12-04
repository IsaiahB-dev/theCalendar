import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AvailableTimeFormGUI extends JFrame implements ActionListener {

    //Variables
   private JFrame timeWindow;
   private JMenuBar menuBar = new JMenuBar();
   private JPopupMenu dayMenu = new JPopupMenu();
   private JMenuItem day = new JMenuItem();

   private JLabel startTimeLabel,endTimeLabel , dayLabel;
   private JButton bSubmit;
   private JPanel panel1, panel2;
   private JTextField startTextField,endTextField, dayTextField;
    /* *
   Empty method at the moment
     */
    public void setCalendarTimes() {
    }
    //Constructor for AvailableTimeFormGUI
    AvailableTimeFormGUI() {

      /*  day = new JMenuItem("Monday");
        dayMenu.add(day);
        day = new JMenuItem("Tuesday");
        dayMenu.add(day);
        day = new JMenuItem("Wednesday");
        dayMenu.add(day);
        day = new JMenuItem("Thursday");
        dayMenu.add(day);
        day = new JMenuItem("Friday");
        dayMenu.add(day);
        menuBar.add(dayMenu);
        */
        //sets the frame and title of the frame's window

        timeWindow = new JFrame("Available Time Form (Military Time)");
        //Set the size of the frame and set the frame visible.
        timeWindow.setSize(500, 500);

        //Created labels for the start time, end time, and day placeholders
        startTimeLabel = new JLabel("    Enter Start Time between 8 - 20 (Only the hour)");
        endTimeLabel = new JLabel("    Enter End Time between 8 - 20 (Only the hour)");
        dayLabel = new JLabel("    Enter Day (1-5)");

        //created temporary fields for a user to input their start time, end time, and day.
        startTextField = new JTextField();
        endTextField = new JTextField();
        dayTextField = new JTextField();
        //align Jtextfields to have input in the center
        startTextField.setHorizontalAlignment(JTextField.CENTER);
        endTextField.setHorizontalAlignment(JTextField.CENTER);
        dayTextField.setHorizontalAlignment(JTextField.CENTER);
        // Panel1 created for the labels and textfields and panel2 is created for the submit button.
        // Used GridLayout because the content looks better
        //Still trying to figure out how to center the the submit button on panel2
        panel1 = new JPanel(new GridLayout(5,5 , 2, 2));
        panel2 = new JPanel(new GridLayout(1,1 ,1, 3));
        //panel.setBorder(BorderFactory.createEmptyBorder(50, 10, 150, 10));
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.CENTER);
        //created a button for submission, along with bounds
        bSubmit = new JButton("Submit Here");
        bSubmit.setBounds(50, 150, 90, 50);


        //added the contents to the panel1
        panel1.add(startTimeLabel);
        panel1.add(startTextField);
        panel1.add(endTimeLabel);
        panel1.add(endTextField);
        panel1.add(dayLabel);
        panel1.add (dayTextField);
     //   panel2.add(dayMenu);
       // dayMenu.setVisible(true);
        panel1.add(panel2);
        //panel.add(bSubmit);
        panel2.add(bSubmit);
        //added an actionListener for the button to have actions.
        bSubmit.addActionListener(this);
       /* day.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            }
        });
       timeWindow.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent Me){
                if(Me.isPopupTrigger()){
                    dayMenu.show(Me.getComponent(), Me.getX(), Me.getY());
                }
            }
        });*/

        //added the panel to the frame.
        timeWindow.add(panel1);

        timeWindow.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {


        new AvailableTimeFormGUI();
    }

    /**
     *
     * @param e Method that will be performed once the bSubmit button is clicked.
     *      The values placed inside each of the JtextFields will be captured
     *      and place into the setStartTime, setEndTime, setDay objects of the AvailableTime class.
     */
    public void actionPerformed(ActionEvent e) {
        AvailableTime s = new AvailableTime();
            if(e.getSource() == bSubmit) {
               //try,catch block that catches error when user leaves a JtextField blank
                try {
                    int start = Integer.parseInt(startTextField.getText());
                    if(start > 7 && start < 21) {
                        s.setStartTime(start);
                    }
                   else {
                        JOptionPane.showMessageDialog(timeWindow, "You input the wrong value for your start time, try again.");
                    }
                    int end = Integer.parseInt(endTextField.getText());
                   if(end < 21) {
                       s.setEndTime(end);
                   }
                   else {
                       JOptionPane.showMessageDialog(timeWindow, "You input the wrong value for your end time, try again.");

                   }
                   int day = Integer.parseInt(dayTextField.getText());
                   if(day < 6 && day > 0) {
                       s.setDay(day);
                   }
                   else {
                       JOptionPane.showMessageDialog(timeWindow, "You input the wrong value for your day, try again.");
                   }

                JOptionPane.showMessageDialog(timeWindow, "Your available time has been updated only for fields input correctly.");
                }

                catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(timeWindow, "Do not input any letters or symbols and do not leave any fields blank. No fields were updated. Try again.");
                System.out.print("Exception caught here");
            }
        }
    }

}
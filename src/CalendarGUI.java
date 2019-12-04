import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
public class CalendarGUI {
    public JPanel calendarPanel;
    public JLabel[][] calendar;
    public JLabel[] headers;

    /**
     * The CalendarGUI is a simple multi-pane JFrame that displays a graphic depicting a user's listed AvailableTime
     * objects from the XML database. The parameter for this class is an ArrayList of AvailableTime objects from the
     * current user, and these objects are iterated through and siphoned for data. The GUI is nothing more than a
     * 2D matrix of JLabels that update with each added AvailableTime.
     * @param times
     */
    CalendarGUI(List<AvailableTime> times) {
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(14, 6));
        calendarPanel.setVisible(true);

        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);

        headers = new JLabel[6];
        headers[0] = new JLabel("Time", SwingConstants.CENTER);
        headers[1] = new JLabel("Monday", SwingConstants.CENTER);
        headers[2] = new JLabel("Tuesday", SwingConstants.CENTER);
        headers[3] = new JLabel("Wednesday", SwingConstants.CENTER);
        headers[4] = new JLabel("Thursday", SwingConstants.CENTER);
        headers[5] = new JLabel("Friday", SwingConstants.CENTER);

        for (int i = 0; i < headers.length; i++){
            headers[i].setBorder(border);
            headers[i].setOpaque(true);
            headers[i].setBackground(Color.LIGHT_GRAY);
            calendarPanel.add(headers[i]);
        }
        calendar = new JLabel[13][6];
        for (int i = 0; i < 13; i++){
            for (int j = 0; j < 6; j++){
                calendar[i][j] = new JLabel("");
                calendar[i][j].setBorder(border);
                calendarPanel.add(calendar[i][j]);
            }
        }
        for (int i = 0; i < 4; i++){
            calendar[i][0].setText((i + 8) + " AM");
            calendar[i][0].setHorizontalAlignment(JLabel.CENTER);
            calendar[i][0].setVerticalAlignment(JLabel.CENTER);
        }
        calendar[4][0].setText("12 PM");
        calendar[4][0].setHorizontalAlignment(JLabel.CENTER);
        calendar[4][0].setVerticalAlignment(JLabel.CENTER);

        for(int i = 5; i < 13; i++){
            calendar[i][0].setText((i - 4) + " PM");
            calendar[i][0].setHorizontalAlignment(JLabel.CENTER);
            calendar[i][0].setVerticalAlignment(JLabel.CENTER);
        }

        /**
         * This chunk of code iterates through the given ArrayList of AvailableTime objects and then colors in a
         * JLabel that corresponds with the AvailableTime data.
         */
        for (AvailableTime a : times){
            if (a.getDay() == 1){
                for (int i = (a.getStartTime() - 8); i <= (a.getEndTime() - 8); i++){
                    calendar[i][1].setOpaque(true);
                    calendar[i][1].setBackground(Color.GREEN);
                }
            } else if (a.getDay() == 2){
                for (int i = (a.getStartTime() - 8); i <= (a.getEndTime() - 8); i++){
                    calendar[i][2].setOpaque(true);
                    calendar[i][2].setBackground(Color.GREEN);
                }
            } else if (a.getDay() == 3) {
                for (int i = (a.getStartTime() - 8); i <= (a.getEndTime() - 8); i++) {
                    calendar[i][3].setOpaque(true);
                    calendar[i][3].setBackground(Color.GREEN);
                }
            } else if (a.getDay() == 4) {
                for (int i = (a.getStartTime() - 8); i <= (a.getEndTime() - 8); i++) {
                    calendar[i][4].setOpaque(true);
                    calendar[i][4].setBackground(Color.GREEN);
                }
            } else if (a.getDay() == 5){
                for (int i = (a.getStartTime() - 8); i <= (a.getEndTime() - 8); i++){
                    calendar[i][5].setOpaque(true);
                    calendar[i][5].setBackground(Color.GREEN);
                }
            }
        }
    }
}

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class CalendarGUI {
    public JPanel calendarPanel;
    public JLabel[][] calendar;
    public JLabel[] headers;
    CalendarGUI() {
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(14, 6));
        calendarPanel.setVisible(true);

        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);

        headers = new JLabel[6];
        headers[0] = new JLabel("Time", SwingConstants.CENTER);
        headers[1] = new JLabel("Monday", SwingConstants.CENTER);
        headers[2] = new JLabel("Tuesday", SwingConstants.CENTER);
        headers[3] = new JLabel("Wednesday", SwingConstants.CENTER);
        headers[4] = new JLabel("Thursday", SwingConstants.CENTER);
        headers[5] = new JLabel("Friday", SwingConstants.CENTER);

        for (int i = 0; i < headers.length; i++){
            headers[i].setBorder(border);
            calendarPanel.add(headers[i]);
        }
        calendar = new JLabel[13][5];
        for (int i = 0; i < 13; i++){
            for (int j = 0; j < 6; j++){
                calendar[i][j] = new JLabel("");
                calendarPanel.add(calendar[i][j]);
            }
        }
    }
}

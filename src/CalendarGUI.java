import javax.swing.*;
import javax.swing.plaf.basic.*;

public class CalendarGUI {
    public JInternalFrame calendarIFrame;
    public BasicInternalFrameUI calendarBIFrame;

    CalendarGUI(){
        calendarIFrame = new JInternalFrame();
        JPanel calendarPanel = new JPanel();
        calendarPanel.setLayout(new BoxLayout(calendarPanel, BoxLayout.Y_AXIS));
        calendarPanel.setVisible(true);
        calendarIFrame.add(calendarPanel);
        calendarBIFrame = (BasicInternalFrameUI) calendarIFrame.getUI();
        calendarBIFrame.setNorthPane(null);
        calendarIFrame.setVisible(true);
    }
}

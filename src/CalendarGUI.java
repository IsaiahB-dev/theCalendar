import javax.swing.*;
import javax.swing.plaf.basic.*;

public class CalendarGUI {
    JInternalFrame iFrame = new JInternalFrame();
    CalendarGUI(){
        BasicInternalFrameUI basicInternal = (BasicInternalFrameUI)iFrame.getUI();
        basicInternal.setNorthPane(null);
    }
}

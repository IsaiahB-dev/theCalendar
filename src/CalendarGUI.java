import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class CalendarGUI {
    public JInternalFrame calendarIFrame;
    public BasicInternalFrameUI calendarBIFrame;
    public JTable calendar;
    public JPanel calendarPanel;
    CalendarGUI(){
        calendarIFrame = new JInternalFrame();
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BoxLayout(calendarPanel, BoxLayout.Y_AXIS));
        calendarPanel.setVisible(true);

        calendar = new JTable(15, 6);
        calendar.setBounds( 100,200,100,100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        calendarPanel.add(calendar);

        calendarIFrame.add(calendarPanel);
        calendarBIFrame = (BasicInternalFrameUI) calendarIFrame.getUI();
        calendarBIFrame.setNorthPane(null);
        calendarIFrame.setVisible(true);
    }
}

class CalendarTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}

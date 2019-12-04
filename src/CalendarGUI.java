import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarGUI {
    public JTable calendar;
    public JPanel calendarPanel;
    public JScrollPane scrollPane;
    public CalendarTableModel model;
    CalendarGUI(List<CalendarTime> CalTimes){
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());
        calendarPanel.setVisible(true);
        model = new CalendarTableModel(CalTimes);
        calendar = new JTable(model);
        calendar.setDefaultRenderer(CalendarTime.Times.class, new CalendarRenderer());
        calendar.setRowHeight(35);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(calendar);
        calendarPanel.add(scrollPane, BorderLayout.CENTER);
    }
}

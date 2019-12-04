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
    public List<CalendarTime> CalTimes;
    public CalendarTableModel model;
    CalendarGUI(){
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());
        calendarPanel.setVisible(true);

        CalendarTime r1 = new CalendarTime(8, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r2 = new CalendarTime(9, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r3 = new CalendarTime(10, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r4 = new CalendarTime(11, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r5 = new CalendarTime(12, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r6 = new CalendarTime(1, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r7 = new CalendarTime(2, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r8 = new CalendarTime(3, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r9 = new CalendarTime(4, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r10 = new CalendarTime(5, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r11 = new CalendarTime(6, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r12 = new CalendarTime(7, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());
        CalendarTime r13 = new CalendarTime(8, CalendarTime.getMonday(), CalendarTime.getTuesday(), CalendarTime.getWednesday(), CalendarTime.getThursday(), CalendarTime.getFriday());

        CalTimes = new ArrayList<>();
        CalTimes.add(r1);
        CalTimes.add(r2);
        CalTimes.add(r3);
        CalTimes.add(r4);
        CalTimes.add(r5);
        CalTimes.add(r6);
        CalTimes.add(r7);
        CalTimes.add(r8);
        CalTimes.add(r9);
        CalTimes.add(r10);
        CalTimes.add(r11);
        CalTimes.add(r12);
        CalTimes.add(r13);

        model = new CalendarTableModel(CalTimes);
        calendar = new JTable(model);
        calendar.setDefaultRenderer(CalendarTime.Times.class, new CalendarRenderer());
        calendar.setRowHeight(35);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(calendar);
        calendarPanel.add(scrollPane, BorderLayout.CENTER);
    }
}

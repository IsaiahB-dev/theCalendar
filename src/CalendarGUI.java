import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarGUI {
    public JTable calendar;
    public JPanel calendarPanel;
    public JScrollPane scrollPane;
    CalendarGUI(){
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());
        calendarPanel.setVisible(true);

        CalendarTime r1 = new CalendarTime(8, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r2 = new CalendarTime(9, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r3 = new CalendarTime(10, CalendarTime.Times.Y, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r4 = new CalendarTime(11, CalendarTime.Times.Y, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r5 = new CalendarTime(12, CalendarTime.Times.Y, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r6 = new CalendarTime(1, CalendarTime.Times.N, CalendarTime.Times.B, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r7 = new CalendarTime(2, CalendarTime.Times.N, CalendarTime.Times.B, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r8 = new CalendarTime(3, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r9 = new CalendarTime(4, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r10 = new CalendarTime(5, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r11 = new CalendarTime(6, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r12 = new CalendarTime(7, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);
        CalendarTime r13 = new CalendarTime(8, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N, CalendarTime.Times.N);

        List<CalendarTime> CalTimes = new ArrayList<>();
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

        CalendarTableModel model = new CalendarTableModel(CalTimes);
        calendar = new JTable(model);
        calendar.setDefaultRenderer(CalendarTime.Times.class, new CalendarRenderer());
        calendar.setRowHeight(35);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(calendar);
        calendarPanel.add(scrollPane, BorderLayout.CENTER);
    }
}

class CalendarTime{
    public enum Times {
        Y, N, B
    }
    protected int clockTime;
    protected Times monday;
    protected Times tuesday;
    protected Times wednesday;
    protected Times thursday;
    protected Times friday;

    public CalendarTime(int cl, Times t1, Times t2, Times t3, Times t4, Times t5){
        this.clockTime = cl;
        this.monday = t1;
        this.tuesday = t2;
        this.wednesday = t3;
        this.thursday = t4;
        this.friday = t5;
    }

    public int getClockTime(){
        return clockTime;
    }

    public void setClockTime(int clockTime){
        this.clockTime = clockTime;
    }

    public Times getMonday(){
        return monday;
    }

    public void setMonday(Times monday){
        this.monday = monday;
    }

    public Times getTuesday(){
        return tuesday;
    }

    public void setTuesday(Times tuesday){
        this.tuesday = tuesday;
    }

    public Times getWednesday(){
        return wednesday;
    }

    public void setWednesday(Times wednesday){
        this.wednesday = wednesday;
    }

    public Times getThursday(){
        return thursday;
    }

    public void setThursday(Times thursday){
        this.thursday = thursday;
    }

    public Times getFriday(){
        return friday;
    }

    public void setFriday(Times friday){
        this.friday = friday;
    }
}

class CalendarTableModel extends AbstractTableModel{
    final List<CalendarTime> timeList;

    final String[] columnNames = new String[]{
            "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
    };

    final Class[] columnClass = new Class[]{
            Integer.class, CalendarTime.Times.class, CalendarTime.Times.class, CalendarTime.Times.class, CalendarTime.Times.class, CalendarTime.Times.class
    };

    public CalendarTableModel(List<CalendarTime> timeList){
        this.timeList = timeList;
    }

    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int index){
        return columnClass[index];
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public int getRowCount(){
        return timeList.size();
    }

    @Override
    public Object getValueAt(int r, int c){
        CalendarTime row = timeList.get(r);
        if (0 == c){
            return row.getClockTime();
        } else if (1 == c){
            return row.getMonday();
        } else if (2 == c){
            return row.getTuesday();
        } else if (3 == c){
            return row.getWednesday();
        } else if (4 == c){
            return row.getThursday();
        } else if (5 == c){
            return row.getFriday();
        }
        return null;
    }
}

class CalendarRenderer extends JLabel implements TableCellRenderer{
    public CalendarRenderer(){
        super.setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        CalendarTime.Times times = (CalendarTime.Times) value;
        if(times == CalendarTime.Times.Y){
            super.setBackground(Color.GREEN);
        } else if (times == CalendarTime.Times.N){
            super.setBackground(Color.WHITE);
        } else if (times == CalendarTime.Times.B){
            super.setBackground(Color.BLUE);
        }
        return this;
    }
}

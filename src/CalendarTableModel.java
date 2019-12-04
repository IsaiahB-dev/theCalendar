import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CalendarTableModel extends AbstractTableModel {
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
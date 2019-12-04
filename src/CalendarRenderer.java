import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CalendarRenderer extends JLabel implements TableCellRenderer {
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
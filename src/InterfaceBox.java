import javax.swing.*;
import java.awt.event.*;

public class InterfaceBox{
    InterfaceBox() {
        JFrame f = new JFrame();

        JButton write = new JButton("Write");
        write.setMnemonic(KeyEvent.VK_W);
        write.setActionCommand("write");
        write.setBounds(130, 50, 100, 40);
        write.addActionListener(e -> {
            try {
                DataObject.jsonFileWriter(file());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton read = new JButton("Read");
        read.setMnemonic(KeyEvent.VK_R);
        read.setActionCommand("read");
        read.setBounds(130, 100, 100, 40);

        JLabel output = new JLabel();
        output.setBounds(50, 210, 200, 100);

        read.addActionListener(e -> {
            try {
                output.setText(DataObject.jsonFileReader(file()).toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        f.add(read);
        f.add(write);
        f.add(output);

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static String file (){
        String s = "sample.json";
        return s;
    }
}

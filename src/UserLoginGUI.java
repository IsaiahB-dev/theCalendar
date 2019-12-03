// Libraries needed to make the file
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLoginGUI extends JFrame implements ActionListener{
    
    JPanel panel;
    JLabel userLabel, passwordLabel, message;
    JTextField usernameText, passwordText;
    JButton login;

    
    UserLoginGUI() {

        // This is the label for the username and text field for the user input
        userLabel = new JLabel();
        userLabel.setText("User Name :");
        usernameText = new JTextField();
        
        // Label for the password and the textfield for the user input

        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JTextField();

    
        // Button for the login action
        login = new JButton("login");

        // Creating the panel and setting a border around it
        panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
    
        // Can add more colums and rows and place boxes or buttons in specific spots such as
        // panel.add(userlabel, 0, 0)
        panel.add(userLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);

        message = new JLabel();
        panel.add(message);
        panel.add(login);
        
        // Adding the listener
        login.addActionListener(this);

        // Settings for the frame
        add(panel, BorderLayout.CENTER);
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        User user = new User();

        if (ae.getSource() == login)
        {
            boolean result = user.login(usernameText.getText(), passwordText.getText());

            if (result == true) {
                new MainWindowGUI();
            }
            else {
                JOptionPane.showMessageDialog(panel, "Incorrect Credentials try again.\n Or create new user.");
            }
        }
    }

    public static void main(String[] args) {
        new UserLoginGUI();
    }
}

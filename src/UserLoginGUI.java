// Libraries needed to make the file
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLoginGUI extends JFrame implements ActionListener{
    /**
     * This is a serial id thing i dont really know what it does it just was giving me an error
     */
    private static final long serialVersionUID = 1L;
    JPanel panel;
    JLabel userLabel, passwordLabel, message;
    JTextField usernameText;
    JPasswordField passwordText;
    JButton login;

    
    UserLoginGUI() {

        // This is the label for the username and text field for the user input
        userLabel = new JLabel();
        userLabel.setText("User Name :");
        usernameText = new JTextField();
        
        // Label for the password and the textfield for the user input

        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JPasswordField();

    
        // Button for the login action
        login = new JButton("login");

        // Creating the panel
        panel = new JPanel(new GridLayout(0,1, 10, 10));
    
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
        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
 
    }

    public static void main(String[] args) {
        new UserLoginGUI();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Logged in");
    }
}

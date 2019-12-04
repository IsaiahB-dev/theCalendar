// Libraries needed to make the file
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User login GUI class.
 * Generates a window for the user to log into the software.
 */
public class UserLoginGUI extends JFrame implements ActionListener{
    
    JPanel panel;
    JLabel userLabel, passwordLabel;
    JTextField usernameText;
    JPasswordField passwordText;
    JButton login, newUser;
    User user;

    /**
     * Constructor to call the user login GUI 
     * @param user: the current user logged into the software
     */
    UserLoginGUI(User user) {
        this.user = user;

        // This is the label for the username and text field for the user input
        userLabel = new JLabel();
        userLabel.setText("User Name :");
        usernameText = new JTextField();
        
        // Label for the password and the textfield for the user input

        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JPasswordField();

    
        // Button for the login action
        login = new JButton("Login");
        newUser = new JButton("New User");

        // Creating the panel and setting a border around it
        panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
    
        // Can add more colums and rows and place boxes or buttons in specific spots such as
        // panel.add(userlabel, 0, 0)
        panel.add(userLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);

        panel.add(newUser);
        panel.add(login);
        
        // Adding the listener
        login.addActionListener(this);
        newUser.addActionListener(this);

        // Settings for the frame
        add(panel, BorderLayout.CENTER);
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        User tmpUser = new User();

        if (ae.getSource() == login)
        {
            // Validates user
            boolean result = tmpUser.login(usernameText.getText(), passwordText.getText());

            if (result == true) {
                setVisible(false);
                dispose();
                user = tmpUser;

                // Passes the validated user to the main window 
                new MainWindowGUI(user);
            }
            else {
                JOptionPane.showMessageDialog(panel, "Incorrect Credentials try again.\n Or create new user.");
            }
        }
        else if (ae.getSource() == newUser)
        {
            setVisible(false);
            dispose();
            // If a new user is chosen then the new user creation form is called
            new UserCreationGUI();
        }
    }
}

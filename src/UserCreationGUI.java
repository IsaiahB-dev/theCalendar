// Libraries needed to make the file
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class UserCreationGUI extends JFrame implements ActionListener{
    
    JPanel panel;
    JLabel userLabel, passwordLabel, passwordComfirmLabel;
    JTextField usernameText;
    JPasswordField passwordText, cPasswordText;
    JButton createUser, cancel;
    User cUser;

    UserCreationGUI() {
        // This is the label for the username and text field for the user input
        userLabel = new JLabel();
        userLabel.setText("User Name :");
        usernameText = new JTextField();
        
        // Label for the password and the textfield for the user input

        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JPasswordField();

        passwordComfirmLabel = new JLabel();
        passwordComfirmLabel.setText("Confirm Password :");
        cPasswordText = new JPasswordField();
    
        // Button for the createUser action
        createUser = new JButton("Create User");
        cancel = new JButton("Cancel");

        // Creating the panel and setting a border all around it 
        panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
    
        // Can add more colums and rows and place boxes or buttons in specific spots such as
        // panel.add(userlabel, 0, 0)
        panel.add(userLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(passwordComfirmLabel);
        panel.add(cPasswordText);

        // Adding the buttons
        panel.add(cancel);
        panel.add(createUser);
        
        // Adding the listener
        createUser.addActionListener(this);
        cancel.addActionListener(this);
        // Settings for the frame
        add(panel, BorderLayout.CENTER);
        setTitle("Create User");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // This is where we will add the calls to store the user in the database and log him in i believe
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            setVisible(false); // Can no longer see jframe
            dispose(); // Destroy jframe object
            // If cancelled then an empty user is passed back into the login form
            new UserLoginGUI(cUser);

        }
        else if(ae.getSource() == createUser) {
            if (passwordText.getText().equals(cPasswordText.getText())) {
                // Creates stream to save new user to database
                DatabaseComm stream = new DatabaseComm();
                // Creates a list to add the new user to
                List<User> users = stream.getUsers();

                // New user to save data to 
                User user = new User();
                user.createUser(usernameText.getText(), passwordText.getText());
                this.cUser = user;

                setVisible(false);
                dispose();
                // Adds the user to the list 
                users.add(cUser);
                // Calls function to save to file
                stream.saveUsers(users);
                // Calls new main window with the new user 
                new MainWindowGUI(cUser);
            }
            else {
                JOptionPane.showMessageDialog(panel, "Passwords do not match");
            }

        }

    }
}

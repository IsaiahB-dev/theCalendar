// Libraries needed to make the file
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserCreationGUI extends JFrame implements ActionListener{
    /**
     * Again idk about this just added it to remove error
     */
    private static final long serialVersionUID = 1L;
    JPanel panel;
    JLabel userLabel, passwordLabel, passwordComfirmLabel;
    JTextField usernameText;
    JPasswordField passwordText, cPasswordText;
    JButton createUser, cancel;

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
        passwordComfirmLabel.setText("Comfirm Password :");
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
        // Settings for the frame
        add(panel, BorderLayout.CENTER);
        setTitle("Create User");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserCreationGUI();
    }

    // This is where we will add the calls to store the user in the database and log him in i believe
    // Cannot get cancel to work as of right now might need to change to individual initializations for action listeners
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == createUser) {
            System.out.println("User Created");
        }
        else if (ae.getSource() == cancel) {
            System.out.println("Cancelled");
        }

    }
}

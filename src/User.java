import java.util.ArrayList;
import java.util.List;

public class User {
        private String userName;
        private String password;
        private int id;

        /**
         * Constructor for a user class being created from saved data
         * @param name: User name for this class
         * @param pass: Password for current user
         * @param identifier: The id for the user to be creaded
         */
        public User(String name, String pass, int identifier)
        {
            this.userName = name;
            this.password = pass;
            this.id = identifier;
        }

        /**
         * Constructor for a user class that is being created through the user creation gui and the identifier will be calculated
         * @param name: User name for the created user
         * @param pass: User password for the created user
         */
        public User(String name, String pass)
        {
            this.userName = name;
            this.password = pass;
            
            DatabaseComm data = new DatabaseComm();
            List<User> people = data.getUsers();
            this.id = people.size() + 1;
        }

        /**
         * Default constructor with nothing intitialized
         */
        public User() {}

        /**
         * Gets the username
         * @return: User name
         */
        public String getUsername()
        {
            return userName;
        }

        /**
         * Gets the users password
         * @return: Password
         */
        public String getPassword()
        {
            return password;
        }

        /**
         * Sets the users id to a specified one
         * @param id: The identifier for this user 
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * Returns the users id
         */
        public int getId() {
            return id;
        }

        /**
         * Funcion to create a user it will just set the variable fields and then let the user in
         * the database will be updated at the end
         * @param name: This is the username that the user chooses
         * @param pass: This is the users chosen password
         */
        public void createUser(String name, String pass)
        {
            userName = name;
            password = pass;

            // This sets the user id for a new user to be one more than the last identifier in the file
            DatabaseComm data = new DatabaseComm();
            List<User> people = data.getUsers();
            this.id = people.size() + 1;

            people.add(this);
        }

        /**
         * Function to pass the arguments of a requested login to a private function 
         * @param name: The name of the user to be logged in 
         * @param pass: The password of user to be logged in
         * @return: 0 if the login has failed, 1 if the login is succesful
         */
        public boolean login(String name, String pass)
        {
            return validate(name, pass);
        }

        /**
         * Function to validate user against list of saved users
         * @param name: Username to be checked
         * @param pass: Password to be verified
         * @return: 0 if the login failed, 1 if the login is succesful
         */
        private boolean validate(String name, String pass)
        {
            // Gets a list of users
            DatabaseComm data = new DatabaseComm();
            List<User> people = new ArrayList<>();
            people = data.getUsers();

            // Iterates through it and compares names to see if the name is in the list
            for(int i = 0; i < people.size(); i++)
            {
                User currentP = people.get(i);

                if (currentP.getUsername().equals(name))
                {
                    return true;
                }
            }
            return false;
        }
}

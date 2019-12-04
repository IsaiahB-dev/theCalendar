import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

// If you addd attribute the long way you need this import
// import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DatabaseComm {
    // Enum to get a number for the specified day

    private List<User> users= new ArrayList<>();
    private List<UserCalendar> savedCalendars = new ArrayList<>();

    /**
     * This function parses through the file and creates and array list of user objects for validating or adding users
     * @return: This returns a list of the users in the current file
     */
    public List<User> getUsers() {
        try {
            // This opens a the user files
            File fXmlFile = new File("sampleUsers.xml");
            // User document builder to be able to parse the file.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        
            // Gets a list of all the nodes labelled user in the file 
            NodeList nList = doc.getElementsByTagName("User");
        
            // Iterates through all the user nodes in the file
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i); // Gets the current node out of the list

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // This creates a user from the elements in the user node
                    User person = new User(
                        eElement.getElementsByTagName("userName").item(0).getTextContent(), 
                        eElement.getElementsByTagName("password").item(0).getTextContent(), 
                        Integer.parseInt(eElement.getAttribute("id")));
                    

                    // This adds a person object to the list of people
                    users.add(person);
                }
            }
            return users;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Need to change this function to return a list of user calendars
    /**
     * This function is to return a list of the calendars in the xml file
     * @return An arrayList of userCalendars
     */
    public List<UserCalendar> getCalendars()
    {
        try {
            // This opens a the calendar file
            File fXmlFile1 = new File("sampleCalendar.xml");
            // User document builder to be able to parse the file.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile1);
            doc.getDocumentElement().normalize();

            // Gets a list of all the nodes labelled userCalendar
            NodeList calendarList = doc.getElementsByTagName("UserCalendar");
            for (int i = 0; i < calendarList.getLength(); i++) {
                Node calendarNode = calendarList.item(i); // Gets the current node out of the list

                if (calendarNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element calendarElement = (Element) calendarNode;

                    // Creates a temporary calendar object to add to the list
                    UserCalendar tmpCalendar = new UserCalendar();

                    // Sets the id for this calendar
                    tmpCalendar.setId(Integer.parseInt(calendarElement.getAttribute("id")));


                    // Gets a list of all the nodes labelled day
                    NodeList TimeList = calendarElement.getElementsByTagName("AvailableTime");
                    for(int j = 0; j < TimeList.getLength(); j++)
                    {
                        Node timeNode = TimeList.item(j);
                        
                        if(timeNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element timeElement = (Element) timeNode;
                            AvailableTime temp = new AvailableTime
                                            (
                                            Integer.parseInt(timeElement.getElementsByTagName("startTime").item(0).getTextContent()), 
                                            Integer.parseInt(timeElement.getElementsByTagName("endTime").item(0).getTextContent()), 
                                            Integer.parseInt(timeElement.getElementsByTagName("Day").item(0).getTextContent()) 
                                            );

                            tmpCalendar.addTime(temp);
                        }
                        
                    }
                    // Adds the user calendar to the list of user calendars to be returned
                    savedCalendars.add(tmpCalendar);
                }
            }
            return savedCalendars;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUsers(List<User> users) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
		    Document doc = docBuilder.newDocument();
		    Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);
            
            // Start loop here //
            for (int i = 0; i < users.size(); i++) {
                // User Elements
		        Element user = doc.createElement("User");
                rootElement.appendChild(user);
                
                // set attribute to User elements
                user.setAttribute("id", Integer.toString(users.get(i).getId()));
		        // Attr attr = doc.createAttribute("id");
		        // attr.setValue(Integer.toString(users.get(i).getId()));
                // user.setAttributeNode(attr);
                
                // firstname elements
		        Element userName = doc.createElement("userName");
		        userName.appendChild(doc.createTextNode(users.get(i).getUsername()));
                user.appendChild(userName);
                
                // firstname elements
		        Element password = doc.createElement("password");
		        password.appendChild(doc.createTextNode(users.get(i).getPassword()));
                user.appendChild(password);
            }

            // write the content into xml file
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		    DOMSource source = new DOMSource(doc);
		    StreamResult result = new StreamResult(new File("sampleUsers.xml"));
		    // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            
            transformer.transform(source, result);

            System.out.println("File saved!");
            
        } catch (ParserConfigurationException pce) {
            		pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }


    /**
     * Temp Main function to use for examples on how to read from the files
     * @param args
     */
    // public static void main(String[] args) {
    //     // Create the database object to stream data
    //     DatabaseComm stream = new DatabaseComm();
    // 
    //     // This is how you get users
    //     List<User> temp = stream.getUsers();    // Returns a list of users
    //     for (int i = 0; i < temp.size(); i++) {
    //         User tempUser = temp.get(i);                 //  Accessing the first user in that list
    // 
    //         // Here i am just printing out the users username but this is where you can branch off to get what you want
    //         System.out.println(tempUser.getUsername());
    //     }
    // 
    //     // Creating a new user to test the save function afterwards
    //     User tempUser = new User("Rich", "test3");
    //     temp.add(tempUser);
    // 
    //     stream.saveUsers(temp);
    // 
    // 
    // 
    // 
    //     // This is calling the get calendars function to get a list of UserCalendars
    //     List<UserCalendar> calendars = stream.getCalendars();
    // 
    //     // Iterating through the calendars
    //     for(int i = 0; i < calendars.size(); i++) {
    //         UserCalendar test = calendars.get(i);                   // This is just going through all the calendars
    //         List<AvailableTime> times = test.getAvailableTimes();   // This is pulling their list of available time
    // 
    //         // This is where you could branch off to do most of what you need
    //         // One example is compare ids to get the correct calendar from the proper user
    // 
    //         for (int j = 0; j < times.size(); j++) {
    //             AvailableTime timeTest = times.get(j);
    //             System.out.println(timeTest.getDay());
    //             
    //         }
    //     }
    // }
}
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.print.MultiDocPrintService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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

    public static void main(String[] args) {
        DatabaseComm stream = new DatabaseComm();


        List<User> temp = stream.getUsers();
        User cam = temp.get(0);
        System.out.println(cam.getUsername());



        List<UserCalendar> calendars = stream.getCalendars();

        for(int i = 0; i < calendars.size(); i++) {
            UserCalendar test = calendars.get(i);
            List<AvailableTime> times = test.getAvailableTimes();

            for (int j = 0; j < times.size(); j++) {
                AvailableTime timeTest = times.get(j);
                System.out.println(timeTest.getDay());
                
            }
        }
    }

}
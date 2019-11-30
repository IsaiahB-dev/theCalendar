import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DatabaseComm {
    // Enum to get a number for the specified day

    private List<User> users= new ArrayList<>();
    private ArrayList<Day> avTimes = new ArrayList<>();
    private Day times = new Day();

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
    public List<Day> getCalendars()
    {
        try {
            // This opens a the calendar file
            File fXmlFile = new File("sampleCalender.xml");
            // User document builder to be able to parse the file.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            // Gets a list of all the nodes labelled userCalendar
            NodeList calendarList = doc.getElementsByTagName("userCalendar");
            for (int i = 0; i < calendarList.getLength(); i++) {
                Node calendarNode = calendarList.item(i); // Gets the current node out of the list

                if (calendarNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element calendarElement = (Element) calendarNode;
                    NodeList DayList = calendarElement.getElementsByTagName("Day");

                    // This is for the days
                    for(int n = 0; n < DayList.getLength(); n++)
                    {
                        Node dayNode = DayList.item(n);

                        if(dayNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element dayElement = (Element) dayNode;
                            NodeList availableTimeList = dayElement.getElementsByTagName("AvailableTime");
                            
                            for(int j = 0; j < availableTimeList.getLength(); j++)
                            {
                                Node timeNode = availableTimeList.item(j);

                                if (timeNode.getNodeType() == Node.ELEMENT_NODE)
                                {
                                    Element timeElement = (Element) timeNode;

                                    AvailableTime temp = new AvailableTime(
                                        Integer.parseInt(timeElement.getElementsByTagName("startTime").item(0).getTextContent()), 
                                        Integer.parseInt(timeElement.getElementsByTagName("endTime").item(0).getTextContent()), 
                                        n, 
                                        timeElement.getElementsByTagName("meridies").item(0).getTextContent());

                                        times.addTime(temp);
                                }
                            }
                            avTimes.add(times);
                        }
                    }
                }
            }
            return avTimes;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class CalendarParser {
    CalendarParser(File googleCalendarFile) throws FileNotFoundException {
        File file = googleCalendarFile;
        Scanner scanner = new Scanner(file);
        AvailableTime availableTime;
        List<AvailableTime> timeList = new ArrayList<AvailableTime>();
        GregorianCalendar cal;

        while(scanner.hasNextLine()){
            if (scanner.next().startsWith("")){

            }
        }
    }
}

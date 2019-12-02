import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarParser {
    CalendarParser(File googleCalendarFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(googleCalendarFile);
        AvailableTime availableTime;
        List<AvailableTime> timeList = new ArrayList<AvailableTime>();
        GregorianCalendar cal;
        String[] parserStorage = new String[1000];
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while(scanner.hasNextLine()){
            if (scanner.next().startsWith("DTSTART:")){
                parserStorage[i] = scanner.next();
                i++;
            }
            if (scanner.next().startsWith("DTEND:")){
                parserStorage[i] = scanner.next();
            }
        }
    }
}

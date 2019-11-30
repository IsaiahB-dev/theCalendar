import java.util.ArrayList;
import java.util.List;

public class Day {
    private List<AvailableTime> dayFreeTime = new ArrayList<>(); 

    public void addTime(AvailableTime timeObject)
    {
        dayFreeTime.add(timeObject);
    }

    public List<AvailableTime> getSchedule()
    {
        return dayFreeTime;
    }
}
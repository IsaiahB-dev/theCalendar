import java.util.ArrayList;

public class aAvailableTime {
    public int startTime;
    public int endTime;
    public ArrayList<Integer> days;

    public aAvailableTime(int startTime, int endTime, ArrayList<Integer> days) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public ArrayList<Integer> getDays() {
        return days;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setDays(ArrayList<Integer> days) {
        this.days = days;
    }
}

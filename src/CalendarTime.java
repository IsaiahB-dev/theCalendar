public class CalendarTime{

    public enum Times {
        Y, N, B
    }
    protected int clockTime;
    protected static Times monday = Times.N;
    protected static Times tuesday = Times.N;
    protected static Times wednesday = Times.N;
    protected static Times thursday = Times.N;
    protected static Times friday = Times.N;

    public CalendarTime(int cl, Times t1, Times t2, Times t3, Times t4, Times t5){
        this.clockTime = cl;
        this.monday = t1;
        this.tuesday = t2;
        this.wednesday = t3;
        this.thursday = t4;
        this.friday = t5;
    }

    public int getClockTime(){
        return clockTime;
    }

    public void setClockTime(int clockTime){
        this.clockTime = clockTime;
    }

    public static Times getMonday(){
        return monday;
    }

    public void setMonday(Times monday){
        this.monday = monday;
    }

    public static Times getTuesday(){
        return tuesday;
    }

    public void setTuesday(Times tuesday){
        this.tuesday = tuesday;
    }

    public static Times getWednesday(){
        return wednesday;
    }

    public void setWednesday(Times wednesday){
        this.wednesday = wednesday;
    }

    public static Times getThursday(){
        return thursday;
    }

    public void setThursday(Times thursday){
        this.thursday = thursday;
    }

    public static Times getFriday(){
        return friday;
    }

    public void setFriday(Times friday){
        this.friday = friday;
    }
}
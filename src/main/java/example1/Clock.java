package example1;

public class Clock {
    private Integer hours;
    private Integer minutes;

    public Clock(int hours, int minutes) {
        this.setHours(hours);
        this.setMinutes(minutes);
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes % 60;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours % 24;
    }

    public int getHours() {
        return hours;
    }
}

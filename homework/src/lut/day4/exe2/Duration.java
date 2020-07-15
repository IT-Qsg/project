package lut.day4.exe2;

public class Duration {
    int hours,minutes,second;

    public Duration(int hours, int minutes, int second) {
        this.hours = hours;
        this.minutes = minutes;
        this.second = second;
    }

    public Duration(int second) {
        hours = 20;
        minutes = 30;
        this.second = second;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    public int getTotalSeconds(){
        return second;
    }
    public String toString() {
        return hours +":" + minutes +":" + second ;
    }
}

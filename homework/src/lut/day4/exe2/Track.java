package lut.day4.exe2;

public class Track {
    String title;
    Duration duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

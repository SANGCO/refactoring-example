package chapter08._06_duplicate_observed_data.example;

import java.util.Observable;

public class Interval extends Observable {
    private String start;
    private String end;
    private String length;

    public Interval(String start, String end, String length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
        setChanged();
        notifyObservers();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
        setChanged();
        notifyObservers();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
        setChanged();
        notifyObservers();
    }
}

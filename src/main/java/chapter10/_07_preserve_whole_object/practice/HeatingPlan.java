package chapter10._07_preserve_whole_object.practice;

public class HeatingPlan {
    private TempRange range;

    boolean withinRange(int low, int high, TempRange roomRange) {
        return (roomRange.getLow() >= range.getLow() && roomRange.getHigh() <= range.getHigh());
    }
}

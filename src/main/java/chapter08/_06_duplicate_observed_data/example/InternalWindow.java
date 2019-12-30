package chapter08._06_duplicate_observed_data.example;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Duplicate Observed Data (관측 데이터 복제)
 * <p>
 * 도메인 데이터는 GUI 컨트롤 안에서만 사용 가능한데, 도메인 메서드가 그 데이터에 접근해야 할 땐
 * - 그 데이터를 도메인 객체로 복사하고, 양측의 데이터를 동기화하는 관측 인터페이스 observer를 작성하자.
 */
public class InternalWindow extends Frame implements Observer {
    private TextField startField = new TextField();
    private TextField endField = new TextField();
    private TextField lengthField = new TextField();
    private Interval interval;

    public InternalWindow(Interval interval) throws HeadlessException {
        this.interval = interval;
        this.interval.addObserver(this);
        update(interval, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == interval) {
            this.startField.setText(interval.getStart());
            this.endField.setText(interval.getEnd());
            this.lengthField.setText(interval.getLength());
        }
    }

    private void LengthField_FocusLost(FocusEvent e) {
        if (isNotInteger(lengthField.getText())) {
            interval.setLength("0");
        }
        interval.calculateEnd();
    }

    private void EndField_FocusLost(FocusEvent e) {
        if (isNotInteger(endField.getText())) {
            interval.setEnd("0");
        }
        interval.calculateLength();
    }

    private void StartField_FocusLost(FocusEvent e) {
        if (isNotInteger(startField.getText())) {
            interval.setStart("0");
        }
        interval.calculateLength();
    }
    private boolean isNotInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    String getEnd() {
        return this.interval.getEnd();
    }

    void setEnd(String end) {
        this.interval.setEnd(end);
    }

    String getStart() {
        return this.interval.getStart();
    }

    void setStart(String start) {
        this.interval.setStart(start);
    }

    String getLength() {
        return this.interval.getLength();
    }

    void setLength(String length) {
        this.interval.setLength(length);
    }

    class SymFocus extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent e) {
            Object eventSource = e.getSource();
            if (eventSource == startField) {
                StartField_FocusLost(e);
            } else if (eventSource == endField) {
                EndField_FocusLost(e);
            } else if (eventSource == lengthField) {
                LengthField_FocusLost(e);
            }
        }
    }

    @Override
    public String toString() {
        return "InternalWindow{" +
                "startField=" + startField +
                ", endField=" + endField +
                ", lengthField=" + lengthField +
                ", interval=" + interval +
                '}';
    }
}

package chapter08._06_duplicate_observed_data.example;

import org.junit.Test;

public class InternalWindowTest {

    @Test
    public void test() {
        Interval interval = new Interval("1", "2", "3");
        InternalWindow internalWindow1 = new InternalWindow(interval);
        InternalWindow internalWindow2 = new InternalWindow(interval);
        InternalWindow internalWindow3 = new InternalWindow(interval);

        internalWindow1.setLength("10");

        System.out.println("internalWindow1 : " + internalWindow1);
        System.out.println("internalWindow2 : " + internalWindow2);
        System.out.println("internalWindow3 : " + internalWindow3);
    }

}

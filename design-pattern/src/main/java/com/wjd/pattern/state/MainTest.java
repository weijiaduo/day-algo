package com.wjd.pattern.state;

/**
 * @since 2021/12/11
 */
public class MainTest {

    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("状态模式demo");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                try {
                    frame.setClock(hour);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

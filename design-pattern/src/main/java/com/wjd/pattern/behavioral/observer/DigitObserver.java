package com.wjd.pattern.behavioral.observer;

/**
 * @since 2022/1/11
 */
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.wjd.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/1/11
 */
public abstract class NumberGenerator {

    /** 观察者集合 */
    private List<Observer> observers = new ArrayList<>();

    /** 添加观察者 */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /** 移除观察者 */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /** 通知所有观察者 */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /* 被观察者状态改变的接口方法 */
    public abstract int getNumber();
    public abstract void execute();

}

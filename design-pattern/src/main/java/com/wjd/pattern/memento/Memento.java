package com.wjd.pattern.memento;

import java.util.ArrayList;

/**
 * @since 2022/1/23
 */
public class Memento {

    private int money;
    private ArrayList<String> fruits;

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    @SuppressWarnings("unchecked")
    ArrayList<String> getFruits() {
        return (ArrayList<String>) fruits.clone();
    }

}

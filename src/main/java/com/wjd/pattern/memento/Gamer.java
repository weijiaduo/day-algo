package com.wjd.pattern.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @since 2022/1/23
 */
public class Gamer {

    private static String[] fruitsName = {
            "苹果", "葡萄", "香蕉", "橘子"
    };

    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金钱增加了。");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金钱减半了。");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("获得了水果（" + f + "）。");
            fruits.add(f);
        } else {
            System.out.println("什么都没有发生。");
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento(money);
        for (String f : fruits) {
            if (f.startsWith("好吃的")) {
                memento.addFruit(f);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }
}

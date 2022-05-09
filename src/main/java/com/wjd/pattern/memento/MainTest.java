package com.wjd.pattern.memento;

/**
 * @since 2022/1/23
 */
public class MainTest {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("===== " + i + " =====");
            System.out.println("当前状态：" + gamer);

            gamer.bet();
            System.out.println("所持金钱为 " + gamer.getMoney() + " 元。");

            // 保存状态
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("所持金钱增加了，保存当前状态。");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("所持金钱减半了，保存当前状态。");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

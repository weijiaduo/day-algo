package com.wjd.concurrency.jmm;

/**
 * @since 2022/4/26
 */
public class PossibleReordering {

     static int x = 0, y = 0;
     static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            a = 1; // 1
            x = b; // 2
        });

        Thread other = new Thread(() -> {
            b = 1; // 3
            y = a; // 4
        });

        one.start();
        other.start();

        one.join();
        other.join();

        System.out.println("(" + x + "," + y + ")");
    }

}

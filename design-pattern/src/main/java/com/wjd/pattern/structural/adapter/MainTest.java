package com.wjd.pattern.structural.adapter;

/**
 * @since 2022/1/24
 */
public class MainTest {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }

}

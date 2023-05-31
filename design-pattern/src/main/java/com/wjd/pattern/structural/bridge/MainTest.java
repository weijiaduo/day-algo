package com.wjd.pattern.structural.bridge;

/**
 * @since 2022/1/17
 */
public class MainTest {

    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, world!"));
        Display d2 = new Display(new StringDisplayImpl("Hello, China!"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, universe!"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }

}

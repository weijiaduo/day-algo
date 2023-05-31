package com.wjd.pattern.structural.decorator;

/**
 * @since 2021/11/29
 */
public class MainTest {

    public static void main(String[] args) {
        Display comp = new StringDisplay("Hello, world!");
        Display d1 = new SideBorder(comp, '#');
        Display d2 = new FullBorder(comp);
        comp.show();
        d1.show();
        d2.show();

        Display ddd = new FullBorder(new SideBorder(new SideBorder(new FullBorder(new StringDisplay("Hello, decorator!")), '*'), '%'));
        ddd.show();
    }

}

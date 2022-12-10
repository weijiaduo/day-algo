package com.wjd.pattern.templatemethod;

/**
 * @since 2022/1/15
 */
public class MainTest {

    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world!");
        AbstractDisplay d3 = new StringDisplay("你好，世界！");
        d1.display();
        d2.display();
        d3.display();
    }

}

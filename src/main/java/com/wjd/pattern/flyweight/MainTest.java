package com.wjd.pattern.flyweight;

/**
 * @since 2022/1/10
 */
public class MainTest {

    public static void main(String[] args) {
        String string = "12032";
        BigString bigString = new BigString(string);
        bigString.print();
    }

}

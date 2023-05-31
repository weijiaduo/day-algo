package com.wjd.pattern.structural.flyweight;

/**
 * @since 2022/1/10
 */
public class BigString {

    private BigChar[] chars;

    public BigString(String string) {
        loadString(string);
    }

    private void loadString(String string) {
        chars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < string.length(); i++) {
            char charName = string.charAt(i);
            chars[i] = factory.getChar(charName);
        }
    }

    public void print() {
        for (BigChar ch : chars) {
            ch.print();
        }
    }

}

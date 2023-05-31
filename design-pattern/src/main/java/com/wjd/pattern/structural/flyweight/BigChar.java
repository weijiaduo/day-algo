package com.wjd.pattern.structural.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @since 2022/1/10
 */
public class BigChar {

    /* 字符名称 */
    private char charName;
    /* 字体字符串 */
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        loadCharData();
    }

    private void loadCharData() {
        String fileDir = "src/com/pattern/flyweight/numbers/";
        String fileName = fileDir + "big" + charName + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            fontData = buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}

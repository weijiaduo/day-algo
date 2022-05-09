package com.wjd.pattern.interpreter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @since 2021/12/18
 */
public class MainTest {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/pattern/interpreter/program.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

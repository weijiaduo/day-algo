package com.wjd.pattern.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @since 2021/12/1
 */
public class Database {

    private Database() {
    }

    public static Properties getProperties(String dbname) {
        String filename = "src/com/pattern/facade/" + dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found");
            e.printStackTrace();
        }
        return prop;
    }

}

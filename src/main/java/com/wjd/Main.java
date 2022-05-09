package com.wjd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        testFile();
    }

    /**
     * JVM: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation(){
        byte[] a1, a2, a3, a4;
        a1 = new byte[_1MB/4];
        a2 = new byte[3*_1MB];
        a3 = new byte[4*_1MB];
//        a4 = new byte[2*_1MB];
    }

    public synchronized void tt(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testFile() {
        String regex = "\"[^\"]*\\?integrated=true[^\"]*\"";
        Pattern p = Pattern.compile(regex);

        List<String> urls = new ArrayList<>();

        Path path = Paths.get("D:\\EPPR-51195.xml");
        try (FileReader reader = new FileReader(path.toFile());
             BufferedReader buf = new BufferedReader(reader)) {
            String lastLine = "";
            String line;
            while ((line = buf.readLine()) != null) {
                String l = lastLine + line;
                System.out.println(line.length() + ", " + Integer.MAX_VALUE);
                Matcher matcher = p.matcher(l);
                while (matcher.find()) {
                    String g = matcher.group();
                    urls.add(g);
                    if (!g.contains("#")) {
                        System.out.println(g);
                    }
                }
                lastLine = line;
            }
            System.out.println(urls.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.wjd.jvm;

import java.util.Date;

public class JVMRunner {

    public static void main(String[] args) {
        while (true) {
            System.out.println(new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

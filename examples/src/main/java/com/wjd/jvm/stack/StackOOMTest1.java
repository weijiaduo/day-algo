package com.wjd.jvm.stack;

public class StackOOMTest1 {

    public static void main(String[] args) {
        work();
    }

    private static void work() {
        System.out.println("work~~");
        work();
    }
}

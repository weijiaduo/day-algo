package com.wjd.jvm.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapOOMTest1 {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }

}

package com.wjd.concurrency.jmm;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2022/4/26
 */
public class SafeStates {

    private static Object object = new Object();

    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<>();
        states.put("1", "a");
        states.put("2", "b");
        states.put("3", "c");
    }
}

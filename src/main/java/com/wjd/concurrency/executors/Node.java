package com.wjd.concurrency.executors;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/5/10
 */
public class Node<T> {
    private T data;

    public T compute() {
        return null;
    }

    public List<Node<T>> getChildren() {
        return new ArrayList<>(0);
    }
}

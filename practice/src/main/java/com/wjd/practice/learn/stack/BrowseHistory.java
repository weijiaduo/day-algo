package com.wjd.practice.learn.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 浏览器历史记录
 *
 * @author weijiaduo
 * @since 2022/8/25
 */
public class BrowseHistory {

    private final Deque<String> backwardStack;
    private final Deque<String> forwardStack;

    public BrowseHistory() {
        backwardStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
    }

    /**
     * 当前地址
     *
     * @return 地址
     */
    public String current() {
        if (backwardStack.isEmpty()) {
            throw new IllegalStateException();
        }
        return backwardStack.peek();
    }

    /**
     * 跳到新链接地址
     *
     * @param url 地址
     */
    public void jump(String url) {
        forwardStack.clear();
        backwardStack.push(url);
    }

    /**
     * 前进
     *
     * @return 前进后的新地址
     */
    public String forward() {
        if (!canForward()) {
            throw new IllegalStateException();
        }
        backwardStack.push(forwardStack.pop());
        return backwardStack.peek();
    }

    /**
     * 后退
     *
     * @return 后退后的新地址
     */
    public String backward() {
        if (!canBackward()) {
            throw new IllegalStateException();
        }
        forwardStack.push(backwardStack.pop());
        return backwardStack.peek();
    }

    /**
     * 是否可以前进
     *
     * @return true/false
     */
    public boolean canForward() {
        return !forwardStack.isEmpty();
    }

    /**
     * 是否可以回退
     *
     * @return true/false
     */
    public boolean canBackward() {
        return backwardStack.size() > 1;
    }

}

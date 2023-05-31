package com.wjd.practice.other.stack;

import com.wjd.practice.learn.stack.BrowseHistory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrowseHistoryTest {

    @Test
    void current() {
        BrowseHistory history = new BrowseHistory();
        history.jump("baidu.com");
        assertEquals("baidu.com", history.current());
    }

    @Test
    void jump() {
        BrowseHistory history = new BrowseHistory();
        history.jump("baidu.com");
        assertEquals("baidu.com", history.current());
        history.jump("google.com");
        assertEquals("google.com", history.current());
    }

    @Test
    void forward() {
        BrowseHistory history = new BrowseHistory();
        history.jump("baidu.com");
        assertEquals("baidu.com", history.current());
        history.jump("google.com");
        assertEquals("google.com", history.current());
        assertEquals("baidu.com", history.backward());
        assertEquals("baidu.com", history.current());
        assertEquals("google.com", history.forward());
        assertEquals("google.com", history.current());
    }

    @Test
    void backward() {
        BrowseHistory history = new BrowseHistory();
        history.jump("baidu.com");
        assertEquals("baidu.com", history.current());
        history.jump("google.com");
        assertEquals("google.com", history.current());
        assertEquals("baidu.com", history.backward());
        assertEquals("baidu.com", history.current());
    }

    @Test
    void canForward() {
        BrowseHistory history = new BrowseHistory();
        history.jump("baidu.com");
        assertEquals("baidu.com", history.current());
        assertFalse(history.canForward());
        history.jump("google.com");
        history.backward();
        assertTrue(history.canForward());
    }

    @Test
    void canBackward() {
        BrowseHistory history = new BrowseHistory();
        history.jump("baidu.com");
        assertEquals("baidu.com", history.current());
        assertFalse(history.canBackward());
        history.jump("google.com");
        assertTrue(history.canBackward());
    }
}
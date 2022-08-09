package com.wjd.concurrency.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 *《并发编程实战》-第15章
 * 非阻塞栈
 * @since 2022/4/27
 */
public class ConcurrentStack<E> {

    private AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E item) {
        Node<E> newTop = new Node<>(item);
        Node<E> oldTop;
        do {
            oldTop = top.get();
            newTop.next = oldTop;
        } while (!top.compareAndSet(oldTop, newTop));
    }

    public E pop() {
        Node<E> oldTop;
        do {
            oldTop = top.get();
            if (oldTop == null) {
                return null;
            }
        } while (!top.compareAndSet(oldTop, oldTop.next));
        oldTop.next = null;
        return oldTop.item;
    }

    private static class Node<E> {
        public final E item;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

}

package com.wjd.concurrency.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 *《并发编程实战》-第15章
 * 非阻塞链表
 * @since 2022/4/30
 */
public class LinkQueue<E> {

    private final Node<E> dummy = new Node<>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    /**
     * 推入队列尾部
     * 分 2 步 CAS：
     * 1. 设置 tail.next 为 newNode
     * 2. 设置 tail 为 tail.next
     */
    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> next = curTail.next.get();
            if (curTail != tail.get()) {
                continue;
            }
            if (next != null) {
                // 中间态，可能成功或失败
                // 2. 设置 tail 为 tail.next
                tail.compareAndSet(curTail, next);
            } else {
                // 1. 设置 tail.next 为新增加的 item
                if (curTail.next.compareAndSet(null, newNode)) {
                    // 中间态，可能成功或失败
                    // 2. 设置 tail 为 tail.next
                    tail.compareAndSet(curTail, newNode);
                    return true;
                }
            }
        }
    }

    /**
     * 返回队列头部
     */
    public E take() {
        while (true) {
            // head 是一个哨兵节点，下一个节点才是数据
            Node<E> curHead = head.get();
            Node<E> firstNode = curHead.next.get();
            if (firstNode == null) {
                return null;
            }
            Node<E> secondNode = firstNode.next.get();
            if (curHead.next.compareAndSet(firstNode, secondNode)) {
                firstNode.next.set(null);
                return firstNode.item;
            }
        }
    }

    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

}

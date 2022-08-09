package com.wjd.structure.skiplist;

import java.util.*;

/**
 * 跳表（链表）
 *
 * @author weijiaduo
 * @since 2022/7/28
 */
public class LinkedSkipList<T extends Comparable<T>> implements SkipList<T> {

    static class Node {
        Object value;
        Node right;
        Node down;
        public Node(Object value, Node right, Node down) {
            this.value = value;
            this.right = right;
            this.down = down;
        }
    }

    /**
     * 默认最大层级
     */
    static final int DEFAULT_MAX_LEVEL = 32;
    /**
     * 随机因子
     */
    static final double FACTOR = 0.25;

    /**
     * 哨兵头节点
     */
    Node head;
    /**
     * 最大层级
     */
    int maxLevels;
    /**
     * 随机数
     */
    Random random = new Random();

    public LinkedSkipList() {
        this(DEFAULT_MAX_LEVEL);
    }

    public LinkedSkipList(int maxLevels) {
        this.maxLevels = maxLevels;
        this.head = new Node(-1, null, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean search(T value) {
        Node[] processors = findProcessors(value);
        Node target = processors[0].right;
        return target != null && value.equals(target.value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T value) {
        Node[] processors = findProcessors(value);
        int levels = processors.length;
        boolean insertUp = true;
        Node newNode = null;
        for (int i = 0; i < levels && insertUp; i++) {
            newNode = new Node(value, processors[i].right, newNode);
            processors[i].right = newNode;
            insertUp = random.nextDouble() < FACTOR;
        }

        // 更新层级
        if (insertUp) {
            levelUp();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean erase(T value) {
        Node[] processors = findProcessors(value);
        Node target = processors[0].right;
        if (target == null || !value.equals(target.value)) {
            return false;
        }

        // 删除指定节点
        for (Node processor : processors) {
            if (processor.right == null || !processor.right.value.equals(value)) {
                break;
            }
            processor.right = processor.right.right;
        }

        // 更新层级
        levelDown();

        return true;
    }

    /**
     *  提升层级
     */
    private void levelUp() {
        head = new Node(-1, null, head);
    }

    /**
     * 降低层级
     */
    private void levelDown() {
        while (head.down != null) {
            // 连续2层为空时，才降低层级，因为最上一层可以暂时为空
            if (head.right != null || head.down.right != null) {
                break;
            }
            Node p = head;
            head = head.down;
            p.down = null;
        }
    }

    /**
     * 查找指定值的前置路径
     *
     * @param value 指定值
     * @return 前置路径
     */
    @SuppressWarnings("unchecked")
    private Node[] findProcessors(T value) {
        Deque<Node> stack = new ArrayDeque<>();
        Node p = head;
        while (p != null) {
            while (p.right != null && value.compareTo((T) p.right.value) > 0) {
                p = p.right;
            }
            stack.push(p);
            p = p.down;
        }

        Node[] path = new Node[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            path[k++] = stack.pop();
        }
        return path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            List<Object> values = new ArrayList<>();
            Node q = p.right;
            while (q != null) {
                values.add(q.value);
                q =q.right;
            }
            sb.append(values).append('\n');
            p = p.down;
        }
        return sb.toString();
    }
}

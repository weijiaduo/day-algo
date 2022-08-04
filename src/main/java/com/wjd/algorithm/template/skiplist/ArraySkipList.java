package com.wjd.algorithm.template.skiplist;

import java.util.Arrays;
import java.util.Random;

/**
 * 跳表（数组实现）
 *
 * @author weijiaduo
 * @since 2022/7/27
 */
public class ArraySkipList<T extends Comparable<T>> implements SkipList<T> {

    static class Node {
        Object value;
        Node[] next;

        Node(Object value, int levels) {
            this.value = value;
            next = new Node[levels];
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
     * 当前层级
     */
    int levels = 0;
    /**
     * 最大层级
     */
    int maxLevels;
    /**
     * 随机数
     */
    Random random = new Random();

    public ArraySkipList() {
        this(DEFAULT_MAX_LEVEL);
    }

    public ArraySkipList(int maxLevels) {
        this.maxLevels = maxLevels;
        head = new Node(null, maxLevels);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean search(T value) {
        Node[] processors = findProcessors(value);
        Node target = processors[0].next[0];
        return target != null && value.equals(target.value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(T value) {
        Node[] processors = findProcessors(value);
        int lv = randomLevel();
        levels = Math.max(levels, lv);
        Node newNode = new Node(value, levels);
        for (int i = 0; i < lv; i++) {
            newNode.next[i] = processors[i].next[i];
            processors[i].next[i] = newNode;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean erase(T value) {
        Node[] processors = findProcessors(value);
        Node target = processors[0].next[0];
        if (target == null || !value.equals(target.value)) {
            return false;
        }

        // 删除指定节点
        for (int i = 0; i < levels; i++) {
            if (processors[i].next[i] != target) {
                break;
            }
            processors[i].next[i] = target.next[i];
        }

        // 更新层级，最顶层只有头节点时，降低层级
        for (; levels > 1; levels--) {
            if (head.next[levels - 1] != null) {
                break;
            }
        }

        return true;
    }

    /**
     * 查找指定值的前置路径
     *
     * @param value 指定值
     * @return 前置路径
     */
    @SuppressWarnings("unchecked")
    private Node[] findProcessors(T value) {
        Node[] path = new Node[maxLevels];
        Arrays.fill(path, head);
        Node cur = head;
        for (int i = levels - 1; i >= 0; i--) {
            while (cur.next[i] != null && value.compareTo((T) cur.next[i].value) > 0) {
                cur = cur.next[i];
            }
            path[i] = cur;
        }
        return path;
    }

    /**
     * 随机层级
     * <p>
     * 这个随机有点影响时间
     *
     * @return 随即层级
     */
    private int randomLevel() {
        int lv = 1;
        while (lv < maxLevels && random.nextDouble() < FACTOR) {
            lv++;
        }
        return lv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = levels - 1; i >= 0; i--) {
            sb.append("[");
            Node cur = head.next[i];
            while (cur != null) {
                sb.append(cur.value).append(",");
                cur = cur.next[i];
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]\n");
        }
        return sb.toString();
    }
}

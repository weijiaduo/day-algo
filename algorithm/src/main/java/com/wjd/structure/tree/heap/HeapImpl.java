package com.wjd.structure.tree.heap;

import java.util.Comparator;

/**
 * 堆实现
 *
 * @author weijiaduo
 * @since 2023/2/24
 */
public class HeapImpl implements Heap<Integer> {

    /**
     * 堆，从 1 开始
     */
    private final Integer[] elements;
    /**
     * 堆大小
     */
    private int size;
    /**
     * 值比较器
     */
    private final Comparator<Integer> cmp;

    public HeapImpl(int capacity) {
        elements = new Integer[capacity + 1];
        cmp = (a, b) -> b - a;
        size = 0;
    }

    public HeapImpl(Integer[] elements) {
        this(elements, (a, b) -> b - a);
    }

    public HeapImpl(Integer[] elements, Comparator<Integer> cmp) {
        this.cmp = cmp;
        size = elements.length;
        this.elements = new Integer[size + 1];
        System.arraycopy(elements, 0, this.elements, 1, size);
        build();
    }

    /**
     * 构建堆
     */
    private void build() {
        for (int i = size / 2; i > 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public Integer removeFirst() {
        if (size <= 0) {
            throw new IllegalStateException("Heap isEmpty!");
        }

        Integer val = elements[1];
        swap(1, size--);
        siftDown(1);
        return val;
    }

    @Override
    public void insert(Integer val) {
        if (size + 1 >= elements.length) {
            throw new IllegalStateException("Heap isFull!");
        }

        elements[++size] = val;
        siftUp(size);
    }

    /**
     * 从上往下调整
     *
     * @param index 指定开始索引
     */
    private void siftDown(int index) {
        int i = index;
        while (i < size) {
            int m = i;
            int l = left(i);
            if (l <= size && less(l, m)) {
                m = l;
            }
            int r = right(i);
            if (r <= size && less(r, m)) {
                m = r;
            }
            if (m == i) {
                break;
            }
            swap(i, m);
            i = m;
        }
    }

    /**
     * 从下往上调整
     *
     * @param index 指定开始索引
     */
    private void siftUp(int index) {
        int i = index;
        while (i > 0) {
            int p = parent(i);
            if (p > 0 && less(i, p)) {
                swap(i, p);
                i = p;
            } else {
                break;
            }
        }
    }

    /**
     * 父节点索引
     *
     * @param i 当前节点索引
     * @return 父节点索引
     */
    private int parent(int i) {
        return i / 2;
    }

    /**
     * 左子节点索引
     *
     * @param i 当前节点索引
     * @return 左子节点索引
     */
    private int left(int i) {
        return 2 * i;
    }

    /**
     * 右子节点索引
     *
     * @param i 当前节点索引
     * @return 右子节点索引
     */
    private int right(int i) {
        return 2 * i + 1;
    }

    /**
     * elements[i] 是否小于 elements[j]
     *
     * @param i 索引 i
     * @param j 索引 j
     * @return true/false
     */
    private boolean less(int i, int j) {
        return cmp.compare(elements[i], elements[j]) < 0;
    }

    /**
     * 交换2个元素的位置
     *
     * @param i 索引 i
     * @param j 索引 j
     */
    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int t = elements[i];
        elements[i] = elements[j];
        elements[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

}

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
    private Integer[] elements;
    /**
     * 堆大小
     */
    private int size;
    /**
     * 值比较器
     */
    private final Comparator<Integer> cmp;

    public HeapImpl(Integer[] elements) {
        this((a, b) -> b - a, elements);
    }

    public HeapImpl(Comparator<Integer> cmp, Integer[] elements) {
        this.cmp = cmp;
        build(elements);
    }

    /**
     * 构建堆
     *
     * @param values 初始化值
     */
    private void build(Integer[] values) {
        size = values.length;
        elements = new Integer[size + 1];
        System.arraycopy(values, 0, elements, 1, size);
        for (int i = size / 2; i > 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public Integer removeFirst() {
        if (size <= 0) {
            throw new IllegalStateException("size: " + size);
        }

        Integer val = elements[1];
        swap(1, size--);
        siftDown(1);
        return val;
    }

    @Override
    public void insert(Integer val) {
        ensureCapacity(size + 1);
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
            if (l <= size && cmp.compare(elements[l], elements[m]) < 0) {
                m = l;
            }
            int r = right(i);
            if (r <= size && cmp.compare(elements[r], elements[m]) < 0) {
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
            if (p > 0 && cmp.compare(elements[i], elements[p]) < 0) {
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

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int t = elements[i];
        elements[i] = elements[j];
        elements[j] = t;
    }

    /**
     * 确保空间足够
     *
     * @param capacity 所需大小
     */
    private void ensureCapacity(int capacity) {
        if (capacity + 1 >= elements.length) {
            resize();
        }
    }

    /**
     * 空间扩容
     */
    private void resize() {
        int capacity = elements.length;
        int newCapacity = capacity << 1;
        Integer[] newElements = new Integer[newCapacity];
        System.arraycopy(elements, 1, newElements, 1, capacity - 1);
        elements = newElements;
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

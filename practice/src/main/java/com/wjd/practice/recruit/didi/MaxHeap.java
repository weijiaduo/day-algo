package com.wjd.practice.recruit.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 大顶堆
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class MaxHeap {

    int[] elems;

    int size;

    public MaxHeap(int capacity) {
        elems = new int[capacity];
        size = 0;
    }

    public void build(int[] values) {
        int n = values.length;
        elems = Arrays.copyOf(values, n);
        size = n;
        for (int i = size / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    public int top() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return elems[0];
    }

    public void push(int x) {
        if (size == elems.length) {
            throw new IndexOutOfBoundsException();
        }
        elems[size] = x;
        siftUp(size++);
    }

    public int poll() {
        int ret = top();
        swap(0, --size);
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        int n = size;
        while (i < n) {
            int m = i;
            int l = left(i), r = right(i);
            // 看左右子节点哪个大
            if (l < size && elems[l] > elems[m]) {
                m = l;
            }
            if (r < size && elems[r] > elems[m]) {
                m = r;
            }
            // 结束下沉
            if (i == m) {
                break;
            }
            // 交换父子节点
            swap(i, m);
            i = m;
        }
    }

    private void siftUp(int i) {
        while (i > 0) {
            int m = i;
            int p = parent(i);
            if (p >= 0 && elems[p] < elems[i]) {
                m = p;
            }
            // 结束上浮
            if (i == m) {
                break;
            }
            swap(i, p);
            i = p;
        }
    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int temp = elems[i];
        elems[i] = elems[j];
        elems[j] = temp;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public static void main(String[] args) {
        int[] values = new int[]{2, 3, 1, 4, 5};
        MaxHeap heap = new MaxHeap(10);
        for (int value : values) {
            heap.push(value);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            ans.add(heap.poll());
        }
        System.out.println(ans);
    }

}

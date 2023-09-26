package com.wjd.practice.learn.tree.heap;

import com.wjd.structure.heap.binary.Heap;
import com.wjd.structure.heap.binary.HeapImpl;
import com.wjd.util.ByteUtil;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 从一个输入流中统计 TopN 的元素
 *
 * @author weijiaduo
 * @since 2023/2/25
 */
public class TopN {

    private final int n;

    public TopN(int n) {
        this.n = n;
    }

    public List<Integer> solve(InputStream in) throws IOException {
        // 创建一个最小值堆
        Heap<Integer> minHeap = new HeapImpl<Integer>(n + 1, Comparator.comparingInt(a -> a));
        DataInputStream din = new DataInputStream(in);
        int num;
        while ((num = din.readInt()) != -1) {
            minHeap.insert(num);
            // 堆中只保留 n 个元素
            if (minHeap.size() > n) {
                // 删除最小的元素值
                minHeap.removeFirst();
            }
        }

        // 收集 TopN 的元素
        List<Integer> topN = new ArrayList<>(n);
        while (minHeap.size() > 0) {
            topN.add(minHeap.removeFirst());
        }
        Collections.reverse(topN);
        return topN;
    }

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int[] numbers = new int[51];
        for (int i = 0; i < 50; i++) {
            numbers[i] = random.nextInt(100);
        }
        numbers[50] = -1;
        System.out.println(Arrays.toString(numbers));
        byte[] bytes = ByteUtil.toBytes(numbers);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        List<Integer> topN = new TopN(10).solve(in);
        System.out.println(topN);
    }

}

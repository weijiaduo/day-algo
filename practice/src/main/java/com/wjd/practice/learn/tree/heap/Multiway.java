package com.wjd.practice.learn.tree.heap;

import com.wjd.structure.tree.heap.IndexHeap;
import com.wjd.structure.tree.heap.IndexHeapImpl;
import com.wjd.util.ByteUtil;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 合并多路有序数据
 *
 * @author weijiaduo
 * @since 2023/2/25
 */
public class Multiway {

    public void merge(InputStream[] ins, OutputStream out) throws IOException {
        int n = ins.length;
        DataInputStream[] dins = new DataInputStream[n];
        for (int i = 0; i < n; i++) {
            dins[i] = new DataInputStream(ins[i]);
        }

        // 创建最小值堆（从小到大）
        IndexHeap<Integer> indexHeap = new IndexHeapImpl<Integer>(n, Comparator.comparingInt(a -> a));
        // 初始化多路数据
        for (int i = 0; i < n; i++) {
            int number = dins[i].readInt();
            if (number == -1) {
                dins[i].close();
                dins[i] = null;
                continue;
            }
            indexHeap.insert(i, number);
        }

        while (indexHeap.size() > 0) {
            // 移除堆顶记录，追加到输出流
            int index = indexHeap.firstIndex();
            int number = indexHeap.removeFirst();
            out.write(ByteUtil.toBytes(number));
            if (dins[index] == null) {
                continue;
            }

            // 从被移除的那一路补充数据
            number = dins[index].readInt();
            if (number == -1) {
                dins[index].close();
                dins[index] = null;
                continue;
            }

            indexHeap.insert(index, number);
        }
    }

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int n = random.nextInt(10);
        InputStream[] ins = new InputStream[n];
        for (int i = 0; i < n; i++) {
            int size = random.nextInt(50);
            int[] numbers = new int[size + 1];
            for (int j = 0; j < size + 1; j++) {
                numbers[j] = random.nextInt(1000);
            }
            Arrays.sort(numbers);
            numbers[size] = -1;
            byte[] bytes = ByteUtil.toBytes(numbers);
            ins[i] = new ByteArrayInputStream(bytes);
            System.out.println(Arrays.toString(numbers));
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new Multiway().merge(ins, out);

        System.out.println();
        int[] ints = ByteUtil.toInts(out.toByteArray());
        System.out.println(Arrays.toString(ints));
    }

}

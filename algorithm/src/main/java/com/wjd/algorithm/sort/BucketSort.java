package com.wjd.algorithm.sort;

import java.util.*;

/**
 * 桶排序
 *
 * @author weijiaduo
 * @since 2022/9/5
 */
public class BucketSort implements Sort {

    List<List<Integer>> buckets;
    int min;
    int max;
    int width;

    public BucketSort() {
        this(10);
    }

    public BucketSort(int width) {
        this.width = width;
    }

    @Override
    public void sort(int[] arr) {
        // 初始化桶
        intBuckets(arr);

        // 划分到不同的桶里面
        for (int num : arr) {
            int index = bucketIndex(num);
            List<Integer> list = getBucket(index);
            list.add(num);
        }

        // 单独对每个桶进行排序，桶之间已经是有序的了
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 按桶的顺序遍历所有数据，就是已经拍好序的了
        int k = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                arr[k++] = num;
            }
        }
    }

    /**
     * 初始化桶
     */
    private void intBuckets(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        this.min = min;
        this.max = max;
        int n = (max - min + width) / width;
        buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    /**
     * 获取指定桶
     *
     * @param index 指定索引
     * @return 指定桶
     */
    private List<Integer> getBucket(int index) {
        return buckets.get(index);
    }

    /**
     * 指定值对应的桶索引
     *
     * @param val 指定值
     * @return 桶索引
     */
    private int bucketIndex(int val) {
        return (val - min) / width;
    }

}

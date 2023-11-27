package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 40. 最小的K个数
 * <p>
 * 输入n个整数，找出其中最小的K个数。
 * <p>
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class KLeastNumbers {

    /**
     * 思路：维护一个大小为k的大顶堆，遍历数组，
     * <p>
     * 如果堆的大小小于k，则直接入堆；
     * <p>
     * 如果当前元素小于堆顶元素，则将堆顶元素出堆，当前元素入堆。
     * <p>
     * 复杂度：时间 O(nlogk) 空间 O(k)
     */
    @TestCase(input = {"[4,5,1,6,2,7,3,8]", "4"}, output = "[1,2,3,4]")
    public List<Integer> heap(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0) {
            return new ArrayList<>(0);
        }

        // 大顶堆
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num < queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        List<Integer> res = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    /**
     * 思路：快速排序的思想，每次将数组分为两部分，
     * <p>
     * 如果分界点下标为k，则左边的k个元素就是最小的k个数
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[4,5,1,6,2,7,3,8]", "4"}, output = "[1,2,3,4]")
    public List<Integer> quicksort(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0) {
            return new ArrayList<>(0);
        }

        int n = input.length;
        int lp = 0, rp = n - 1;
        while (lp <= rp) {
            int p = partition(input, lp, rp);
            if (p == k - 1) {
                break;
            } else if (p < k - 1) {
                lp = p + 1;
            } else {
                rp = p - 1;
            }
        }

        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 快速排序的分区函数
     *
     * @param nums 数组
     * @param low  [low, high] 闭区间
     * @param high [low, high] 闭区间
     * @return 分区点
     */
    private int partition(int[] nums, int low, int high) {
        int x = nums[low];
        int lp = low, rp = high;
        while (lp < rp) {
            while (lp < rp && nums[rp] >= x) {
                rp--;
            }
            while (lp < rp && nums[lp] <= x) {
                lp++;
            }
            swap(nums, lp, rp);
        }
        swap(nums, low, lp);
        return lp;
    }

    /**
     * 交换数组中两个元素
     *
     * @param nums 数组
     * @param i    元素下标
     * @param j    元素下标
     */
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

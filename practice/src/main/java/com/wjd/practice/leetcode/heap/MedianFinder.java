package com.wjd.practice.leetcode.heap;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * <p>
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * <p>
 * 实现 MedianFinder 类:
 * <p>
 * MedianFinder() 初始化 MedianFinder 对象。
 * <p>
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * <p>
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * <p>
 * 提示:
 * <p>
 * -10⁵ <= num <= 10⁵
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 10⁴ 次调用 addNum 和 findMedian
 *
 * @author weijiaduo
 * @since 2022/9/7
 */
public class MedianFinder {

    @TestCase(input = {"[1,2,3]"},
            output = {"[1,1.5,2]"})
    public List<Double> test(int[] nums) {
        List<Double> res = new ArrayList<>(nums.length);
        MedianFinder medianFinder = new MedianFinder();
        for (int num : nums) {
            medianFinder.addNum(num);
            res.add(medianFinder.findMedian());
        }
        return res;
    }

    /**
     * 大值堆
     */
    PriorityQueue<Integer> maxHeap;
    /**
     * 小值堆
     */
    PriorityQueue<Integer> minHeap;

    /**
     * 思路：大值堆保存有序序列的前半部分，小值堆保存有序序列的后半部分
     * <p>
     * 执行耗时:98 ms,击败了82.40% 的Java用户
     * 内存消耗:59.6 MB,击败了63.34% 的Java用户
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        // 优先放小值堆
        if (minHeap.size() == 0 || num >= minHeap.peek()) {
            minHeap.offer(num);
            // 平均两个堆的数量，大值堆数量 <= 小值堆数量
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.offer(num);
            // 平均两个堆的数量，大值堆数量 <= 小值堆数量
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        int maxSize = maxHeap.size(), minSize = minHeap.size();
        if (maxSize == 0 && minSize == 0) {
            return 0.0;
        }
        if (minSize == maxSize) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (minSize > maxSize) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

}

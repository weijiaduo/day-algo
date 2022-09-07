package com.wjd.practice.leetcode.heap;

import com.wjd.practice.Solution;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * @author weijiaduo
 * @since 2022/9/7
 */
public class MedianFinder implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        return null;
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
        } else {
            maxHeap.offer(num);
        }
        // 平均两个堆的数量，大值堆数量 <= 小值堆数量
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            return 0.0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

}

package com.wjd.practice.book.sword.heap;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 41. 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * <p>
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class MedianInStream {

    /**
     * 大值堆
     */
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    /**
     * 小值堆
     */
    Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public void insert(int num) {
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

    public double getMedian() {
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

    @TestCase(input = {"[1,2,3]"},
            output = {"[1,1.5,2]"})
    public List<Double> test(int[] nums) {
        List<Double> res = new ArrayList<>(nums.length);
        MedianInStream medianFinder = new MedianInStream();
        for (int num : nums) {
            medianFinder.insert(num);
            res.add(medianFinder.getMedian());
        }
        return res;
    }

}

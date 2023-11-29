package com.wjd.practice.book.sword.queue;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 59.2 队列的最大值
 * <p>
 * 请定义一个队列并实现函数 max 得到队列里的最大值，要求函数 max、push_back 和 pop_front 的时间复杂度都是 O(1)。
 *
 * @author weijiaduo
 * @since 2023/11/29
 */
public class QueueWithMax {

    /**
     * 数据队列
     */
    Queue<Integer> dataQueue;
    /**
     * 最大值队列，单调递减
     */
    Deque<Integer> maxQueue;

    /**
     * 思路：使用单调递减的双向队列保存当前队列中的最大值
     * <p>
     * 若当前值比最大值队列中的值大，则将队列值弹出，直到当前值小于等于队列值
     * <p>
     * 最大值队列的队首元素就是当前队列的最大值
     * <p>
     * 复杂度：时间 O(1) 空间 O(n)
     */
    public QueueWithMax() {
        dataQueue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    /**
     * 添加元素
     *
     * @param value 元素值
     * @return 是否添加成功
     */
    public boolean add(int value) {
        dataQueue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
        return true;
    }

    /**
     * 移除并返回队首元素
     *
     * @return 队首元素
     */
    public int poll() {
        if (dataQueue.isEmpty()) {
            throw new NoSuchElementException();
        }

        int value = dataQueue.poll();
        if (value == maxQueue.getFirst()) {
            maxQueue.pollFirst();
        }
        return value;
    }

    /**
     * 返回队列中的最大值
     *
     * @return 最大值
     */
    public int max() {
        if (maxQueue.isEmpty()) {
            throw new NoSuchElementException();
        }

        return maxQueue.getFirst();
    }

    @TestCase(input = {"[6,2,3,4,2,5]", "3"},
            output = {"[6,6,6,4,4,5]"})
    public List<Integer> test(int[] nums, int pos) {
        List<Integer> ans = new ArrayList<>();
        QueueWithMax queue = new QueueWithMax();
        for (int i = 0; i < pos; i++) {
            queue.add(nums[i]);
            ans.add(queue.max());
        }
        while (!queue.dataQueue.isEmpty()) {
            queue.poll();
        }
        for (int i = pos; i < nums.length; i++) {
            queue.add(nums[i]);
            ans.add(queue.max());
        }
        return ans;
    }

}

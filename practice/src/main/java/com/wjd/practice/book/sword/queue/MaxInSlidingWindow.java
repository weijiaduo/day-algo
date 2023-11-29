package com.wjd.practice.book.sword.queue;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 59.1 滑动窗口的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * <p>
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * <p>
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * <p>
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * <p>
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * <p>
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 窗口大于数组长度的时候，返回空。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class MaxInSlidingWindow {

    /**
     * 思路：单调队列
     * <p>
     * 用一个单调递减的双端队列来存储当前窗口中可能是最大值的元素的下标。
     * <p>
     * 队列首元素是当前窗口中的最大值。
     * <p>
     * 复杂度：时间 O(n) 空间 O(k)
     */
    @TestCase(input = {
            "[2,3,4,2,6,2,5,1]", "0",
            "[2,3,4,2,6,2,5,1]", "1",
            "[2,3,4,2,6,2,5,1]", "8",
            "[2,3,4,2,6,2,5,1]", "9",
            "[2,3,4,2,6,2,5,1]", "3"},
            output = {
                    "[]",
                    "[2,3,4,2,6,2,5,1]",
                    "[6]",
                    "[]",
                    "[4,4,6,6,6,5]"})
    public List<Integer> maxInWindows(int[] nums, int size) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || size == 0 || size > nums.length) {
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 更新单调递减队列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i < size - 1) {
                // 窗口还没形成，继续
                continue;
            }

            // 如果队首元素不在窗口中了，就移除
            if (deque.getFirst() == i - size) {
                deque.pollFirst();
            }
            // 窗口形成了，就把队首元素加入结果集
            res.add(nums[deque.getFirst()]);
        }
        return res;
    }

}

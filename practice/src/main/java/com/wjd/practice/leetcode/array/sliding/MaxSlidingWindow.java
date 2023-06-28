package com.wjd.practice.leetcode.array.sliding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * <p>
 * 你只可以看到在滑动窗口内的 k 个数字。
 * <p>
 * 滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * 1 <= k <= nums.length
 *
 * @author weijiaduo
 * @since 2023/6/8
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return stack(nums, k);
    }

    /**
     * 思路：使用最大值堆记录数组索引，滑动的时候更新堆
     * <p>
     * 每次处理前，先移除堆中的无效索引，即小于当前 l 的索引都是无效的
     * <p>
     * 然后获取栈顶的数据，就是当前窗口的最小值
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 行耗时:85 ms,击败了17.88% 的Java用户
     * 内存消耗:58.4 MB,击败了40.80% 的Java用户
     */
    private int[] heap(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ret = new int[m];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        for (int i = 0; i < k && i < n; i++) {
            maxHeap.add(i);
        }
        int l = 0, r = k - 1;
        while (r < n) {
            // 移除无效的堆顶值
            while (!maxHeap.isEmpty() && maxHeap.peek() < l) {
                maxHeap.poll();
            }
            // 窗口往右滑动
            ret[l++] = nums[maxHeap.peek()];
            if (++r < n) {
                maxHeap.add(r);
            }
        }
        return ret;
    }

    /**
     * 官方解答
     * <p>
     * 思路：递减的单调栈
     * <p>
     * 对于窗口内的 l < r 而言，如果也存在 nums[l] < nums[r]，那么 l 就不可能是最大值
     * <p>
     * 所有只需要记录 r 即可，l 可以丢失
     * <p>
     * 因此记录的 r 会构成一个递减的单调序列
     * <p>
     * 最大值就在序列头，所以可以用队列来保存单调序列
     * <p>
     * 复杂度：时间 O(n) 空间 O(k)
     * <p>
     * 执行耗时:30 ms,击败了65.75% 的Java用户
     * 内存消耗:59.1 MB,击败了35.28% 的Java用户
     */
    private int[] stack(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ret = new int[m];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k && i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        int l = 0, r = k - 1;
        while (r < n) {
            // 移除无效的索引
            while (!queue.isEmpty() && queue.getFirst() < l) {
                queue.pollFirst();
            }
            // 滑动窗口
            ret[l++] = nums[queue.getFirst()];
            if (++r < n) {
                // 添加到递减单调栈
                while (!queue.isEmpty() && nums[r] >= nums[queue.getLast()]) {
                    queue.pollLast();
                }
                queue.addLast(r);
            }
        }
        return ret;
    }

}

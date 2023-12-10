package com.wjd.practice.leetcode.heap;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 502. IPO
 * <p>
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 * <p>
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * <p>
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 * <p>
 * 答案保证在 32 位有符号整数范围内。
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * 输出：4
 * 解释：
 * 由于你的初始资本为 0，你仅可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * <p>
 * 示例 2：
 * <p>
 * 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 10⁵
 * 0 <= w <= 10⁹
 * n == profits.length
 * n == capital.length
 * 1 <= n <= 10⁵
 * 0 <= profits[i] <= 10⁴
 * 0 <= capital[i] <= 10⁹
 *
 * @author weijiaduo
 * @since 2023/12/10
 */
public class FindMaximizedCapital {

    /**
     * 思路：贪心+排序
     * <p>
     * 尽量选择利润大、成本低的项目，这样可以保证每一轮都能达到最优
     * <p>
     * 可以使用堆来获取每一轮的最大利润项目
     * <p>
     * 堆里面存放的都是可选择的项目，即成本足够的项目
     * <p>
     * 复杂度：时间 O(nlogn + klogn) 空间 O(n)
     * <p>
     * 执行耗时:94 ms,击败了28.64% 的Java用户
     * 内存消耗:62.8 MB,击败了19.10% 的Java用户
     */
    @TestCase(input = {"2", "0", "[1,2,3]", "[0,1,1]",
            "3", "0", "[1,2,3]", "[0,1,2]"},
            output = {"4", "6"})
    public int sort(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        // 按照成本排序
        Arrays.sort(indexes, Comparator.comparingInt(i -> capital[i]));

        int ans = w;
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0, j = 0; i < k; i++) {
            // 将能够选择（成本足够）的项目放入堆中
            while (j < n && capital[indexes[j]] <= ans) {
                heap.offer(profits[indexes[j]]);
                j++;
            }
            // 没有项目可选择
            if (heap.isEmpty()) {
                break;
            }
            // 选择利润的最大项目
            ans += heap.poll();
        }
        return ans;
    }

}

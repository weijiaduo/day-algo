package com.wjd.practice.leetcode.array.statistics;

import java.util.Arrays;

/**
 * 第 349 场周赛
 * <p>
 * 6449. 收集巧克力
 * <p>
 * 给你一个长度为 n 、下标从 0 开始的整数数组 nums ，表示收集不同巧克力的成本。
 * <p>
 * 每个巧克力都对应一个不同的类型，最初，位于下标 i 的巧克力就对应第 i 个类型。
 * <p>
 * 在一步操作中，你可以用成本 x 执行下述行为：
 * <p>
 * 同时对于所有下标 0 <= i < n - 1 进行以下操作， 将下标 i 处的巧克力的类型更改为下标 (i + 1) 处的巧克力对应的类型。
 * <p>
 * 如果 i == n - 1 ，则该巧克力的类型将会变更为下标 0 处巧克力对应的类型。
 * <p>
 * 假设你可以执行任意次操作，请返回收集所有类型巧克力所需的最小成本。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [20,1,15], x = 5
 * 输出：13
 * 解释：最开始，巧克力的类型分别是 [0,1,2] 。我们可以用成本 1 购买第 1 个类型的巧克力。
 * 接着，我们用成本 5 执行一次操作，巧克力的类型变更为 [2,0,1] 。我们可以用成本 1 购买第 0 个类型的巧克力。
 * 然后，我们用成本 5 执行一次操作，巧克力的类型变更为 [1,2,0] 。我们可以用成本 1 购买第 2 个类型的巧克力。
 * 因此，收集所有类型的巧克力需要的总成本是 (1 + 5 + 1 + 5 + 1) = 13 。可以证明这是一种最优方案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], x = 4
 * 输出：6
 * 解释：我们将会按最初的成本收集全部三个类型的巧克力，而不需执行任何操作。因此，收集所有类型的巧克力需要的总成本是 1 + 2 + 3 = 6 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * 1 <= x <= 109
 *
 * @author weijiaduo
 * @since 2023/6/11
 */
public class MinCost {

    /**
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行用时：45 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public long minCost(int[] nums, int x) {
        // 原地收集的成本
        long minSum = 0;
        for (int num : nums) {
            minSum += num;
        }
        int n = nums.length;
        int[] next = Arrays.copyOf(nums, n);
        for (int t = 1; t < n; t++) {
            // 最多移动 n - 1 轮
            long sum = (long) x * t;
            for (int i = 0; i < n; i++) {
                // 新一轮移动后的成本和上一轮成本比较
                next[i] = Math.min(next[i], nums[(i - t + n) % n]);
                sum += next[i];
            }
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

}

package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.Solution;

/**
 * 213. 打家劫舍2
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * <p>
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * <p>
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class Rob2 implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {1, 2, 3, 1};
        int result = rob(nums);
        System.out.println(result);
        return result;
    }

    private int rob(int[] nums) {
        return dynamic(nums);
    }

    /**
     * 思路：动态规划（压缩空间后），分为取第1间和不取第1间这两种情况来处理
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了25.33% 的Java用户
     */
    private int dynamic(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }

        // 取第1间，第2间和第n间就不能取了
        int lastNotFetch = nums[0], lastFetch = nums[0];
        for (int i = 2; i < n - 1; i++) {
            int notFetch = Math.max(lastNotFetch, lastFetch);
            int fetch = lastNotFetch + nums[i];
            lastNotFetch = notFetch;
            lastFetch = fetch;
        }
        int max1 = Math.max(lastNotFetch, lastFetch);

        // 不取第1间，那么第2间和第n间都可能取
        lastNotFetch = lastFetch = 0;
        for (int i = 1; i < n; i++) {
            int notFetch = Math.max(lastNotFetch, lastFetch);
            int fetch = lastNotFetch + nums[i];
            lastNotFetch = notFetch;
            lastFetch = fetch;
        }
        int max2 = Math.max(lastNotFetch, lastFetch);

        return Math.max(max1, max2);
    }

}

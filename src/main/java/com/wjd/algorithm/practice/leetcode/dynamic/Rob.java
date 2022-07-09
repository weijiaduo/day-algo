package com.wjd.algorithm.practice.leetcode.dynamic;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * <p>
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * <p>
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class Rob implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {2, 7, 9, 3, 1};
        int result = rob(nums);
        System.out.println(result);
        return result;
    }

    private int rob(int[] nums) {
        // return dynamic(nums);
        return dynamic2(nums);
    }

    /**
     * 思路：动态规划，当前位置，可以取，也可以不取，动态记录这2种状态，直到最后算出最大值
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了28.92% 的Java用户
     *
     * @param nums 数组
     * @return 结果
     */
    private int dynamic(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }

        // 初始化状态
        int[][] dp = new int[n][2];
        // 不取当前位置
        dp[0][0] = 0;
        // 取当前位置
        dp[0][1] = nums[0];

        // 动态计算
        for (int i = 1; i < n; i++) {
            // 不取当前位置，上一次可以取也可以不取
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 取当前位置，上一次只能是不取的
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 思路：压缩动态规划，由于动态规划只用到了上一个值，所以无需用数组保存，用2个变量即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了65.65% 的Java用户
     *
     * @param nums 数组
     * @return 结果
     */
    private int dynamic2(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }

        // 上一次不取，或者上一次取
        int lastNotFetch = 0, lastFetch = nums[0];
        for (int i = 1; i < n; i++) {
            int notFetch = Math.max(lastNotFetch, lastFetch);
            int fetch = lastNotFetch + nums[i];
            lastNotFetch = notFetch;
            lastFetch = fetch;
        }

        return Math.max(lastNotFetch, lastFetch);
    }

}

package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.TestCase;

/**
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * <p>
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * <p>
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * <p>
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class Rob {

    /**
     * 思路：动态规划，二维动态数组
     * <p>
     * 每个房子，可以分为2种情况：
     * <p>
     * 1、取当前房子
     * 2、不取当前房子
     * <p>
     * 记录该房子这两种状态下的最大值，然后得得转移公式
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了28.92% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "[2,7,9,3,1]"},
            output = {"4", "12"})
    private int dynamic2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // 状态定义
        // dp[i][0] 表示不取，dp[i][1] 表示取
        int[][] dp = new int[n][2];

        // 状态初始化
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        // 状态转移
        for (int i = 1; i < n; i++) {
            // 不取当前位置，上一次可以取也可以不取
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 取当前位置，上一次只能是不取的
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 思路：动态规划，一维动态数组
     * <p>
     * dp[i] 表示前 i 间房子得到的最大值
     * <p>
     * 那么由于相邻房子不能一起偷，所以可分为2种情况：
     * <p>
     * 1、取当前房子
     * 2、不取当前房子
     * <p>
     * 由此可得到转移公式：
     * <p>
     * dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了51.91% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "[2,7,9,3,1]"},
            output = {"4", "12"})
    private int dynamic1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // 状态定义
        // dp[i] 表示前 i 间房子得到的最大值
        int[] dp = new int[n];
        // 状态初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 状态转移
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    /**
     * 思路：动态规划，滚动数组
     * <p>
     * 由于动态规划只用到了上一个值，所以无需用数组保存，用2个变量即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了65.65% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "[2,7,9,3,1]"},
            output = {"4", "12"})
    private int dynamic0(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // 状态初始化
        int lastTwo = nums[0];
        int lastOne = Math.max(nums[0], nums[1]);
        // 状态转移
        for (int i = 2; i < n; i++) {
            int tmp = Math.max(lastOne, lastTwo + nums[i]);
            lastTwo = lastOne;
            lastOne = tmp;
        }
        return lastOne;
    }

}

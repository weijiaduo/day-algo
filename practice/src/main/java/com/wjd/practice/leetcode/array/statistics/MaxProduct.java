package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.TestCase;

/**
 * 152. 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 * @author weijiaduo
 * @since 2022/6/30
 */
public class MaxProduct {

    /**
     * 思路：递归，分为2种情况：1、仅当前元素 2、当前元素*连续子数组
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了95.21% 的Java用户
     * 内存消耗:42.5 MB,击败了5.02% 的Java用户
     */
    @TestCase(input = {"[2,3,-2,4]", "[-2,0,-1]"},
            output = {"6", "0"})
    private int dfs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] result = dfs(nums, 0);
        return result[2];
    }

    private int[] dfs(int[] nums, int i) {
        if (i == nums.length) {
            return new int[]{1, 1, Integer.MIN_VALUE};
        }

        int num = nums[i];
        // 从i+1开始的子数组统计结果
        int[] ret = dfs(nums, i + 1);
        // 从下一个元素开始的连续最小值
        int n1 = num * ret[0];
        // 下一个元素开始的连续最大值
        int n2 = num * ret[1];
        // 子数组总的最小值
        int n3 = ret[2];

        // 从当前元素开始，或者当前元素乘上后面的连续元素
        // 因为存在负数的情况，所以需要记住最小值
        int min = Math.min(num, Math.min(n1, n2));
        int max = Math.max(num, Math.max(n1, n2));
        int ans = Math.max(max, n3);
        return new int[]{min, max, ans};
    }

    /**
     * 思路：动态规划
     * <p>
     * max[i] 表示以 i 为结尾的子数组的乘积最大值
     * <p>
     * min[i] 表示以 i 为结尾的子数组的乘积最小值
     * <p>
     * max[i] = max(nums[i], nums[i]*max[i-1], nums[i]*min[i-1])
     * <p>
     * min[i] = min(nums[i], nums[i]*max[i-1], nums[i]*min[i-1])
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了23.21% 的Java用户
     * 内存消耗:43.68 MB,击败了49.50% 的Java用户
     */
    public int dynamic1(int[] nums) {
        // 状态定义
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        // 状态初始化
        max[0] = min[0] = nums[0];
        // 状态转移
        int ans = max[0];
        for (int i = 1; i < n; i++) {
            int mx = nums[i] * max[i - 1];
            int mn = nums[i] * min[i - 1];
            max[i] = Math.max(nums[i], Math.max(mx, mn));
            min[i] = Math.min(nums[i], Math.min(mx, mn));
            ans = Math.max(max[i], ans);
        }
        // 返回结果
        return ans;
    }

    /**
     * 思路：动态规划，分为2种情况：1、仅当前元素 2、当前元素*连续子数组
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了66.03% 的Java用户
     * 内存消耗:41.7 MB,击败了30.69% 的Java用户
     */
    @TestCase(input = {"[2,3,-2,4]", "[-2,0,-1]"},
            output = {"6", "0"})
    private int dynamic0(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = 1, max = 1, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            int n1 = num * min;
            int n2 = num * max;
            // 从当前元素开始，或者当前元素乘上后面的连续元素
            // 因为存在负数的情况，所以需要记住最小值
            min = Math.min(num, Math.min(n1, n2));
            max = Math.max(num, Math.max(n1, n2));
            ans = Math.max(max, ans);
        }
        return ans;
    }

}

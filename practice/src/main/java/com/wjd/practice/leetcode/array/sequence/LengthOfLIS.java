package com.wjd.practice.leetcode.array.sequence;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * <p>
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @author weijiaduo
 * @since 2022/9/10
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        // return dynamic(nums);
        return binary(nums);
    }

    /**
     * 思路：动态规划，先算出以 nums[i] 结尾的最长子序列，再推导出下一个以 num[i+1]
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:55 ms,击败了71.96% 的Java用户
     * 内存消耗:40.7 MB,击败了93.08% 的Java用户
     *
     * @param nums 数组
     * @return 最长递增子序列长度
     */
    private int dynamic(int[] nums) {
        // 状态定义
        // dp[i] 表示以 nums[i] 结尾的子序列的最大长度
        int n = nums.length;
        int[] dp = new int[n];

        // 状态初始化
        // 每个数字至少都能以自己结尾，长度是1
        Arrays.fill(dp, 1);

        // 状态转移
        // dp[i] = max(dp[i], dp[j] + 1)，其中 j 属于 [0, i)
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }

        return ans;
    }

    /**
     * 思路：动态规划，记录每种长度的序列的最小值
     * <p>
     * 比如说，长度为2的序列有 [1,2]，[1,3], [2,3] 等多种
     * <p>
     * 为了能使得下一个元素能在原序列上继续递增，应该选择序列末尾元素最小的那条序列 [1,2]
     * <p>
     * 也就是说，在同种长度的序列中，只要保留末尾元素最小的那一条即可，其他的均可丢弃
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了99.59% 的Java用户
     * 内存消耗:41 MB,击败了50.57% 的Java用户
     *
     * @param nums 数组
     * @return 最长递增子序列的长度
     */
    private int binary(int[] nums) {
        // 状态定义
        // dp[i] 表示以 nums[i] 结尾的子序列的最大长度
        int n = nums.length;
        // 状态初始化0
        int[] dp = new int[n];

        // 状态转移
        // 找到第一个大于等于 num 的位置 dp[i]，替换 dp[i] 为更小值 num
        int size = 0;
        for (int num : nums) {
            int idx = findFirstNotLessThan(dp, size, num);
            if (idx >= size) {
                size = idx + 1;
            }
            dp[idx] = num;
        }

        return size;
    }

    /**
     * 找到第一个大于等于指定值的位置
     */
    private int findFirstNotLessThan(int[] dp, int size, int num) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] >= num) {
                if (mid == 0 || dp[mid - 1] < num) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}

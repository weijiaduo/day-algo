package com.wjd.practice.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * <p>
 * 给你一个由 无重复 正整数组成的集合 nums ，
 * <p>
 * 请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * <p>
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * <p>
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 *
 * @author weijiaduo
 * @since 2022/9/13
 */
public class LargestDivisibleSubset {

    /**
     * 思路：排序，记录以每个元素结尾的最大整除子集的长度
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:15 ms,击败了24.22% 的Java用户
     * 内存消耗:41.2 MB,击败了95.74% 的Java用户
     *
     * @param nums 数组
     * @return 最长整除子集
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 数组排序
        Arrays.sort(nums);

        // 状态定义
        // dp[i][0] 表示子集长度，dp[i][1] 表示上一个索引
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int[] p : dp) {
            p[0] = 1;
            p[1] = -1;
        }

        // 状态转移
        // dp[i][0] = max(dp[j][0] + 1), j 范围是 [0, i)
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if (dp[i][0] > dp[maxIndex][0]) {
                maxIndex = i;
            }
        }

        // 找出最大整除子集的数字
        List<Integer> list = new ArrayList<>(dp[maxIndex][0]);
        int index = maxIndex;
        while (index >= 0) {
            list.add(0, nums[index]);
            index = dp[index][1];
        }
        return list;
    }

}

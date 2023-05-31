package com.wjd.practice.leetcode.array.sequence;

/**
 * 673. 最长递增子序列的个数
 * <p>
 * 给定一个未排序的整数数组
 * nums ， 返回最长递增子序列的个数 。
 * <p>
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * @author weijiaduo
 * @since 2022/10/21
 */
public class FindNumberOfLIS {

    public int solve(int[] nums) {
        return dp(nums);
    }

    /**
     * 思路：动态规划，以 nums[i] 结尾的递增序列，可从 [0,i-1] 中推导出来
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:17 ms,击败了83.31% 的Java用户
     * 内存消耗:41.2 MB,击败了39.76% 的Java用户
     */
    private int dp(int[] nums) {
        // 子序列最大长度以及对应的序列数量
        int maxLen = 0, maxCnt = 0;

        // 初始化状态
        // dp[i] {len, cnt} 表示以 nums[i] 结尾的最大长度和数量
        int n = nums.length;
        int[][] dp = new int[n][2];

        // 状态转移
        // dp[i+1].len = max(dp[j].len) + 1, j < i && nums[j] < nums[i]
        for (int i = 0; i < n; i++) {
            int len = 1, cnt = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] >= len) {
                        len = dp[j][0] + 1;
                        cnt = dp[j][1];
                    } else if (dp[j][0] == len - 1) {
                        // 存在多个相同长度的子序列
                        cnt += dp[j][1];
                    }
                }
            }
            dp[i] = new int[]{len, cnt};

            // 更新子序列的最大长度及数量
            if (len > maxLen) {
                maxLen = len;
                maxCnt = cnt;
            } else if (len == maxLen) {
                maxCnt += cnt;
            }
        }

        return maxCnt;
    }

}

package com.wjd.practice.leetcode.dynamic.multi;

import com.wjd.practice.TestCase;

/**
 * 718. 最长重复子数组
 * <p>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 *
 * @author weijiaduo
 * @since 2024/1/31
 */
public class FindLength {

    /**
     * 思路：动态规划
     * <p>
     * dp[i][j] 表示以 nums1[i] 和 nums2[j] 为结尾的最长数组长度
     * <p>
     * dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1] + 1 ? 0
     * <p>
     * 复杂度：时间 O(nm) 空间 O(nm)
     * <p>
     * 执行耗时:21 ms,击败了91.41% 的Java用户
     * 内存消耗:53.6 MB,击败了51.83% 的Java用户
     */
    @TestCase(input = {"[1,2,3,2,1]", "[3,2,1,4,7]", "[0,0,0,0,0]", "[0,0,0,0,0]", "[1,0,0,0,1]", "[1,0,0,1,1]"},
            output = {"3", "5", "3"})
    public int dynamic2(int[] nums1, int[] nums2) {
        // 状态定义
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 状态初始化，初始化为 0
        // 状态转移
        int ans = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }

    /**
     * 思路：动态规划 + 滚动数组
     * <p>
     * 下次状态只依赖于上次的状态，因此可以采用滚动数组压缩空间
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:16 ms,击败了99.15% 的Java用户
     * 内存消耗:43 MB,击败了83.68% 的Java用户
     */
    @TestCase(input = {"[1,2,3,2,1]", "[3,2,1,4,7]", "[0,0,0,0,0]", "[0,0,0,0,0]", "[1,0,0,0,1]", "[1,0,0,1,1]"},
            output = {"3", "5", "3"})
    public int dynamic1(int[] nums1, int[] nums2) {
        // 状态定义
        int n1 = nums1.length, n2 = nums2.length;
        int[] dp = new int[n2 + 1];
        // 状态初始化，初始化为 0
        // 状态转移
        int ans = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = n2; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    ans = Math.max(dp[j], ans);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return ans;
    }

}

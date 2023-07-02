package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.leetcode.TestCase;

import java.util.TreeMap;

/**
 * 周赛 352
 * <p>
 * 6911. 不间断子数组
 * <p>
 * 给你一个下标从 0开始的整数数组nums。nums的一个子数组如果满足以下条件，那么它是 不间断 的：
 * <p>
 * i，i + 1，...，j 表示子数组中的下标。
 * <p>
 * 对于所有满足i <= i1, i2 <= j的下标对，都有 0 <= |nums[i1] - nums[i2]| <= 2。
 * <p>
 * 请你返回 不间断 子数组的总数目。
 * <p>
 * 子数组是一个数组中一段连续 非空的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,4,2,4]
 * 输出：8
 * 解释：
 * 大小为 1 的不间断子数组：[5], [4], [2], [4] 。
 * 大小为 2 的不间断子数组：[5,4], [4,2], [2,4] 。
 * 大小为 3 的不间断子数组：[4,2,4] 。
 * 没有大小为 4 的不间断子数组。
 * 不间断子数组的总数目为 4 + 3 + 1 = 8 。
 * 除了这些以外，没有别的不间断子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：6
 * 解释：
 * 大小为 1 的不间断子数组：[1], [2], [3] 。
 * 大小为 2 的不间断子数组：[1,2], [2,3] 。
 * 大小为 3 的不间断子数组：[1,2,3] 。
 * 不间断子数组的总数目为 3 + 2 + 1 = 6 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 * @author weijiaduo
 * @since 2023/7/2
 */
public class ContinuousSubarrays {

    /**
     * 思路：滑动窗口+排序计数，记录每个数字的出现频率，并按照数字大小排序
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     */
    @TestCase(input = {"[5,4,2,4]", "[1,2,3]", "[65,66,67,66,66,65,64,65,65,64]"},
            output = {"8", "6", "43"})
    private long slide(int[] nums) {
        long ans = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            while (cnt.lastKey() - cnt.firstKey() > 2) {
                int c = cnt.get(nums[j]);
                if (c == 1) {
                    cnt.remove(nums[j]);
                } else {
                    cnt.put(nums[j], c - 1);
                }
                j++;
            }
            // [j, i] 内所有以 i 结尾的子数组数量
            ans += i - j + 1;
        }
        return ans;
    }

    /**
     * 思路：压缩动态规划，只依赖于上一轮的结果
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 超出时间限制
     */
    @TestCase(input = {"[5,4,2,4]", "[1,2,3]", "[65,66,67,66,66,65,64,65,65,64]"},
            output = {"8", "6", "43"})
    private long dynamic1(int[] nums) {
        int n = nums.length;
        long ans = n;
        // dp[i][2] 表示区间的最大最小值
        int[][] dp = new int[n][2];

        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = nums[i];
        }

        // 状态转移
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][0] = Math.min(dp[i][0], nums[j]);
                dp[i][1] = Math.max(dp[i][1], nums[j]);
                if (dp[i][1] - dp[i][0] > 2) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    /**
     * 思路：动态规划，dp[i][j] 记录区间 [i,j] 内的最大最小值
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n^2)
     * <p>
     * 超出内存限制
     */
    @TestCase(input = {"[5,4,2,4]", "[1,2,3]", "[65,66,67,66,66,65,64,65,65,64]"},
            output = {"8", "6", "43"})
    private long dynamic2(int[] nums) {
        int n = nums.length;
        long ans = n;

        // dp[i][j][2] 表示区间的最大最小值
        int[][][] dp = new int[n][n][2];

        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = dp[i][i][1] = nums[i];
        }

        // 状态转移
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j][0] = Math.min(dp[i][j - 1][0], nums[j]);
                dp[i][j][1] = Math.max(dp[i][j - 1][1], nums[j]);
                if (dp[i][j][1] - dp[i][j][0] > 2) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

}

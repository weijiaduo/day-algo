package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1911. 最大子序列交替和
 * <p>
 * 一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。
 * <p>
 * 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。
 * <p>
 * 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。
 * <p>
 * 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。
 * <p>
 * 比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的一个子序列（加粗元素），但是 [2,4,2] 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,5,3]
 * 输出：7
 * 解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8]
 * 输出：8
 * 解释：最优子序列为 [8] ，交替和为 8 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [6,2,1,2,4,5]
 * 输出：10
 * 解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁵
 *
 * @author weijiaduo
 * @since 2023/7/11
 */
public class MaxAlternatingSum {

    /**
     * 思路：单调序列
     * <p>
     * 保证偶数位是波峰，奇数位是波谷
     * <p>
     * 就能尽量保证子序列交替和最大
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了83.02% 的Java用户
     * 内存消耗:55.9 MB,击败了67.92% 的Java用户
     */
    @TestCase(input = {"[4,2,5,3]", "[5,6,7,8]", "[6,2,1,2,4,5]"},
            output = {"7", "8", "10"})
    public long monotonic(int[] nums) {
        long ans = 0;
        int n = nums.length, lp = -1, rp = 0;
        while (rp < n) {
            rp = lp + 1;
            while (rp < n - 1 && nums[rp] < nums[rp + 1]) {
                rp++;
            }
            int low = lp >= 0 ? nums[lp] : 0;
            int high = nums[rp];
            ans += high - low;
            lp = rp + 1;
            while (lp < n - 1 && nums[lp] > nums[lp + 1]) {
                lp++;
            }
            rp = lp + 1;
        }
        return ans;
    }

    /**
     * 思路：动态规划
     * <p>
     * 定义 dp[i] 是 [0...i] 内的最大子序列交替和
     * <p>
     * 根据 dp[i-1] 是奇数还是偶数，分为 2 种情况
     * <p>
     * 1、若 dp[i-1] 是奇数，则 dp[i] = max(dp[i-1] + nums[i], dp[i-1])
     * <p>
     * 2、若 dp[i-1] 是偶数，则 dp[i] = max(dp[i-1] - nums[i], dp[i-1])
     * <p>
     * 需要分奇数和偶数，所有 dp 需要同时记录这 2 种情况
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:28 ms,击败了41.51% 的Java用户
     * 内存消耗:58.7 MB,击败了27.36% 的Java用户
     */
    @TestCase(input = {"[4,2,5,3]", "[5,6,7,8]", "[6,2,1,2,4,5]"},
            output = {"7", "8", "10"})
    public long dynamic1(int[] nums) {
        // 状态定义
        // dp[i][0] 是偶数位结尾的情况
        // dp[i][1] 是奇数位结尾的情况
        int n = nums.length;
        long[][] dp = new long[n][2];

        // 状态初始化
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        // 状态转移
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    /**
     * 思路：动态规划，动态数组
     * <p>
     * 动态规划只依赖于上一轮的结果，所以可以用滚动数组替代
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了82.08% 的Java用户
     * 内存消耗:55.8 MB,击败了73.58% 的Java用户
     */
    @TestCase(input = {"[4,2,5,3]", "[5,6,7,8]", "[6,2,1,2,4,5]"},
            output = {"7", "8", "10"})
    public long dynamic0(int[] nums) {
        // 状态定义和初始化
        long even = nums[0], odd = 0;
        // 状态转移
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            long even1 = Math.max(odd + nums[i], even);
            long odd1 = Math.max(even - nums[i], odd);
            even = even1;
            odd = odd1;
        }
        return even;
    }

}

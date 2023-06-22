package com.wjd.practice.leetcode.dynamic;

import java.util.Arrays;

/**
 * 1262. 可被三整除的最大和
 * <p>
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author weijiaduo
 * @since 2023/6/22
 */
public class MaxSumDivThree {

    public int maxSumDivThree(int[] nums) {
        // return recursive(nums);
        // return dynamic(nums);
        // return scroll(nums);
        return greedy(nums);
    }

    // 记忆存储
    private int[][] memo;

    /**
     * 灵神题解
     * <p>
     * 思路：递归，对于数组 [0, i] 而言，求除 3 余 0 的最大值可分为几种情况：
     * <p>
     * 1、不选择数字 nums[i]，则最大值与 [0, i - 1] 中的一样
     * <p>
     * 2、选择当前数字 nums[i]，则还可以细分为几种情况：
     * <p>
     * 2.1 nums[i] % 3 = 0，那就找 [0, i - 1] 中余数为 0 的最大值
     * <p>
     * 2.2 nums[i] % 3 = 1，那就找 [0, i - 1] 中余数为 2 的最大值
     * <p>
     * 2.3 nums[i] % 3 = 2，那就找 [0, i - 1] 中余数为 1 的最大值
     * <p>
     * 每个问题都能往前递归找出。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:17 ms,击败了34.35% 的Java用户
     * 内存消耗:49.1 MB,击败了5.01% 的Java用户
     */
    private int recursive(int[] nums) {
        int n = nums.length;
        memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return recursive(nums, n - 1, 0);
    }

    /**
     * 在 [0, i] 找余数为 j 的最大值
     */
    private int recursive(int[] nums, int i, int j) {
        if (i < 0) {
            // 没选任何数字时，只有余数为 0 是正常情况
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }

        // 记忆存储
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 分为 2 种情况：不选择当前数字/选择当前数字
        int notFetch = recursive(nums, i - 1, j);
        int fetch = nums[i] + recursive(nums, i - 1, (j + nums[i]) % 3);

        return memo[i][j] = Math.max(notFetch, fetch);
    }

    /**
     * 官方题解
     * <p>
     * 思路：动态规划，记录前 i 个数和为不同余数 j (0<=j<3) 的最大值，然后递推出最终结果
     * <p>
     * dp[i][j] 表示前 i 个数和，余数为 j 时的最大值
     * <p>
     * 对于当前数字 nums[i]，可分为 2 种情况：
     * <p>
     * 1、不选择当前数字 dp[i][j] = dp[i - 1][j]
     * <p>
     * 2、选择当前数字 dp[i][j] = dp[i - 1][(j + nums[i]) % 3]
     * <p>
     * 总之就是在递推过程中，一直记录不同余数的最大值
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:12 ms,击败了49.70% 的Java用户
     * 内存消耗:43.8 MB,击败了40.91% 的Java用户
     */
    private int dynamic(int[] nums) {
        int n = nums.length;

        // 状态定义
        // dp[i][j] 表示前 i 个数和，余数为 j 时的最大值
        var dp = new int[n + 1][3];

        // 初始化状态
        dp[0][0] = 0;
        dp[0][1] = dp[0][2] = Integer.MIN_VALUE;

        // 状态转移
        for (int i = 0; i < n; i++) {
            // 分为 2 种状态：不选择当前数字/选择当前数字
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][(nums[i]) % 3] + nums[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][(1 + nums[i]) % 3] + nums[i]);
            dp[i + 1][2] = Math.max(dp[i][2], dp[i][(2 + nums[i]) % 3] + nums[i]);
        }

        return dp[n][0];
    }

    /**
     * 官方题解
     * <p>
     * 思路：滚动动态规划，动态规划中状态 i 只依赖于 i- 1
     * <p>
     * 因此可以将空间进行压缩，只要记录 i - 1 的状态即可，其他的都忽略
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:6 ms,击败了87.73% 的Java用户
     * 内存消耗:43.7 MB,击败了50.35% 的Java用户
     */
    private int scroll(int[] nums) {
        int n = nums.length;
        // 状态定义，dp[i] 表示余数 i 的最大值
        int[] dp = new int[3];
        // 初始化状态
        dp[1] = dp[2] = Integer.MIN_VALUE;
        // 状态转移
        for (int num : nums) {
            int t0 = dp[num % 3] + num;
            int t1 = dp[(1 + num) % 3] + num;
            int t2 = dp[(2 + num) % 3] + num;
            dp[0] = Math.max(dp[0], t0);
            dp[1] = Math.max(dp[1], t1);
            dp[2] = Math.max(dp[2], t2);
        }
        return dp[0];
    }

    /**
     * 灵神题解
     * <p>
     * 思路：贪心，数和的最大值肯定是所有数字加起来的总和 s
     * <p>
     * 但是 s 有可能不能将 3 整除，因此还需要分为 3 种情况处理：
     * <p>
     * 1、s % 3 = 0，则最大值就是 s
     * <p>
     * 2、s % 3 = 1，还可以分为 2 种情况
     * <p>
     * 2.1 数组中存在满足 nums[i] % 3 = 1 的最小数字，此时最大值为 s - nums[i]
     * <p>
     * 2.2 数组中存在2个满足 nums[i] % 3 = 2 的最小数字，此时最大值为 s - nums[i] - nums[j]
     * <p>
     * 3、s % 3 = 2，也同样分为 2 种情况：
     * <p>
     * 3.1 数组中存在满足 nums[i] % 3 = 2 的最小数字，此时最大值为 s - nums[i]
     * <p>
     * 2.2 数组中存在2个满足 nums[i] % 3 = 1 的最小数字，此时最大值为 s - nums[i] - nums[j]
     * <p>
     * 因此，先求出所有值的总和，再根据情况减去1或2个数字，就能求得满足条件的最大值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了94.51% 的Java用户
     * 内存消耗:43.9 MB,击败了27.71% 的Java用户
     */
    private int greedy(int[] nums) {
        // 记录余数为 1 和 2 的最小的 2 个数字
        int[] r1 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] r2 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int sum = 0, c1 = 0, c2 = 0;
        for (int num : nums) {
            sum += num;
            int r = num % 3;
            if (r == 1) {
                c1++;
                r1[1] = num < r1[1] ? Math.max(num, r1[0]) : r1[1];
                r1[0] = Math.min(num, r1[0]);
            } else if (r == 2) {
                c2++;
                r2[1] = num < r2[1] ? Math.max(num, r2[0]) : r2[1];
                r2[0] = Math.min(num, r2[0]);
            }
        }

        // 分为 3 种情况：s % 3 = 0; s % 3 = 1; s % 3 = 2
        int r = sum % 3;
        if (r == 1) {
            // s % 3 = 1
            int sum1 = c1 > 0 ? sum - r1[0] : 0;
            int sum2 = c2 > 1 ? sum - r2[0] - r2[1] : 0;
            sum = Math.max(sum1, sum2);
        } else if (r == 2) {
            // s % 3 = 2
            int sum1 = c1 > 1 ? sum - r1[0] - r1[1] : 0;
            int sum2 = c2 > 0 ? sum - r2[0] : 0;
            sum = Math.max(sum1, sum2);
        }
        return sum;
    }

}

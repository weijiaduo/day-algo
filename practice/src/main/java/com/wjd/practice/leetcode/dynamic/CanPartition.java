package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.TestCase;

/**
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * <p>
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * 相关问题：
 * <p>
 * 698. 划分为k个相等的子集
 *
 * @author weijiaduo
 * @since 2023/7/5
 */
public class CanPartition {

    /**
     * 思路，回溯，分割成 2 部分相等的集合
     * <p>
     * 等价于求，部分数字加起来等于数字总和的一半
     * <p>
     * 可通过回溯法来枚举所有情况
     * <p>
     * 每个数字可以选，或者不选
     * <p>
     * 利用递归来实现回溯
     * <p>
     * 复杂度：时间 O(2^n) 空间 O(n)
     * <p>
     * Time Limit Exceeded
     */
    @TestCase(input = {"[1,5,11,5]", "[1,2,3,5]", "[1,2,5]", "[2,2,3,5]"},
            output = {"true", "false", "false", "false"})
    private boolean dfs(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }

        return dfs(nums, n - 1, target);
    }

    private boolean dfs(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index < 0 || target < 0) {
            return false;
        }
        // 选或者不选
        return dfs(nums, index - 1, target - nums[index])
                || dfs(nums, index - 1, target);
    }

    /**
     * 思路：记忆化搜索，回溯递归可能会有重复的子问题
     * <p>
     * 可以对重复子问题进行缓存
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:10 ms,击败了99.75% 的Java用户
     * 内存消耗:55.4 MB,击败了8.23% 的Java用户
     */
    @TestCase(input = {"[1,5,11,5]", "[1,2,3,5]", "[1,2,5]", "[2,2,3,5]"},
            output = {"true", "false", "false", "false"})
    private boolean memo(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }

        int[][] cache = new int[nums.length][target + 1];
        return memo(nums, n - 1, target, cache);
    }

    private boolean memo(int[] nums, int index, int target, int[][] cache) {
        if (target == 0) {
            return true;
        }
        if (index < 0 || target < 0) {
            return false;
        }
        if (cache[index][target] != 0) {
            return cache[index][target] == 1;
        }
        // 选或者不选
        boolean ans = memo(nums, index - 1, target - nums[index], cache)
                || memo(nums, index - 1, target, cache);
        cache[index][target] = ans ? 1 : -1;
        return ans;
    }

    /**
     * 思路：动态规划，将从上往下的记忆化搜索，转成从下往上的动态规划
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:42 ms,击败了21.58% 的Java用户
     * 内存消耗:44 MB,击败了28.43% 的Java用户
     */
    @TestCase(input = {"[1,5,11,5]", "[1,2,3,5]", "[1,2,5]", "[2,2,3,5]"},
            output = {"true", "false", "false", "false"})
    private boolean dynamic2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }

        // 状态定义
        // dp[i][j] 表示在 [0, i] 区间内和为 j 的组合是否存在
        boolean[][] dp = new boolean[n][target + 1];
        // 初始化状态
        for (boolean[] d : dp) {
            d[0] = true;
        }
        dp[0][nums[0]] = true;
        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] > j) {
                    // 不选当前数字
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选或者不选当前数字
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][target];
    }

    /**
     * 思路：动态规划，滚动数组
     * <p>
     * 动态规划只与上一轮计算有关，可保留一维数组空间
     * <p>
     * 复杂度：时间 O(m*n) 空间 O(m)
     * <p>
     * 执行耗时:25 ms,击败了68.50% 的Java用户
     * 内存消耗:39.6 MB,击败了99.01% 的Java用户
     */
    @TestCase(input = {"[1,5,11,5]", "[1,2,3,5]", "[1,2,5]", "[2,2,3,5]"},
            output = {"true", "false", "false", "false"})
    private boolean dynamic1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }

        // 状态定义
        // dp[i] 表示和为 i 的数字组合是否存在
        boolean[] dp = new boolean[target + 1];
        // 初始化状态
        dp[nums[0]] = true;
        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}

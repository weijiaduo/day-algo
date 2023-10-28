package com.wjd.practice.leetcode.greedy;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 45.跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * <p>
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * <p>
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 * @since 2022/5/28
 */
public class JumpToEnd {

    /**
     * 暴力递归法
     * <p>
     * 思路：直接按照题目，暴力递归所有情况
     * <p>
     * 复杂度：时间 O(n!) 空间 O(n)
     * <p>
     * 不用提交，都知道肯定超时~~
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int dfsJump(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        int minStep = nums.length - 1 - index;
        for (int i = 1; i <= nums[index]; i++) {
            int step = dfs(nums, index + i);
            minStep = Math.min(step + 1, minStep);
        }
        return minStep;
    }

    /**
     * 缓存递归法
     * <p>
     * 思路：从左至右，逐个递归，缓存中间值
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 哈哈哈哈，这战绩太真实了~~~
     * <p>
     * 执行耗时:811 ms,击败了5.06% 的Java用户
     * 内存消耗:47.4 MB,击败了5.06% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int cacheJump(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        return cacheDfs(nums, 0, cache);
    }

    private int cacheDfs(int[] nums, int index, Map<Integer, Integer> cache) {
        if (index >= nums.length - 1) {
            return 0;
        }
        if (cache == null) {
            cache = new HashMap<>(nums.length);
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        int minStep = nums.length - 1 - index;
        for (int i = 1; i <= nums[index]; i++) {
            int step = cacheDfs(nums, index + i, cache);
            minStep = Math.min(step + 1, minStep);
        }
        cache.put(index, minStep);
        return minStep;
    }

    /**
     * 动态规划法
     * <p>
     * 思路：从左至右，动态计算下一个位置的最大步数
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:215 ms,击败了7.94% 的Java用户
     * 内存消耗:41.7 MB,击败了67.41% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int dynamicJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int minStep = i;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    minStep = Math.min(dp[j] + 1, minStep);
                }
            }
            dp[i] = minStep;
        }
        return dp[n - 1];
    }

    /**
     * 动态规划法
     * <p>
     * 思路：从左至右，动态计算下一个位置的最大步数，但是不需要遍历左边所有的位置
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:73 ms,击败了11.49% 的Java用户
     * 内存消耗:41.4 MB,击败了92.52% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int dynamicJump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int prevMaxStep = 0;
        for (int i = 0; i < n; i++) {
            int minStep = i;
            int minIndex = Math.max(0, i - prevMaxStep);
            for (int j = i - 1; j >= minIndex; j--) {
                if (j + nums[j] >= i) {
                    minStep = Math.min(dp[j] + 1, minStep);
                }
            }
            dp[i] = minStep;
            prevMaxStep = Math.max(prevMaxStep, nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 动态规划法
     * <p>
     * 思路：从左至右，动态计算可达位置的最小步数
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:49 ms,击败了13.52% 的Java用户
     * 内存消耗:41.5 MB,击败了83.83% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int dynamicJump3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) {
                    break;
                }
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }
        return dp[n - 1];
    }

    /**
     * 贪心算法
     * <p>
     * 思路：每次都选择可以走得最远的位置
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 这不是官方解法吗，怎么还是这么低~~
     * <p>
     * 执行耗时:2 ms,击败了43.25% 的Java用户
     * 内存消耗:41.7 MB,击败了58.98% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int maxJump(int[] nums) {
        int steps = 0;
        int nowEnd = 0, nextEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 下次可达的最远距离
            nextEnd = Math.max(i + nums[i], nextEnd);
            if (nextEnd >= nums.length - 1) {
                // 已经可以跳到最后位置了
                steps++;
                break;
            }
            if (i == nowEnd) {
                // 抵达当前的边界
                nowEnd = nextEnd;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 贪心算法
     * <p>
     * 思路：每次都选择可以走得最远的位置
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 恕我直言，这数组长度 nums.length 的读取也太废时间了吧！！！
     * <p>
     * 执行耗时:1 ms,击败了99.04% 的Java用户
     * 内存消耗:42 MB,击败了30.77% 的Java用户
     */
    @TestCase(input = {"[2,3,1,1,4]", "[2,3,0,1,4]"},
            output = {"2", "2"})
    private int maxJump2(int[] nums) {
        int steps = 0;
        int nowEnd = 0, nextEnd = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            // 下次可达的最远距离
            nextEnd = Math.max(i + nums[i], nextEnd);
            if (nextEnd >= n - 1) {
                // 已经可以跳到最后位置了，直接跳
                steps++;
                break;
            }
            if (i == nowEnd) {
                // 抵达当前的边界，更新到下个边界
                nowEnd = nextEnd;
                steps++;
            }
        }
        return steps;
    }

}

package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 45.跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * @since 2022/5/28
 */
public class JumpToEnd implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {2,3,0,1,4};
        int result = jump(nums);
        System.out.println(result);
        return result;
    }

    public int jump(int[] nums) {
        return maxJump2(nums);
    }

    /**
     * 暴力递归法
     *
     * 思路：直接按照题目，暴力递归所有情况
     *
     * 不用提交，都知道肯定超时~~
     */
    private int deepJump(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        System.out.println("index = " + index);
        int minStep = nums.length - 1 - index;
        for (int i = 1; i <= nums[index]; i++) {
            int step = deepJump(nums, index + i);
            minStep = Math.min(step + 1, minStep);
        }
        return minStep;
    }

    /**
     * 缓存递归法
     *
     * 思路：从左至右，逐个递归，缓存中间值
     *
     * 哈哈哈哈，这战绩太真实了~~~
     *
     * 执行耗时:811 ms,击败了5.06% 的Java用户
     * 内存消耗:47.4 MB,击败了5.06% 的Java用户
     */
    private int cacheDeepJump(int[] nums, int index, Map<Integer, Integer> cache) {
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
            int step = cacheDeepJump(nums, index + i, cache);
            minStep = Math.min(step + 1, minStep);
        }
        cache.put(index, minStep);
        return minStep;
    }

    /**
     * 动态规划法
     *
     * 思路：从左至右，动态计算下一个位置的最大步数
     *
     * 执行耗时:215 ms,击败了7.94% 的Java用户
     * 内存消耗:41.7 MB,击败了67.41% 的Java用户
     */
    private int dynamicJump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int minStep = i;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    minStep = Math.min(dp[j] + 1, minStep);
                }
            }
            dp[i] = minStep;
        }
        return dp[nums.length - 1];
    }

    /**
     * 动态规划法
     *
     * 思路：从左至右，动态计算下一个位置的最大步数，但是不需要遍历左边所有的位置
     *
     * 执行耗时:73 ms,击败了11.49% 的Java用户
     * 内存消耗:41.4 MB,击败了92.52% 的Java用户
     */
    private int dynamicJump2(int[] nums) {
        int[] dp = new int[nums.length];
        int prevMaxStep = 0;
        for (int i = 0; i < nums.length; i++) {
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
        return dp[nums.length - 1];
    }

    /**
     * 动态规划法
     *
     * 思路：从左至右，动态计算可达位置的最小步数
     *
     * 执行耗时:49 ms,击败了13.52% 的Java用户
     * 内存消耗:41.5 MB,击败了83.83% 的Java用户
     */
    private int dynamicJump3(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length) {
                    break;
                }
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 贪心算法
     *
     * 思路：每次都选择可以走得最远的位置
     *
     * 这不是官方解法吗，怎么还是这么低~~
     *
     * 执行耗时:2 ms,击败了43.25% 的Java用户
     * 内存消耗:41.7 MB,击败了58.98% 的Java用户
     */
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
     *
     * 思路：每次都选择可以走得最远的位置
     *
     * 恕我直言，这数组长度 nums.length 的读取也太废时间了吧！！！
     *
     * 执行耗时:1 ms,击败了99.04% 的Java用户
     * 内存消耗:42 MB,击败了30.77% 的Java用户
     */
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

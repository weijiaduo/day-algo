package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * <p>
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @author weijiaduo
 * @since 2022/9/9
 */
public class MaxEnvelopes implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        int result = maxEnvelopes(envelopes);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：先按宽度从小到大，高度从大到小排序，然后找出高度序列的最长递增子序列
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:46 ms,击败了40.23% 的Java用户
     * 内存消耗:84.8 MB,击败了28.34% 的Java用户
     */
    private int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        // 宽度升序，高度降序
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        // 获取高度数组
        int n = envelopes.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }

        // 找到高度数组的最长递增子序列
        return lengthOfLIS(heights);
    }

    /**
     * 最长递增子序列
     *
     * @param nums 递增数组
     * @return 最长长度
     */
    private int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // 状态定义
        // dp[i] 表示长度为i+1的子序列的最后一个元素
        int[] dp = new int[n];

        // 状态转移
        // 遍历所有 dp，找到第一个满足 dp[j] >= nums[i] 的位置
        // 替换 dp[j] = nums[i]，表示长度j+1的子序列的最小值变小了
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

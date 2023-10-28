package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -1000 <= nums[i] <= 1000
 * -10⁷ <= k <= 10⁷
 *
 * @author weijiaduo
 * @since 2023/6/7
 */
public class SubarraySum {

    /**
     * 官方解答
     * <p>
     * 思路：暴力枚举，定好每个起点 l，然后遍历每个终点 r，同时统计 sum
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:1688 ms,击败了21.46% 的Java用户
     * 内存消耗:43.8 MB,击败了87.76% 的Java用户
     */
    @TestCase(input = {"[1,1,1]", "2", "[1,2,3]", "3"},
            output = {"2", "2"})
    public int brute(int[] nums, int k) {
        int cnt = 0;
        int n = nums.length;
        for (int l = 0; l < n; l++) {
            int sum = 0;
            for (int r = l; r < n; r++) {
                sum += nums[r];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 官方解答
     * <p>
     * 思路：记录前缀和 pre[r]，sum[l, r] 可由 pre[r] - pre[j] 得到
     * <p>
     * 求 pre[r] - pre[l] = k，等价于求 pre[l] = pre[r] - k
     * <p>
     * 只要遍历到 r 时，然后在前面找到前缀和为 pre[r] - k 的 pre[l]
     * <p>
     * 使用哈希统计，以 pre[l] 为键，频率为值，就能快速得到满足要求的 l 的个数
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:24 ms,击败了53.86% 的Java用户
     * 内存消耗:45.5 MB,击败了31.13% 的Java用户
     */
    @TestCase(input = {"[1,1,1]", "2", "[1,2,3]", "3"},
            output = {"2", "2"})
    public int prefix(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        for (int num : nums) {
            pre += num;
            cnt += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }

}

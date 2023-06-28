package com.wjd.practice.leetcode.array.combination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2475. 数组中不等三元组的数目
 * <p>
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * <p>
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * <p>
 * 返回满足上述条件三元组的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 *
 * @author weijiaduo
 * @since 2023/6/13
 */
public class UnequalTriplets {

    public int unequalTriplets(int[] nums) {
        return hash(nums);
    }

    /**
     * 思路：暴力，直接 3 层循环检查
     * <p>
     * 复杂度：时间 O(n^3) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了53.02% 的Java用户
     * 内存消耗:39.1 MB,击败了77.16% 的Java用户
     */
    public int brute(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] != nums[k] && nums[i] != nums[k]) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * 官方题解
     * <p>
     * 思路：排序，相同元素值都汇集在一起
     * <p>
     * 对于一段区间 [l, r) 内的相同元素而已，以它为 3 个元素的中间
     * <p>
     * 则组合的情况有：l * (r - l) * (n - r) 种
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了98.28% 的Java用户
     * 内存消耗:39.2 MB,击败了56.90% 的Java用户
     */
    private int sort(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = 1;
        while (r < n) {
            while (r < n && nums[r] == nums[r - 1]) {
                r++;
            }
            cnt += l * (r - l) * (n - r);
            l = r++;
        }
        return cnt;
    }

    /**
     * 官方题解
     * <p>
     * 思路：使用 map 记录数字的词频，然后还是按照：
     * <p>
     * l * (r - l) * (n - r)
     * <p>
     * 的方式来计算组合数量。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了69.83% 的Java用户
     * 内存消耗:39.1 MB,击败了72.85% 的Java用户
     */
    private int hash(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }
        int cnt = 0, i = 0, n = nums.length;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            cnt += i * entry.getValue() * (n - i - entry.getValue());
            i += entry.getValue();
        }
        return cnt;
    }

}

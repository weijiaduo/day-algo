package com.wjd.practice.leetcode.array.combination;

import java.util.HashSet;
import java.util.Set;

/**
 * 2367. 算术三元组的数目
 * <p>
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。
 * <p>
 * 如果满足下述全部条件，则三元组 (i, j, k) 就是一个算术三元组：
 * <p>
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * <p>
 * 返回不同 算术三元组 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 *
 * @author weijiaduo
 * @since 2023/3/31
 */
public class ArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        return hash(nums, diff);
    }

    /**
     * 思路：直接三重循环遍历
     * <p>
     * 复杂度：时间 O(n^3) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了81.65% 的Java用户
     * 内存消耗:39.2 MB,击败了80.04% 的Java用户
     *
     * @param nums 数组
     * @param diff 差值
     * @return 算术三元组的个数
     */
    private int bf(int[] nums, int diff) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int diff1 = nums[j] - nums[i];
                if (diff1 < diff) {
                    continue;
                }
                if (diff1 > diff) {
                    break;
                }
                for (int k = j + 1; k < n; k++) {
                    int diff2 = nums[k] - nums[j];
                    if (diff2 < diff) {
                        continue;
                    }
                    if (diff2 > diff) {
                        break;
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 思路：哈希法，求 num - diff 和 num - 2 * diff 是否存在
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了81.65% 的Java用户
     * 内存消耗:39.6 MB,击败了30.85% 的Java用户
     *
     * @param nums 数组
     * @param diff 差值
     * @return 算术三元组的个数
     */
    private int hash(int[] nums, int diff) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - diff)
                    && set.contains(num - 2 * diff)) {
                cnt++;
            }
            set.add(num);
        }
        return cnt;
    }

}

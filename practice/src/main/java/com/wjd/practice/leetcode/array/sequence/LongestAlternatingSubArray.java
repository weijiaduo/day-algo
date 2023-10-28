package com.wjd.practice.leetcode.array.sequence;

import com.wjd.practice.TestCase;

/**
 * 周赛 352
 * <p>
 * 6909. 最长奇偶子数组
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
 * <p>
 * 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
 * <p>
 * nums[l] % 2 == 0
 * 对于范围[l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
 * 对于范围[l, r] 内的所有下标 i ，nums[i] <= threshold
 * 以整数形式返回满足题目要求的最长子数组的长度。
 * <p>
 * 注意：子数组 是数组中的一个连续非空元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,5,4], threshold = 5
 * 输出：3
 * 解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], threshold = 2
 * 输出：1
 * 解释：
 * 在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 => [2] 。
 * 该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
 * 示例 3：
 * <p>
 * 输入：nums = [2,3,4,5], threshold = 4
 * 输出：3
 * 解释：
 * 在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 => [2,3,4] 。
 * 该子数组满足上述全部条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= threshold <= 100
 *
 * @author weijiaduo
 * @since 2023/7/2
 */
public class LongestAlternatingSubArray {

    /**
     * 思路：暴力法，直接遍历以 i 开头的满足条件的子数组
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    @TestCase(input = {"[3,2,5,4]", "5", "[1,2]", "2", "[2,3,4,5]", "4"},
            output = {"3", "1", "3"})
    public int longestAlternatingSubArray(int[] nums, int threshold) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }
            int j = i + 1;
            for (; j < n; j++) {
                if (nums[j] > threshold || nums[j] % 2 == nums[j - 1] % 2) {
                    break;
                }
            }
            ans = Math.max(ans, j - i);
            i = j - 1;
        }
        return ans;
    }

}

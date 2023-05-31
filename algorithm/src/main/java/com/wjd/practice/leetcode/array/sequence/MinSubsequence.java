package com.wjd.practice.leetcode.array.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * <p>
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * <p>
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 * <p>
 * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 * <p>
 * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 * <p>
 * 输入：nums = [4,4,7,6,7]
 * 输出：[7,7,6]
 * 解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，
 * 元素按非递增顺序返回。
 *
 * @author weijiaduo
 * @since 2022/8/4
 */
public class MinSubsequence {

    /**
     * 思路：实际要求是数组的一半数据要大于另一半数据，只需要对数组排序，然后按从大到小的顺序统计数值和，
     * 当数值和超过数组总和的一半时，就是最小的子序列
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了95.47% 的Java用户
     * 内存消耗:42.1 MB,击败了5.10% 的Java用户
     *
     * @param nums 数组
     * @return 最小子序列
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int other = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            other += nums[i];
            sum -= nums[i];
            ans.add(nums[i]);
            if (sum < other) {
                break;
            }
        }
        return ans;
    }

}

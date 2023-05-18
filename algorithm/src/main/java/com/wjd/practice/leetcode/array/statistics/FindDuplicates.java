package com.wjd.practice.leetcode.array.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * <p>
 * 请你找出所有出现 两次的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[]
 *
 * @author weijiaduo
 * @since 2023/5/19
 */
public class FindDuplicates {

    /**
     * 思路：给索引 nums[i] - 1 的值加上 n，使其大于 n
     * <p>
     * 如果只出现1次，那么值范围应该是 (n, 2n]
     * <p>
     * 如果出现了2次，那么值范围应该是 (2n, 3n]
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:51.8 MB,击败了10.33% 的Java用户
     *
     * @param nums 数组
     * @return 出现2次的数字
     */
    private List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int i = (num - 1) % n;
            nums[i] += n;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 思路：将索引对应的数字 nums[nums[i]-1] 取反变成负数
     * <p>
     * 下次再遇到，如果是 nums[nums[i]-1] 负数，说明 nums[i] - 1 之前出现过了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了80.51% 的Java用户
     * 内存消耗:52.3 MB,击败了5.05% 的Java用户
     *
     * @param nums 数组
     * @return 出现2次的数字
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = Math.abs(nums[i]) - 1;
            if (nums[t] < 0) {
                result.add(t + 1);
            } else {
                nums[t] = -nums[t];
            }
        }
        return result;
    }

}

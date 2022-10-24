package com.wjd.practice.leetcode.array;

/**
 * 915. 分隔数组
 * <p>
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * <p>
 * 在完成这样的分组后返回 left 的 长度 。
 * <p>
 * 用例可以保证存在这样的划分方法。
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 *
 * @author weijiaduo
 * @since 2022/10/24
 */
public class PartitionDisjoint {

    /**
     * 思路：分别记录左数组最大值和右数组最大值
     * <p>
     * 如果当前元素小于左数组最大值，说明当前元素属于左数组，同时更新左数组最大值为右数组最大值
     * <p>
     * 反之，一直更新右数组的最大值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:50.6 MB,击败了71.91% 的Java用户
     */
    public int solve(int[] nums) {
        int index = 0, n = nums.length;
        int leftMax = nums[0], rightMax = leftMax;
        for (int i = 1; i < n; i++) {
            if (nums[i] < leftMax) {
                // 当前元素属于左数组，同时更新左边最大值
                index = i;
                leftMax = rightMax;
            } else {
                // 已遍历序列的最大值
                rightMax = Math.max(nums[i], rightMax);
            }
        }
        return index + 1;
    }

}

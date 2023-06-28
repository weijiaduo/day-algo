package com.wjd.practice.leetcode.array.traversal;

/**
 * 485. 最大连续 1 的个数
 * <p>
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 不是 0 就是 1.
 *
 * @author weijiaduo
 * @since 2023/5/16
 */
public class FindMaxConsecutiveOnes {

    /**
     * 思路：直接遍历，用一个变量记住连续1的个数即可
     * <p>
     * 复杂度：时间 O(n) 空间O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:43.5 MB,击败了5.05% 的Java用户
     *
     * @param nums 数组
     * @return 连续1的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0, cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                ret = Math.max(ret, cnt);
                cnt = 0;
            }
        }
        return Math.max(ret, cnt);
    }

}

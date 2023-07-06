package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.leetcode.TestCase;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * <p>
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @since 2021-05-29
 */
public class MajorityElement {

    /**
     * 思路：Boyer-Moore 投票法，相同值+1，不同值-1
     * <p>
     * 因为有一半元素以上是同一个值，所以最终投票结果肯定是超过半数的那个元素
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.59% 的Java用户
     * 内存消耗:47.7 MB,击败了18.42% 的Java用户
     */
    @TestCase(input = {"[3,2,3]", "[2,2,1,1,1,2,2]"},
            output = {"3", "2"})
    public int boyerMoore(int[] nums) {
        int x = nums[0];
        int n = nums.length, count = 1;
        for (int i = 1; i < n; i++) {
            if (count == 0) {
                x = nums[i];
            }
            if (x == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return x;
    }

}

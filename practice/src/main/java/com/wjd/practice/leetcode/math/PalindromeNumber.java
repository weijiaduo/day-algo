package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 9. 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 提示：
 * <p>
 * -2³¹ <= x <= 2³¹ - 1
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * @author weijiaduo
 * @since 2023/11/13
 */
public class PalindromeNumber {

    /**
     * 思路：反转一半的数字，组成另一个数值
     * <p>
     * 和前半部分的数值对比，如果相等，则是回文数，反之不是
     * <p>
     * 复杂度：时间 O(k) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了98.26% 的Java用户
     * 内存消耗:41.7 MB,击败了26.07% 的Java用户
     */
    @TestCase(input = {"121", "-121", "10", "1221", "0"},
            output = {"true", "false", "false", "true", "true"})
    public boolean isPalindrome(int x) {
        // 0 是回文数
        if (x == 0) {
            return true;
        }
        // 负数或以 0 结尾的都不是回文数
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int y = 0;
        while (y < x) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        // 偶数位回文/奇数位回文
        return x == y || (x == y / 10);
    }

}

package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 7. 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * -2³¹ <= x <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2024/1/17
 */
public class ReverseNumber {

    /**
     * 思路：取余再乘
     * <p>
     * 对原始数字每次取余最低位，然后乘到新数字上
     * <p>
     * 假如新数字添加新的位之后溢出，那就返回  0
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了46.44% 的Java用户
     * 内存消耗:39.7 MB,击败了21.01% 的Java用户
     */
    @TestCase(input = {"123", "-123", "120", "0", "2147483647", "-2147483648"},
            output = {"321", "-321", "21", "0", "0", "0"})
    public int reverse(int num) {
        int ans = 0;
        int max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
        while (num != 0) {
            if (ans > max || ans < min) {
                return 0;
            }
            int r = num % 10;
            num /= 10;
            ans = ans * 10 + r;
        }
        return ans;
    }

}

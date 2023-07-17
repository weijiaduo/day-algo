package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.TestCase;

/**
 * 415. 字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * <p>
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 10⁴
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * @author weijiaduo
 * @since 2023/7/17
 */
public class AddStrings {

    /**
     * 思路：直接模拟相加即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.5 MB,击败了77.46% 的Java用户
     */
    @TestCase(input = {"11", "123", "456", "77", "0", "0"},
            output = {"134", "533", "0"})
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length(), n = num2.length();
        int i = m - 1, j = n - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;

            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);

            i--;
            j--;
        }
        return sb.reverse().toString();
    }

}

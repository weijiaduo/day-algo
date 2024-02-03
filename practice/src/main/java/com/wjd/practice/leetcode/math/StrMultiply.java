package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 *
 * @since 2022/5/22
 */
public class StrMultiply {

    /**
     * 暴力法
     * <p>
     * 思路：按照普通的乘法规则，把每个数字乘以另一个数字的乘积加起来
     * <p>
     * 复杂度：时间 O(mn) 空间 O(max(n,m))
     * <p>
     * 执行耗时:11 ms,击败了39.03% 的Java用户
     * 内存消耗:41.2 MB,击败了59.84% 的Java用户
     */
    @TestCase(input = {"2", "3", "123", "456", "9999", "0"},
            output = {"6", "56088", "0"})
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }

        String ans = "";
        int n1 = num1.length(), n2 = num2.length();
        for (int i = n1 - 1, j = n2 - 1; j >= 0; j--) {
            String s = multiply(num1, num2.charAt(j));
            ans = add(ans, s, n2 - j - 1);
        }
        return ans;
    }

    private String multiply(String s, char ch) {
        StringBuilder sb = new StringBuilder();
        int x = ch - '0';
        int i = s.length() - 1, carry = 0;
        while (i >= 0 || carry > 0) {
            int a = i >= 0 ? s.charAt(i) - '0' : 0;
            int c = a * x + carry;
            sb.append(c % 10);
            carry = c / 10;
            i--;
        }
        return sb.reverse().toString();
    }

    private String add(String s1, String s2, int offset) {
        StringBuilder sb = new StringBuilder();
        int n1 = s1.length(), n2 = s2.length();
        for (int i = 1; i <= offset && n1 - i >= 0; i++) {
            sb.append(s1.charAt(n1 - i));
        }

        int i = n1 - 1 - offset, j = n2 - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? s1.charAt(i) - '0' : 0;
            int b = j >= 0 ? s2.charAt(j) - '0' : 0;
            carry = a + b + carry;
            sb.append(carry % 10);
            carry /= 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    /**
     * 思路：改用数组执行乘法，避免执行字符串操作
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了87.95% 的Java用户
     */
    @TestCase(input = {"2", "3", "123", "456", "9999", "0"},
            output = {"6", "56088", "0"})
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 乘法累加
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                ans[i + j + 1] += n1 * n2;
            }
        }

        // 乘法进位
        for (int i = m + n - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] = ans[i] % 10;
        }

        // 转成字符串
        StringBuilder sb = new StringBuilder(m + n);
        int i = ans[0] == 0 ? 1 : 0;
        for (; i < m + n; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }

}

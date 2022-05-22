package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * @since 2022/5/22
 */
public class StrMultiply implements Solution<String> {

    @Override
    public String solve(Object args) {
        String num1 = "123";
        String num2 = "456";
        String result = multiply(num1, num2);
        String result2 = multiply2(num1, num2);
        System.out.println(result);
        System.out.println(result2);
        return result;
    }

    /**
     * 暴力法
     *
     * 思路：按照普通的乘法规则，把每个数字乘以另一个数字的乘积加起来
     *
     * 执行耗时:11 ms,击败了39.03% 的Java用户
     * 内存消耗:41.2 MB,击败了59.84% 的Java用户
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String min, max;
        if (num1.length() < num2.length()) {
            min = num1;
            max = num2;
        } else {
            min = num2;
            max = num1;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder zeros = new StringBuilder();
        for (int i = min.length() - 1; i >= 0 ; i--) {
            int num = min.charAt(i) - '0';
            String mulStr = mul(max, num);
            mulStr = zeros + mulStr;
            add(result, mulStr);
            zeros.append('0');
        }
        return result.reverse().toString();
    }

    private String mul(String num, int k) {
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0 ; i--) {
            int n = num.charAt(i) - '0';
            int m = n * k + c;
            c = m / 10;
            m = m % 10;
            sb.append(m);
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void add(StringBuilder num1, String num2) {
        int c = 0;
        for (int i = 0; i < num2.length(); i++) {
            int n2 = num2.charAt(i) - '0';
            int n1 = 0;
            if (num1.length() > i) {
                n1 = num1.charAt(i) - '0';
            }
            int sum = n1 + n2 + c;
            c = sum / 10;
            sum = sum % 10;
            if (i >= num1.length()) {
                num1.append(sum);
            } else {
                num1.setCharAt(i, (char)(sum + '0'));
            }
        }
        if(c != 0) {
            num1.append(c);
        }
    }

    /**
     * 思路：改用数组执行乘法，避免执行字符串操作
     *
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:40.1 MB,击败了87.95% 的Java用户
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 乘法累加
        int[] ansArr = new int[num1.length() + num2.length()];
        int m = num1.length(), n = num2.length();
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                ansArr[i + j + 1] += n1 * n2;
            }
        }

        // 乘法进位
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] = ansArr[i] % 10;
        }

        StringBuilder result = new StringBuilder(m + n);
        int i = ansArr[0] == 0 ? 1 : 0;
        for (; i < m + n; i++) {
            result.append(ansArr[i]);
        }
        return result.toString();
    }

}

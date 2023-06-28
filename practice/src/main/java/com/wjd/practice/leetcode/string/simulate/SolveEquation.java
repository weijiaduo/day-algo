package com.wjd.practice.leetcode.string.simulate;

/**
 * 640. 求解方程
 * <p>
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。
 * <p>
 * 该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * <p>
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 *
 * @author weijiaduo
 * @since 2022/8/10
 */
public class SolveEquation {

    /**
     * 思路：把x移到=号左边，数值移到=号右边，最后计算结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了85.34% 的Java用户
     * 内存消耗:39.8 MB,击败了37.93% 的Java用户
     *
     * @param equation 方程
     * @return 方程解
     */
    private String solveEquation1(String equation) {
        int n = equation.length();
        int left = 0, right = 0;
        int sign = 1;
        for (int i = 0; i < n; ) {
            if (equation.charAt(i) == '=') {
                i++;
                sign = -1;
                continue;
            }

            int j = i + 1;
            for (; j < n; j++) {
                char ch = equation.charAt(j);
                if (ch == '+' || ch == '-' || ch == '=') {
                    break;
                }
            }
            int number = parseInt(equation.substring(i, j));
            if (equation.charAt(j - 1) == 'x') {
                left += sign * number;
            } else {
                right -= sign * number;
            }
            i = j;
        }

        if (left != 0) {
            if (right % left == 0) {
                return "x=" + (right / left);
            } else {
                return "No solution";
            }
        } else {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
    }

    /**
     * 思路：把-替换成+-，然后用+拆分各部分系数
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:8 ms,击败了26.72% 的Java用户
     * 内存消耗:39.7 MB,击败了49.57% 的Java用户
     *
     * @param equation 方程
     * @return 方程解
     */
    private String solveEquation(String equation) {
        int left = 0, right = 0, sign = 1;
        String[] expressions = equation.split("=");
        for (String expression : expressions) {
            expression = expression.replaceAll("-", "+-");
            String[] numStrs = expression.split("[+]");
            for (String numStr : numStrs) {
                if (numStr.isEmpty()) {
                    continue;
                }
                int number = parseInt(numStr);
                if (numStr.charAt(numStr.length() - 1) == 'x') {
                    left += sign * number;
                } else {
                    right -= sign * number;
                }
            }
            sign = -sign;
        }

        if (left != 0) {
            if (right % left == 0) {
                return "x=" + (right / left);
            } else {
                return "No solution";
            }
        } else {
            if (right == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
    }

    /**
     * 解析系数
     *
     * @param s 代数表达式
     * @return 系数
     */
    private int parseInt(String s) {
        int n = s.length();
        char signChar = s.charAt(0);
        int sign = signChar == '-' ? -1 : signChar == '+' ? 1 : 0;
        int i = Math.abs(sign), j = i;
        while (j < n && Character.isDigit(s.charAt(j))) {
            j++;
        }
        if (j == i) {
            // 没有系数，只有符号或x
            return sign != 0 ? sign : 1;
        }
        return Integer.parseInt(s.substring(0, j));
    }

}

package com.wjd.practice.leetcode.string.simulate;

/**
 * 592. 分数加减运算
 * <p>
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 * <p>
 * 这个结果应该是不可约分的分数，即最简分数。
 * <p>
 * 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。
 * <p>
 * 所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 * 输入:expression= "-1/2+1/2"
 * 输出: "0/1"
 *
 * @author weijiaduo
 * @since 2022/7/27
 */
public class FractionAddition {

    /**
     * 思路：只有加减运算，没有优先级，所以直接遍历一遍，解析分数直接运算即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了83.17% 的Java用户
     * 内存消耗:40.3 MB,击败了17.31% 的Java用户
     *
     * @param expression 计算表达式
     * @return 计算结果
     */
    private String fractionAddition(String expression) {
        int denominator = 0, numerator = 1;
        int len = expression.length();
        for (int i = 0, j; i < len; i = j) {
            j = i + 1;
            while (j < len) {
                char ch = expression.charAt(j);
                if (ch == '-' || ch == '+') {
                    break;
                }
                j++;
            }

            // 解析分数的分子分母
            String numStr = expression.substring(i, j);
            String[] nums = numStr.split("/");
            int d = Integer.parseInt(nums[0]);
            int n = Integer.parseInt(nums[1]);

            // 分数加减运算
            denominator = denominator * n + d * numerator;
            numerator = numerator * n;

            // 简化分子分母
            int g = gcd(Math.abs(denominator), numerator);
            denominator /= g;
            numerator /= g;
        }
        return denominator + "/" + numerator;
    }

    /**
     * 最大公约数
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}

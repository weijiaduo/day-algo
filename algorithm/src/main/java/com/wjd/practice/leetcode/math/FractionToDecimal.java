package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * <p>
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个
 * <p>
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class FractionToDecimal implements Solution<String> {

    @Override
    public String solve(Object... args) {
        int numerator = -50;
        int denominator = 8;
        String result = fractionToDecimal(numerator, denominator);
        System.out.println(result);
        return result;
    }

    /**
     * 思路倒是没错，就是细节太多了，想不完整
     * <p>
     * 思路：按照正常触发计算，分别计算符号、整数、小数3部分，用哈希表记录小数部分的被除数，重复则循环
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了17.68% 的Java用户
     */
    private String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        // 符号部分
        long dividend = numerator, divisor = denominator;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sb.append('-');
            dividend = dividend > 0 ? -dividend : dividend;
            divisor = divisor > 0 ? -divisor : divisor;
        }

        // 整数部分
        long quotient = dividend / divisor;
        sb.append(quotient);

        // 小数部分，必须用 long 类型才行，否则会溢出
        dividend = (dividend - divisor * quotient) * 10;
        if (dividend != 0) {
            sb.append('.');
        }
        Map<Long, Integer> numMap = new HashMap<>();
        while (dividend != 0 && sb.length() <= 10000) {
            Integer index = numMap.get(dividend);
            if (index != null && index > -1) {
                // 被除数循环了
                sb.insert(index, "(");
                sb.append(')');
                break;
            }

            quotient = dividend / divisor;
            sb.append(quotient);
            // 记录被除数出现的索引，用于判断循环
            numMap.put(dividend, sb.length() - 1);
            dividend = (dividend - divisor * quotient) * 10;
        }
        return sb.toString();
    }

}

package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 64. 求1+2+3+...+n
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * @author weijiaduo
 * @since 2023/11/30
 */
public class ConditionSum {

    /**
     * 思路：递归 + 与运算的短路性质
     * <p>
     * 利用逻辑与的短路特性实现递归终止。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"10"}, output = {"55"})
    public int and(int n) {
        int ans = n;
        boolean a = n > 0 && (ans = ans + and(n - 1)) > 0;
        return ans;
    }

    /**
     * 思路：递归 + 异常终止递归
     * <p>
     * 利用数组越界异常终止递归。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"10"}, output = {"55"})
    public int exception(int n) {
        return sum(new int[n + 1], 1, 0);
    }

    private int sum(int[] t, int index, int sum) {
        try {
            int a = t[index];
            sum += index;
            return sum(t, index + 1, sum);
        } catch (Exception e) {
            return sum;
        }
    }

}

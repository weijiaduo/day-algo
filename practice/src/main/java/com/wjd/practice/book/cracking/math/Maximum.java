package com.wjd.practice.book.cracking.math;

import com.wjd.practice.TestCase;

/**
 * 面试题 16.07. 最大数值
 * <p>
 * 编写一个方法，找出两个数字a和b中最大的那一个。
 * <p>
 * 不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * <p>
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * @author weijiaduo
 * @since 2024/1/10
 */
public class Maximum {

    /**
     * 思路：差值
     * <p>
     * 假设 c = a-b，取出 c 的最高位 hb
     * <p>
     * 如果 c > 0，那么 c 的最高位 hb = 0
     * <p>
     * 如果 c < 0，那么 c 的最高位 hb = 1
     * <p>
     * 那么最大值等于 a * (1-hb) + b * hb
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了11.81% 的Java用户
     */
    @TestCase(input = {"1", "2", "2147483647", "-2147483648"},
            output = {"2", "2147483647"})
    public int maximum(int a, int b) {
        long c = (long) a - (long) b;
        int hb = (int) (c >>> 63) & 1;
        return a * (1 - hb) + b * hb;
    }

}

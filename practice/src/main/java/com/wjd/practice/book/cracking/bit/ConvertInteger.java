package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.06. 整数转换
 * <p>
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * <p>
 * 示例2:
 * <p>
 * 输入：A = 1，B = 2
 * 输出：2
 * <p>
 * 提示:
 * <p>
 * A，B范围在[-2147483648, 2147483647]之间
 *
 * @author weijiaduo
 * @since 2023/12/27
 */
public class ConvertInteger {

    /**
     * 思路：异或，位相同时结果为 0，不相同是结果为 1
     * <p>
     * 只要判断异或的结果有多少个 1 就行了
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了5.07% 的Java用户
     */
    @TestCase(input = {"29", "15", "1", "2"},
            output = {"2", "2"})
    public int convert(int a, int b) {
        int ans = 0;
        int c = a ^ b;
        while (c != 0) {
            // 消掉末尾 1
            c &= c - 1;
            ans++;
        }
        return ans;
    }

}

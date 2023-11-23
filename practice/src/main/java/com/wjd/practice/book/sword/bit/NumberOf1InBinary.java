package com.wjd.practice.book.sword.bit;

import com.wjd.practice.TestCase;

/**
 * 15. 二进制中1的数量
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * 例如，把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class NumberOf1InBinary {

    /**
     * 思路：位运算，每次右移一位，判断最后一位是否为1
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"9"}, output = {"2"})
    public int shift(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    /**
     * 思路：位运算，每次将最后一位1变成0，直到n为0
     * <p>
     * 复杂度：时间 O(k) 空间 O(1)
     */
    @TestCase(input = {"9"}, output = {"2"})
    public int subtract(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}

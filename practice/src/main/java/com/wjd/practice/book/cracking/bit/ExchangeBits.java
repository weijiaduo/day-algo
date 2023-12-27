package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.07. 配对交换
 * <p>
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * <p>
 * 示例2:
 * <p>
 * 输入：num = 3
 * 输出：3
 * <p>
 * 提示:
 * <p>
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 * @author weijiaduo
 * @since 2023/12/27
 */
public class ExchangeBits {

    /**
     * 思路：分别取出奇数位和偶数位的值
     * <p>
     * 然后利用移位操作再将它们合并起来
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了5.55% 的Java用户
     */
    @TestCase(input = {"2", "3"},
            output = {"1", "3"})
    public int exchange(int num) {
        int mask = 0x55555555;
        int even = num & mask;
        int odd = num & (mask << 1);
        return (even << 1) | (odd >>> 1);
    }

}

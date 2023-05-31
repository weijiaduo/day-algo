package com.wjd.practice.leetcode.bit;

/**
 * 190. 颠倒二进制位
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class ReverseBits {

    public int reverseBits(int n) {
        // return exchangeReverseBits(n);
        // return newReverseBits(n);
        return divideReverseBits(n);
    }

    /**
     * 思路：双指针法，交换2指针的bit值
     * <p>
     * 复杂度：时间 O(n/2) 空间O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.9 MB,击败了40.29% 的Java用户
     */
    private int exchangeReverseBits(int n) {
        int high = Integer.SIZE - 1, low = 0;
        while (low < high) {
            int step = high - low;
            int newHigh = (n << step) & (1 << high);
            int newLow = (n >> step) & (1 << low);
            n = n & (~(1 << high)) | newHigh;
            n = n & (~(1 << low)) | newLow;
            high--;
            low++;
        }
        return n;
    }

    /**
     * 看了官解，觉得我真是傻~~
     * <p>
     * 官解：就单纯的倒过来设置
     * <p>
     * 复杂度：时间 O(n) 空间O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.7 MB,击败了57.18% 的Java用户
     */
    private int newReverseBits(int n) {
        int rev = 0, m = Integer.SIZE;
        for (int i = 0; i < m && n != 0; i++) {
            rev |= (n & 1) << (m - 1 - i);
            n >>>= 1;
        }
        return rev;
    }

    /**
     * 官解：分治法，递归交换左右2部分，最底层是奇数位和偶数位进行交换
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了55.02% 的Java用户
     */
    public int divideReverseBits(int n) {
        // 01010101010101010101010101010101
        final int m1 = 0x55555555;
        // 00110011001100110011001100110011
        final int m2 = 0x33333333;
        // 00001111000011110000111100001111
        final int m4 = 0x0f0f0f0f;
        // 00000000111111110000000011111111
        final int m8 = 0x00ff00ff;

        n = (n >>> 1) & m1 | (n & m1) << 1;
        n = (n >>> 2) & m2 | (n & m2) << 2;
        n = (n >>> 4) & m4 | (n & m4) << 4;
        n = (n >>> 8) & m8 | (n & m8) << 8;
        return n >>> 16 | n << 16;
    }

}

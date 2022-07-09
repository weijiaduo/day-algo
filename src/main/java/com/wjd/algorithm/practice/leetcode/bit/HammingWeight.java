package com.wjd.algorithm.practice.leetcode.bit;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.BitUtil;

/**
 * 191. 位1的个数
 * <p>
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 * 输入必须是长度为 32 的 二进制串 。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class HammingWeight implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String bits = "11111111111111111111111111111101";
        int n = BitUtil.bitsToInt(bits);
        System.out.println(BitUtil.intToBits(n));
        int result = hammingWeight2(n);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：每次取最低位判断是1或0，统计数量，然后无符号右移n
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.6 MB,击败了35.80% 的Java用户
     *
     * @param n 整数
     * @return 1的个数
     */
    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    /**
     * 官解：每次翻转最后一位1变成0，翻转次数就是1的个数
     * <p>
     * 复杂度：时间 O(k) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.3 MB,击败了82.22% 的Java用户
     *
     * @param n 整数
     * @return 1的个数
     */
    private int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}

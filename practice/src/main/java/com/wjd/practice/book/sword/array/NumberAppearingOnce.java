package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 56.2 数组中唯一只出现一次的数字
 * <p>
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
 * <p>
 * 请找出那个只出现一次的数字。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class NumberAppearingOnce {

    /**
     * 思路：位运算
     * <p>
     * 一个数字出现三次，那么它的二进制表示的每一位也出现三次。
     * <p>
     * 如果把所有出现三次的数字的二进制表示的每一位都分别加起来，那么每一位的和都能被 3 整除。
     * <p>
     * 如果某一位的和能被 3 整除，那么那个只出现一次的数字二进制表示中对应的那一位是 0，否则就是 1。
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[2,2,3,2]", "[0,1,0,1,0,1,99]"},
            output = {"3", "99"})
    public int find(int[] nums) {
        int number = 0;
        int mask = 1, n = Integer.SIZE - 1;
        for (int i = 0; i < n; i++) {
            // 统计第 i 位上 1 的个数
            int sum = 0;
            for (int t : nums) {
                sum += t & mask;
            }
            // 判断是否是唯一出现的数字
            if (sum % 3 != 0) {
                number |= mask;
            }
            mask <<= 1;
        }
        return number;
    }

}

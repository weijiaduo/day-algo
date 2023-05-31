package com.wjd.practice.leetcode.bit;

/**
 * 周赛 313
 * <p>
 * 6194. 最小 XOR
 * <p>
 * 给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ：
 * <p>
 * x 的置位数和 num2 相同，且 x XOR num1 的值 最小
 * <p>
 * 注意 XOR 是按位异或运算。
 * <p>
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 * <p>
 * 整数的 置位数 是其二进制表示中 1 的数目。
 *
 * @author weijiaduo
 * @since 2022/10/2
 */
public class MinimizeXor {

    /**
     * 思路：尽可能地通过异或消去高位的1，多余的位1从低位开始摆放
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     */
    public int minimizeXor(int num1, int num2) {
        int mask = 1;

        // 统计 num2 的位 1 数量
        int n = 0;
        for (int i = 0; i < 30; i++) {
            if ((mask & num2) != 0) {
                n++;
            }
            mask <<= 1;
        }

        // 消去 num1 的高位 1
        int x = 0;
        for (int i = 0; i < 30 && n > 0; i++) {
            if ((mask & num1) != 0) {
                x |= mask;
                n--;
            }
            mask >>= 1;
        }

        // 多余的 1 放最低位
        while (n > 0) {
            // 1 不能重叠在一起
            if ((x & mask) == 0) {
                x |= mask;
                n--;
            }
            mask <<= 1;
        }

        return x;
    }

}

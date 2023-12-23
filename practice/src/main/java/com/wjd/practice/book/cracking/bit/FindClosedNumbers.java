package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.04. 下一个数
 * <p>
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * <p>
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * <p>
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 *
 * @author weijiaduo
 * @since 2023/12/23
 */
public class FindClosedNumbers {

    /**
     * 思路：位运算
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了5.22% 的Java用户
     */
    @TestCase(input = {"2", "1", "2147483647", "67", "34", "124"},
            output = {"[4,1]", "[2,-1]", "[-1,-1]", "[69,56]", "[36,33]", "[143,122]"})
    public int[] find(int num) {
        return new int[]{getNext(num), getPrev(num)};
    }

    /**
     * 下一个大值
     * <p>
     * 1. 从低往高找到第一个在 1 左边 0
     * <p>
     * 2. 将 0 右边 1 移到 0 的位置
     * <p>
     * 3. 将右边剩余的 1 都移动到最低位
     *
     * @param num 当前值
     * @return 下一个更大值
     */
    private int getNext(int num) {
        int next = -1;
        int i = 0, mask = 1 << i;
        // 从低往高找到第一个 1
        for (; i < 30; i++) {
            if ((num & mask) != 0) {
                break;
            }
            mask <<= 1;
        }
        // 找到第一个在 1 左边的 0
        for (; i < 30; i++) {
            if ((num & mask) == 0) {
                break;
            }
            mask <<= 1;
        }
        // 统计右边 1 的数量
        int cnt1 = 0;
        for (int j = 0; j < i - 1; j++) {
            if ((num & (1 << j)) != 0) {
                cnt1++;
            }
        }
        if (i < 30) {
            // 将低位 1 移到高位
            next = (num | mask) & (~(mask >> 1));
            // 将低位的 1 都移动到右边
            if (cnt1 > 0) {
                next &= -mask;
                next |= (1 << cnt1) - 1;
            }
        }
        return next;
    }

    /**
     * 上一个小值
     * <p>
     * 1. 从低往高找到第一个在 1 右边 0
     * <p>
     * 2. 将 0 左边 1 移到 0 的位置
     * <p>
     * 3. 将右边剩余的 1 都移动到高位部分
     *
     * @param num 当前值
     * @return 上一个小值
     */
    private int getPrev(int num) {
        int prev = -1;
        // 从低往高找到第一个 0
        int i = 0, mask = 1 << i;
        for (; i < 30; i++) {
            if ((num & mask) == 0) {
                break;
            }
            mask <<= 1;
        }
        // 找到 0 之后的第一个 1
        for (; i < 30; i++) {
            if ((num & mask) != 0) {
                break;
            }
            mask <<= 1;
        }
        // 统计右边 1 的数量
        int cnt1 = 0;
        for (int j = 0; j < i; j++) {
            if ((num & (1 << j)) != 0) {
                cnt1++;
            }
        }
        if (i < 30) {
            // 将高位 1 移到低位 0
            mask >>= 1;
            prev = (num | mask) & (~(mask << 1));
            // 将低位 1 往左边移动
            if (cnt1 > 0) {
                prev &= -mask;
                prev |= ((1 << cnt1) - 1) << (i - cnt1 - 1);
            }
        }
        return prev;
    }

}

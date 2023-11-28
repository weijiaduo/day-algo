package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 49. 丑数
 * <p>
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * <p>
 * 求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10 输出: 12 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class UglyNumber {

    /**
     * 思路：使用数组将丑数保存起来，然后不断扩展数组
     * <p>
     * 每个丑数都是前面的丑数乘以 2、3 或者 5 得到的
     * <p>
     * 用三个指针分别指向乘以 2、3、5 的丑数，然后比较三个指针指向的丑数，取最小的那个作为下一个丑数
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"10"}, output = {"12"})
    public int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        // 从小到大保存丑数序列
        int[] us = new int[n + 1];
        us[0] = 1;

        int i = 0, j = 0, k = 0;
        for (int p = 1; p < n; p++) {
            // 三个指针分别指向乘以 2、3、5 的丑数
            int p1 = us[i] * 2;
            int p2 = us[j] * 3;
            int p3 = us[k] * 5;
            // 取最小的那个作为下一个丑数
            us[p] = Math.min(p1, Math.min(p2, p3));

            // 更新指针
            while (p1 <= us[p]) {
                p1 = us[++i] * 2;
            }
            while (p2 <= us[p]) {
                p2 = us[++j] * 3;
            }
            while (p3 <= us[p]) {
                p3 = us[++k] * 5;
            }
        }
        return us[n - 1];
    }

}

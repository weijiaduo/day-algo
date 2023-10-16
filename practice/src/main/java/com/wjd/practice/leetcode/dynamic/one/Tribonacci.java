package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1137. 第 N 个泰波那契数
 * <p>
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * @author weijiaduo
 * @since 2023/10/16
 */
public class Tribonacci {

    /**
     * 思路：动态规划
     * <p>
     * 记住上3个值，然后就可以计算出第4个值，然后更新上3个值即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.9 MB,击败了85.23% 的Java用户
     */
    @TestCase(input = {"4", "25"},
            output = {"4", "1389537"})
    public int dynamic(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int tn = 0;
        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            tn = t2 + t1 + t0;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }

}

package com.wjd.practice.leetcode.bit;

import com.wjd.practice.TestCase;

/**
 * 338. 比特位计数
 * <p>
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10⁵
 *
 * @author weijiaduo
 * @since 2023/10/18
 */
public class CountBits {

    /**
     * 思路：直接统计，计算每个数字的 1 的数量
     * <p>
     * 复杂度：时间 O(nlogk) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了41.86% 的Java用户
     * 内存消耗:45.2 MB,击败了48.70% 的Java用户
     */
    @TestCase(input = {"2", "5"},
            output = {"[0,1,1]", "[0,1,1,2,1,2]"})
    public int[] direct(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }

    /**
     * 计算位 1 的数量
     *
     * @param n 数字
     * @return 位 1 的数量
     */
    private int countOnes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    /**
     * 思路：动态规划，最高有效位
     * <p>
     * 对于数字 x，假如 y 是它的最高位 1 对应的数字，则有
     * <p>
     * bitOnes(x) = bitOnes(x - y) + 1
     * <p>
     * 比如 x = 101，那么 y = 100，则
     * <p>
     * bitOnes(x) = bitOnes(101 - 100) + 1 = bitOnes(1) + 1 = 1 + 1 = 2
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.78% 的Java用户
     * 内存消耗:44.9 MB,击败了90.82% 的Java用户
     */
    @TestCase(input = {"2", "5"},
            output = {"[0,1,1]", "[0,1,1,2,1,2]"})
    public int[] dynamicHighBit(int n) {
        int[] ans = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            // 二进制：1, 10, 100, 1000, 10000, ...
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            // i 就比 i-highBit 在最高位多个 1
            ans[i] = ans[i - highBit] + 1;
        }
        return ans;
    }

    /**
     * 思路：动态规划，最低有效位
     * <p>
     * 对于数字 x，假如 y = x >> 1，实际上最多就消除了 x 的最低位 1，所以
     * <p>
     * 1. 当 x 是偶数时，bitOnes(x) = bitOnes(y)
     * <p>
     * 2. 当 x 是奇数时，bitOnes(x) = bitOnes(y) + 1
     * <p>
     * 判断 x 的奇偶性，可通过 x & 1 来实现
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.78% 的Java用户
     * 内存消耗:45.2 MB,击败了51.46% 的Java用户
     */
    @TestCase(input = {"2", "5"},
            output = {"[0,1,1]", "[0,1,1,2,1,2]"})
    public int[] dynamicLowBit(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    /**
     * 思路：动态规划，最低设置位 1
     * <p>
     * 对于 x，假设 y = x & (x - 1)，那么
     * <p>
     * y 就相当于消去了 x 二进制里面的最低位的 1，因此
     * <p>
     * bitOnes(x) = bitOnes(y) + 1
     * <p>
     * 比如，x = 110，那么 y = 110 & (110 - 1) = 110 & 100 = 100
     * <p>
     * bitOnes(x) = bitOnes(y) + 1 = bitOnes(100) + 1 = 1 + 1 = 2
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.78% 的Java用户
     * 内存消耗:45.1 MB,击败了73.82% 的Java用户
     */
    @TestCase(input = {"2", "5"},
            output = {"[0,1,1]", "[0,1,1,2,1,2]"})
    public int[] dynamicLowBitOne(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

}

package com.wjd.practice.leetcode.bit;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1318. 或运算的最小翻转次数
 * <p>
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算 a OR b == c 成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * <p>
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 *
 * @author weijiaduo
 * @since 2023/10/18
 */
public class MinFlips {

    /**
     * 思路：遍历每个位，判断是否需要转换
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38 MB,击败了67.82% 的Java用户
     */
    @TestCase(input = {"2", "6", "5", "4", "2", "7", "1", "2", "3", "8", "3", "5"},
            output = {"3", "1", "0", "3"})
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        for (int i = 0; i < 31; i++) {
            int la = (a >>> i) & 1;
            int lb = (b >>> i) & 1;
            int lc = (c >>> i) & 1;
            if ((la | lb) != lc) {
                if (lc == 1) {
                    // la = lb = 0，随便转其中一个成 1 即可
                    cnt++;
                } else {
                    // la = 1 或 lb = 1，需要把 2 个都转成 0
                    cnt += la + lb;
                }
            }
        }
        return cnt;
    }

}

package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.03. 翻转数位
 * <p>
 * 给定一个32位整数 num，你可以将一个数位从0变为1。
 * <p>
 * 请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * <p>
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @author weijiaduo
 * @since 2023/12/23
 */
public class ReverseBits {

    /**
     * 思路：滑动窗口
     * <p>
     * 记录区间 [i, j] 内的 0 的数量
     * <p>
     * 0 的数量超过 1 时，滑动窗口收缩
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了5.16% 的Java用户
     */
    @TestCase(input = {"1775", "7"},
            output = {"8", "4"})
    public int reverseBits(int num) {
        int ans = 0;
        int i = 0, j = 0, maski = 1, maskj = 1;
        int cnt = 0;
        while (j < 32) {
            // 扩展窗口
            if ((num & maskj) == 0) {
                cnt++;
            }
            j++;
            maskj <<= 1;

            // 收缩窗口
            while (cnt > 1) {
                if ((num & maski) == 0) {
                    cnt--;
                }
                i++;
                maski <<= 1;
            }

            ans = Math.max(j - i, ans);
        }
        return ans;
    }

}

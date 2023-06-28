package com.wjd.practice.leetcode.other;

/**
 * 1784. 检查二进制字符串字段
 * <p>
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 * <p>
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true 。否则，返回 false 。
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个'1' 组成的字段数量为 2，返回 false
 *
 * @author weijiaduo
 * @since 2022/10/3
 */
public class CheckOnesSegment {

    /**
     * 官解：官解这个思路好有意思
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了13.28% 的Java用户
     */
    public boolean solve(String s) {
        return !s.contains("01");
    }

}

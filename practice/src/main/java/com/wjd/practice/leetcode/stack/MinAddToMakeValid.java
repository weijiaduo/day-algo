package com.wjd.practice.leetcode.stack;

/**
 * 921. 使括号有效的最小添加
 * <p>
 * 只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * <p>
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * <p>
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * <p>
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * <p>
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * <p>
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 * <p>
 * 输入：s = "())"
 * 输出：1
 *
 * @author weijiaduo
 * @since 2022/10/4
 */
public class MinAddToMakeValid {

    /**
     * 思路：括号匹配，记录左括号数量，碰到右括号时匹配减少左括号数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了59.04% 的Java用户
     */
    public int solve(String s) {
        int n = s.length();
        int leftCount = 0, insertCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                // 左括号
                leftCount++;
            } else {
                // 右括号
                if (leftCount > 0) {
                    // 左右括号匹配
                    leftCount--;
                } else {
                    // 插入一个括号
                    insertCount++;
                }
            }
        }
        // 最后如果剩余有左括号，需要多插入右括号
        return insertCount + leftCount;
    }

}

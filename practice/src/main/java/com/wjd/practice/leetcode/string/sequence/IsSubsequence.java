package com.wjd.practice.leetcode.string.sequence;

import com.wjd.practice.TestCase;

/**
 * 392. 判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * <p>
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * <p>
 * 在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 *
 * @author weijiaduo
 * @since 2023/10/5
 */
public class IsSubsequence {

    /**
     * 思路：递归，判断是否满足子序列条件
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了89.34% 的Java用户
     * 内存消耗:39.81MB,击败了5.42% 的Java用户
     */
    @TestCase(input = {"abc", "ahbgdc", "axc", "ahbgdc"},
            output = {"true", "false"})
    public boolean dfs(String s, String t) {
        return dfs(s, 0, t, 0);
    }

    private boolean dfs(String s, int s1, String t, int s2) {
        if (s1 >= s.length()) {
            return true;
        }
        if (s2 >= t.length()) {
            return false;
        }

        if (s.charAt(s1) == t.charAt(s2)) {
            return dfs(s, s1 + 1, t, s2 + 1);
        } else {
            return dfs(s, s1, t, s2 + 1);
        }
    }

    /**
     * 思路：双指针，贪心地优先匹配前面的字符
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了89.34% 的Java用户
     * 内存消耗:38.69MB,击败了28.43% 的Java用户
     */
    @TestCase(input = {"abc", "ahbgdc", "axc", "ahbgdc"},
            output = {"true", "false"})
    public boolean doublePoint(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

}

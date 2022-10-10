package com.wjd.practice.leetcode.string;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * <p>
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：
 * <p>
 * 选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 *
 * @author weijiaduo
 * @since 2022/10/11
 */
public class AreAlmostEqual {

    /**
     * 思路：遍历，找到字符串不同的两个地方，验证交换后是否能相等
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了36.57% 的Java用户
     */
    public boolean solve(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int first = -1, second = -1;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if (first == -1) {
            return true;
        } else if (second == -1) {
            return false;
        }
        return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

}

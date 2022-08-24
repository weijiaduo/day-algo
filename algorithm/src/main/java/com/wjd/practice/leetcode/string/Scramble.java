package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 87. 扰乱字符串
 * <p>
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * <p>
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * <p>
 * 如果字符串的长度为 1 ，算法停止
 * <p>
 * @since 2022/6/9
 */
public class Scramble implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String s1 = "eebaacbcbcadaaedceaaacadccd";
        String s2 = "eadcaacabaddaceacbceaabeccd";
        boolean result = isScramble(s1, s2);
        System.out.println(result);
        return result;
    }

    Deque<String> stack = new LinkedList<>();
    int[][][] memo;

    public boolean isScramble(String s1, String s2) {
        memo = new int[s1.length()][s2.length()][s1.length() + 1];
        return dfs2(s1.toCharArray(), 0, s2.toCharArray(), 0, s1.length());
    }

    /**
     * 回溯法
     * <p>
     * 思路：按照规则，遍历所有可转换的字符串，然后匹配扰乱字符串
     * <p>
     * 有点出乎意料，我以为字符串很短，应该不会超时才对
     * <p>
     * Time Limit Exceeded
     * 测试用例:
     * "eebaacbcbcadaaedceaaacadccd" "eadcaacabaddaceacbceaabeccd"
     */
    public boolean dfs(char[] s1, char[] s2, int from, int to) {
        if (to <= from) {
            return false;
        }
        if (to == from + 1) {
            return s1[from] == s2[from];
        }

        // 快速剪枝，字母数量不同直接返回
        int[] count = new int[26];
        for (int i = from; i < to; i++) {
            count[s1[i] - 'a']++;
            count[s2[i] - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        // 不交换子串
        for (int i = from + 1; i < to; i++) {
            if (dfs(s1, s2, from, i) && dfs(s1, s2, i, to)) {
                return true;
            }
        }

        // 交换子串
        char[] ori = Arrays.copyOfRange(s1, from, to);
        for (int i = from + 1; i < to; i++) {
            // 交换两边的字符串
            int mid = from + to - i;
            System.arraycopy(ori, i - from, s1, from, mid - from);
            System.arraycopy(ori, 0, s1, mid, to - mid);
            if (dfs(s1, s2, from, mid) && dfs(s1, s2, mid, to)) {
                return true;
            }
        }
        // 恢复原始的字符串
        System.arraycopy(ori, 0, s1, from, ori.length);

        return false;
    }

    /**
     * 回溯法
     * <p>
     * 思路：不复制字符串，只改变索引位置
     * <p>
     * 注意：必须用 memo 记忆搜索才行，否则还是会超时
     * <p>
     * 执行耗时:2 ms,击败了99.05% 的Java用户
     * 内存消耗:41.6 MB,击败了61.18% 的Java用户
     */
    public boolean dfs2(char[] s1, int from1, char[] s2, int from2, int length) {
        if (length <= 0) {
            return false;
        }
        if (length == 1) {
            if (s1[from1] == s2[from2]) {
                memo[from1][from2][length] = 1;
                return true;
            }
        }

        // 记忆搜索剪枝
        if (memo[from1][from2][length] != 0) {
            return memo[from1][from2][length] == 1;
        }

        // 快速剪枝，字母数量不同直接返回
        int[] count = new int[26];
        for (int i = 0; i < length; i++) {
            count[s1[from1 + i] - 'a']++;
            count[s2[from2 + i] - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                memo[from1][from2][length] = -1;
                return false;
            }
        }

        // 不交换子串
        for (int i = 1; i < length; i++) {
            if (dfs2(s1, from1, s2, from2, i)
                    && dfs2(s1, from1 + i, s2, from2 + i, length - i)) {
                memo[from1][from2][length] = 1;
                return true;
            }
        }

        // 交换子串
        for (int i = 1; i < length; i++) {
            // 交换两边的字符串
            if (dfs2(s1, from1, s2, from2 + length - i, i)
                    && dfs2(s1, from1 + i, s2, from2, length - i)) {
                memo[from1][from2][length] = 1;
                return true;
            }
        }

        memo[from1][from2][length] = -1;
        return false;
    }

}

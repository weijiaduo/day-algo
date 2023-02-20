package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 6195. 对字母串可执行的最大删除数
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * <p>
 * 在一步操作中，你可以：
 * <p>
 * 删除 整个字符串 s ，或者
 * <p>
 * 对于满足1 <= i <= s.length / 2 的任意 i ，如果 s 中的 前 i 个字母和接下来的 i 个字母 相等 ，删除 前 i 个字母。
 * <p>
 * 例如，如果 s = "ababc" ，那么在一步操作中，你可以删除 s 的前两个字母得到 "abc" ，因为 s 的前两个字母和接下来的两个字母都等于 "ab" 。
 * <p>
 * 返回删除 s 所需的最大操作数。
 *
 * @author weijiaduo
 * @since 2022/10/2
 */
public class DeleteString implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "aaaaa";
        int result = deleteString(s);
        System.out.println(result);
        return result;
    }

    int[] cache;
    int[][] lcp;

    /**
     * 思路：递归 + 记忆化搜索，
     */
    private int deleteString(String s) {
        int n = s.length();
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        char[] chars = s.toCharArray();
        calcLcp(chars);
        return dfs(chars, 0);
    }

    /**
     * 计算公共前缀长度
     * <p>
     * lcp[i][j] 表示以 s[i:] 和 s[j:] 开始的子串的最长公共前缀长度
     */
    private void calcLcp(char[] chars) {
        int n = chars.length;
        lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (chars[i] == chars[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }
    }

    /**
     * 递归遍历
     */
    private int dfs(char[] chars, int i) {
        if (i == chars.length) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        int max = 1, n = chars.length;
        for (int j = 1; i + j < n; j++) {
            if (lcp[i][i + j] >= j) {
                max = Math.max(dfs(chars, i + j) + 1, max);
            }
        }

        cache[i] = max;
        return max;
    }
}

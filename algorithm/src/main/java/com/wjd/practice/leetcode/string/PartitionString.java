package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * @author weijiaduo
 * @since 2022/6/22
 */
public class PartitionString implements Solution<List<List<String>>> {

    @Override
    public List<List<String>> solve(Object... args) {
        String s = "asa";
        List<List<String>> result = partition(s);
        System.out.println(result);
        return result;
    }

    private List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        // dfs(s, 0, new ArrayList<>(), ans);
        int[][] cache = new int[s.length()][s.length()];
        dfsCache(s, 0, new ArrayList<>(), ans, cache);
        return ans;
    }

    /**
     * 思路：回溯遍历所有子串
     *
     * 执行耗时:6 ms,击败了98.86% 的Java用户
     * 内存消耗:53.5 MB,击败了64.78% 的Java用户
     */
    private void dfs(String s, int i, List<String> path, List<List<String>> ans) {
        if (i >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String ss = s.substring(i, j + 1);
            if (!isPalindrome(ss)) {
                continue;
            }
            path.add(ss);
            dfs(s, j + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 思路：记忆存储 + 回溯
     *
     * 怎么时间没变，缓存貌似没啥用
     *
     * 执行耗时:6 ms,击败了98.86% 的Java用户
     * 内存消耗:53.4 MB,击败了70.87% 的Java用户
     */
    private void dfsCache(String s, int i, List<String> path, List<List<String>> ans, int[][] cache) {
        if (i >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            // -1 表示非回文
            if (cache[i][j] == -1) {
                continue;
            }
            String ss = s.substring(i, j + 1);
            // 0表示未校验
            if (cache[i][j] == 0 && !isPalindrome(ss)) {
                cache[i][j] = -1;
                continue;
            }
            // 1表示回文
            cache[i][j] = 1;
            path.add(ss);
            dfsCache(s, j + 1, path, ans, cache);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 是否是回文串
     */
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}

package com.wjd.practice.leetcode.trie;

import java.util.*;

/**
 * 212. 单词搜索2
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * <p>
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
 * "l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class FindWords {

    boolean[][] visited;
    Set<String> ans;
    StringBuilder sb;

    /**
     * 思路：构建字典树，然后遍历所有可能的单词起点
     * <p>
     * 复杂度：时间 O(m^2n^2) 空间 O(mn)
     * <p>
     * 执行耗时:538 ms,击败了31.95% 的Java用户
     * 内存消耗:43.8 MB,击败了6.81% 的Java用户
     */
    private List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {
            return new ArrayList<>(0);
        }

        // 构建字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // 遍历所有可能的单词
        int m = board.length, n = board[0].length;
        ans = new HashSet<>();
        visited = new boolean[m][n];
        sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie);
            }
        }
        return new ArrayList<>(ans);
    }

    /**
     * 回溯遍历
     */
    private void dfs(char[][] board, int i, int j, Trie trie) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || visited[i][j]) {
            return;
        }

        char ch = board[i][j];
        Trie child = trie.children.get(ch);
        if (child == null) {
            return;
        }

        // 找到单词
        visited[i][j] = true;
        sb.append(ch);
        if (child.isEnd()) {
            ans.add(sb.toString());
        }

        // 回溯遍历所有位置
        dfs(board, i - 1, j, child);
        dfs(board, i + 1, j, child);
        dfs(board, i, j - 1, child);
        dfs(board, i, j + 1, child);

        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }

    static class Trie {

        Map<Character, Trie> children = new HashMap<>();
        boolean end = false;

        public void insert(String word) {
            Trie cur = this;
            for (char ch : word.toCharArray()) {
                Trie trie = cur.children.get(ch);
                if (trie == null) {
                    trie = new Trie();
                    cur.children.put(ch, trie);
                }
                cur = trie;
            }
            cur.end = true;
        }

        public boolean isEnd() {
            return this.end;
        }

    }

}

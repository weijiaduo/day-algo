package com.wjd.practice.leetcode.trie;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索2
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * <p>
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 10⁴
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class FindWords {

    static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char base = 'a';

    Set<String> ans;
    char[][] board;
    boolean[][] visited;
    int m, n;

    /**
     * 思路：构建字典树，然后遍历所有可能的单词起点
     * <p>
     * 复杂度：时间 O(m^2n^2) 空间 O(mn)
     * <p>
     * 执行耗时:272 ms,击败了70.91% 的Java用户
     * 内存消耗:42.6 MB,击败了74.00% 的Java用户
     */
    @TestCase(input = {"[['o','a','a','n'],['e','t','a','e'],['i','h','k','r'],['i','f','l','v']]", "[\"oath\",\"pea\",\"eat\",\"rain\"]",
            "[['a','b'],['c','d']]", "[\"abcb\"]"},
            output = {"[\"eat\",\"oath\"]", "[]"})
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {
            return new ArrayList<>(0);
        }

        // 构建字典树
        Trie trie = new Trie();
        for (String word : words) {
            insert(trie, word);
        }

        // 遍历所有可能的单词
        ans = new HashSet<>();
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, trie);
            }
        }
        return new ArrayList<>(ans);
    }

    /**
     * 回溯遍历
     */
    private void dfs(int i, int j, Trie trie) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }

        char ch = board[i][j];
        Trie child = trie.children[ch - base];
        if (child == null) {
            return;
        }

        // 找到单词
        if (child.val != null) {
            ans.add(child.val);
        }

        // 遍历所有位置
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            dfs(i + dir[0], j + dir[1], child);
        }
        visited[i][j] = false;
    }

    /**
     * 插入单词到字典树
     *
     * @param trie 字典树
     * @param word 单词
     */
    private void insert(Trie trie, String word) {
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Trie child = cur.children[ch - base];
            if (child == null) {
                child = new Trie();
                cur.children[ch - base] = child;
            }
            cur = child;
        }
        cur.val = word;
    }

    static class Trie {

        Trie[] children = new Trie[26];
        String val;

    }

}

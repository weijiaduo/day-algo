package com.wjd.practice.leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 336. 回文对
 * <p>
 * 给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：words = ["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 * <p>
 * 示例 3：
 * <p>
 * 输入：words = ["a",""]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] 由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public class PalindromePairs {

    /**
     * 思路：字典树
     * <p>
     * 1. 单词拼成回文对，肯定是一长一短（或者相等），每个单词都可以分为2种情况
     * 1.1 作为长前缀
     * 1.2 作为长后缀
     * <p>
     * 2. 逆向匹配单词
     * <p>
     * 执行耗时:2012 ms,击败了22.82% 的Java用户
     * 内存消耗:151.4 MB,击败了18.94% 的Java用户
     *
     * @param words 单词集合
     * @return 回文串集合
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j <= len; j++) {
                // 作为长前缀（比另一个单词长）
                if (isPalindrome(word, j, len)) {
                    int index = reverseSearch(word, 0, j);
                    if (index != -1 && index != i) {
                        ans.add(Arrays.asList(i, index));
                    }
                }
                // 作为长后缀（比另一个单词长）
                if (j > 0 && isPalindrome(word, 0, j)) {
                    int index = reverseSearch(word, j, len);
                    if (index != -1 && index != i) {
                        ans.add(Arrays.asList(index, i));
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 是否是回文串
     *
     * @param s     字符串
     * @param start [start, end)
     * @param end   [start, end)
     */
    private boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 字典树根节点
     */
    private final TrieNode root = new TrieNode();

    /**
     * 插入单词
     *
     * @param word  单词
     * @param index 单词索引
     */
    private void insert(String word, int index) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            TrieNode trie = cur.children[pos];
            if (trie == null) {
                trie = new TrieNode();
                cur.children[pos] = trie;
            }
            cur = trie;
        }
        cur.index = index;
    }

    /**
     * 逆向搜索对应的单词序列
     *
     * @param word  单词
     * @param start [start, end)
     * @param end   [start, end)
     * @return 单词索引/-1
     */
    private int reverseSearch(String word, int start, int end) {
        TrieNode cur = root;
        for (int i = end - 1; i >= start; i--) {
            int pos = word.charAt(i) - 'a';
            TrieNode trie = cur.children[pos];
            if (trie == null) {
                return -1;
            }
            cur = trie;
        }
        return cur.index;
    }

    /**
     * 字典树节点
     */
    static class TrieNode {
        int index = -1;
        TrieNode[] children = new TrieNode[26];
    }

}

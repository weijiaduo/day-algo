package com.wjd.practice.leetcode.string.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 6183. 字符串的前缀分数和
 *
 * @author weijiaduo
 * @since 2022/9/18
 */
public class SumPrefixScores {

    /**
     * 思路：
     * <p>
     * 用字典树记录所有单词，并统计每个节点被访问的次数。
     * <p>
     * 遍历每个单词的前缀，在字典树中查找前缀，并返回次数
     * <p>
     * 字符串前缀是连续的，所以下一个前缀可以从上一个前缀的节点出发，加快寻找速度
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     *
     * @param words 字符串
     * @return 分数
     */
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int sum = 0;
            int l = word.length();
            Trie t = trie;
            for (int j = 1; j <= l; j++) {
                t = t.searchPrefix(word.substring(j - 1, j));
                if (t == null) {
                    break;
                }
                sum += t.count;
            }
            ans[i] = sum;
        }
        return ans;
    }

    static class Trie {

        Map<Character, Trie> children = new HashMap<>();
        int count = 0;

        /**
         * 插入单词
         *
         * @param word 单词
         */
        public void insert(String word) {
            Trie cur = this;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                Trie trie = cur.children.get(ch);
                if (trie == null) {
                    trie = new Trie();
                    cur.children.put(ch, trie);
                }
                trie.count++;
                cur = trie;
            }
        }

        /**
         * 搜索指定的前缀
         *
         * @param prefix 前缀
         * @return 前缀的最后一个节点
         */
        private Trie searchPrefix(String prefix) {
            Trie cur = this;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char ch = prefix.charAt(i);
                cur = cur.children.get(ch);
                if (cur == null) {
                    return null;
                }
            }
            return cur;
        }

    }

}

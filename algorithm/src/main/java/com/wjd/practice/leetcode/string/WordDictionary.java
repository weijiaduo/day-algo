package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. 添加与搜索单词
 * <p>
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 *
 * @author weijiaduo
 * @since 2022/7/15
 */
public class WordDictionary implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("ad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search(".."));
        return null;
    }

    Trie trie = new Trie();

    /**
     * 执行耗时:799 ms,击败了18.96% 的Java用户
     * 内存消耗:87.7 MB,击败了82.89% 的Java用户
     */
    public WordDictionary() {
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    static class Trie {

        Map<Character, Trie> children = new HashMap<>();
        boolean isEnd = false;

        /**
         * 插入单词
         *
         * @param word 单词
         */
        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Trie trie = cur.children.get(ch);
                if (trie == null) {
                    trie = new Trie();
                    cur.children.put(ch, trie);
                }
                cur = trie;
            }
            cur.isEnd = true;
        }

        /**
         * 是否包含指定单词
         *
         * @param word 单词
         * @return 单词是否存在
         */
        public boolean search(String word) {
            Trie trie = match(this, word, 0);
            return trie != null && trie.isEnd;
        }

        /**
         * 匹配字符串
         */
        private Trie match(Trie root, String word, int index) {
            if (index == word.length()) {
                return root.isEnd ? root : null;
            }
            char ch = word.charAt(index);
            if (Character.isLetter(ch)) {
                Trie child = root.children.get(ch);
                if (child == null) {
                    return null;
                }
                return match(child, word, index + 1);
            } else {
                // . 可以匹配任意字符
                for (Trie t : root.children.values()) {
                    Trie ret = match(t, word, index + 1);
                    if (ret != null) {
                        return ret;
                    }
                }
                return null;
            }
        }
    }

}

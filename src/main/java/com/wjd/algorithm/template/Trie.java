package com.wjd.algorithm.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典树
 *
 * @author weijiaduo
 * @since 2022/7/8
 */
public class Trie {

    Map<Character, Trie> children = new HashMap<>();
    boolean isEnd = false;

    /**
     * 执行耗时:41 ms,击败了24.64% 的Java用户
     * 内存消耗:53.4 MB,击败了7.81% 的Java用户
     */
    public Trie() {
    }

    /**
     * 构建字典树
     *
     * @param words 初始化单词列表
     * @return 字典树
     */
    public static Trie build(List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

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
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    /**
     * 是否包含指定前缀
     *
     * @param prefix 前缀
     * @return 是否有前缀
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 搜索指定的前缀
     *
     * @param prefix 前缀
     * @return 前缀的最后一个节点
     */
    private Trie searchPrefix(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            cur = cur.children.get(ch);
            if (cur == null) {
                return null;
            }
        }
        return cur;
    }

    /**
     * 查找指定单词的最短路径
     *
     * @param word 单词
     * @return 最短路径/单词本身
     */
    public String minPrefix(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cur = cur.children.get(ch);
            if (cur == null) {
                return word;
            }
            if (cur.isEnd) {
                return word.substring(0, i + 1);
            }
        }
        return null;
    }

    /**
     * 是否匹配字符串表达式
     *
     * @param word 字符串表达式
     * @return true/false
     */
    public boolean match(String word) {
        Trie trie = dfsMatch(this, word, 0);
        return trie != null && trie.isEnd;
    }

    /**
     * 匹配字符串
     */
    private Trie dfsMatch(Trie root, String word, int index) {
        if (index == word.length()) {
            return root.isEnd ? root : null;
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            Trie child = root.children.get(ch);
            if (child == null) {
                return null;
            }
            return dfsMatch(child, word, index + 1);
        } else {
            // . 可以匹配任意字符
            for (Trie t : root.children.values()) {
                Trie ret = dfsMatch(t, word, index + 1);
                if (ret != null) {
                    return ret;
                }
            }
            return null;
        }
    }

}

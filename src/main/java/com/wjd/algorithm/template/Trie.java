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

    TrieNode root = new TrieNode();

    public static Trie build(List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        return trie;
    }

    /**
     * 给字典树添加单词
     * @param word 单词
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode trieNode = cur.children.get(ch);
            if (trieNode == null) {
                trieNode = new TrieNode();
                trieNode.val = ch;
                cur.children.put(ch, trieNode);
            }
            cur = trieNode;
        }
        cur.children.putIfAbsent('#', new TrieNode());
    }

    /**
     * 查找指定单词的最短路径
     * @param word 单词
     * @return 最短路径/单词本身
     */
    public String findMinPath(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cur = cur.children.get(ch);
            if (cur == null) {
                return word;
            }
            if (cur.children.containsKey('#')) {
                return word.substring(0, i + 1);
            }
        }
        return word;
    }

    private static class TrieNode {
        char val;
        Map<Character, TrieNode> children = new HashMap<>();
    }

}

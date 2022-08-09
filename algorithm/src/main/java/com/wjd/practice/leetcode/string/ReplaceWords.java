package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.*;

/**
 * 648. 单词替换
 * <p>
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * <p>
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。
 * <p>
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * @author weijiaduo
 * @since 2022/7/7
 */
public class ReplaceWords implements Solution<String> {

    @Override
    public String solve(Object... args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String result = replaceWords2(dictionary, sentence);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：先对字符串排序，然后逐个匹配句子中的单词
     * <p>
     * 复杂度：时间 O(mn) 空间 O(n)
     * <p>
     * 执行耗时:18 ms,击败了44.44% 的Java用户
     * 内存消耗:44.8 MB,击败了93.40% 的Java用户
     */
    private String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String dict : dictionary) {
                // 匹配首字母是否相等
                int cmp = word.charAt(0) - dict.charAt(0);
                if (cmp > 0) {
                    continue;
                }
                if (cmp == 0 && word.startsWith(dict)) {
                    words[i] = dict;
                    break;
                }
                if (cmp < 0) {
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    /**
     * 思路：字典树，找到句子中的单词在字典树的最短路径，然后替换
     * <p>
     * 执行耗时:12 ms,击败了62.59% 的Java用户
     * 内存消耗:54.4 MB,击败了11.09% 的Java用户
     */
    private String replaceWords2(List<String> dictionary, String sentence) {
        Trie root = buildTrie(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(root, words[i]);
        }
        return String.join(" ", words);
    }

    private static class Trie {
        char val;
        Map<Character, Trie> children = new HashMap<>();
    }

    /**
     * 构建字典树
     *
     * @param dictionary 字段
     * @return 字典树根节点，根节点不属于正常节点
     */
    private Trie buildTrie(List<String> dictionary) {
        Trie root = new Trie();
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Trie trie = cur.children.get(ch);
                if (trie == null) {
                    trie = new Trie();
                    trie.val = ch;
                    cur.children.put(ch, trie);
                }
                cur = trie;
            }
            cur.children.putIfAbsent('#', new Trie());
        }
        return root;
    }

    /**
     * 查找指定单词的最短根路径
     *
     * @param root 根节点
     * @param word 指定单词
     * @return 最短路径/指定单词
     */
    private String findRoot(Trie root, String word) {
        Trie cur = root;
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

}

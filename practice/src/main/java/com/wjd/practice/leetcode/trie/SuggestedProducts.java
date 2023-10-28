package com.wjd.practice.leetcode.trie;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 1268. 搜索推荐系统
 * <p>
 * 给你一个产品数组 products 和一个字符串 searchWord ，products 数组中每个产品都是一个字符串。
 * <p>
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，
 * <p>
 * 推荐 products 数组中前缀与 searchWord 相同的最多三个产品。
 * <p>
 * 如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 * <p>
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"]
 * ,["bags"]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 * <p>
 * 提示：
 * <p>
 * 1 <= products.length <= 1000
 * 1 <= Σ products[i].length <= 2 * 10^4
 * products[i] 中所有的字符都是小写英文字母。
 * 1 <= searchWord.length <= 1000
 * searchWord 中所有字符都是小写英文字母。
 *
 * @author weijiaduo
 * @since 2023/10/19
 */
public class SuggestedProducts {

    /**
     * 思路：字典树，先构成字典树，然后去搜索前缀即可
     * <p>
     * 复杂度：时间 O(nm) 空间 O(m)
     * <p>
     * 执行耗时:100 ms,击败了13.13% 的Java用户
     * 内存消耗:44.5 MB,击败了95.38% 的Java用户
     */
    @TestCase(input = {"[\"mobile\",\"mouse\",\"moneypot\",\"monitor\",\"mousepad\"]", "mouse",
            "[\"havana\"]", "havana",
            "[\"bags\",\"baggage\",\"banner\",\"box\",\"cloths\"]", "bags"},
            output = {"[[\"mobile\",\"moneypot\",\"monitor\"],[\"mobile\",\"moneypot\",\"monitor\"],[\"mouse\",\"mousepad\"],[\"mouse\",\"mousepad\"],[\"mouse\",\"mousepad\"]]",
                    "[[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"],[\"havana\"]]",
                    "[[\"baggage\",\"bags\",\"banner\"],[\"baggage\",\"bags\",\"banner\"],[\"baggage\",\"bags\"],[\"bags\"]]"})
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        int n = searchWord.length();
        List<List<String>> ans = new ArrayList<>(n - 1);
        for (int i = 1; i <= n; i++) {
            List<String> prefixes = trie.prefixes(searchWord.substring(0, i), 3);
            ans.add(prefixes);
        }
        return ans;
    }

    static class Trie {

        static class Node {
            // 下一层节点
            Node[] children = new Node[26];
            // 是否是字符串末尾节点
            boolean end = false;
            // end = true 时对应的字符串
            String value;
        }

        /**
         * 根节点
         */
        Node root = new Node();

        /**
         * 基础字母，相对索引
         */
        char base = 'a';

        /**
         * 插入单词
         *
         * @param word 单词
         */
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Node trie = cur.children[ch - base];
                if (trie == null) {
                    trie = new Node();
                    cur.children[ch - base] = trie;
                }
                cur = trie;
            }
            cur.end = true;
            cur.value = word;
        }

        /**
         * 查找指定单词的 k 个最短前缀单词
         *
         * @param word 单词
         * @param k    单词数量
         * @return 最短路径/单词本身
         */
        public List<String> prefixes(String word, int k) {
            List<String> words = new ArrayList<>(k);
            collectWords(searchPrefix(word), k, words);
            return words;
        }

        /**
         * 深度优先收集 k 个字符串
         *
         * @param root 当前节点
         * @param k    k 个字符串
         * @param list 字符串列表
         */
        private void collectWords(Node root, int k, List<String> list) {
            if (root == null || list.size() >= k) {
                return;
            }
            if (root.end) {
                list.add(root.value);
            }
            for (Node child : root.children) {
                collectWords(child, k, list);
            }
        }

        /**
         * 搜索指定的前缀
         *
         * @param prefix 前缀
         * @return 前缀的最后一个节点
         */
        private Node searchPrefix(String prefix) {
            Node cur = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char ch = prefix.charAt(i);
                cur = cur.children[ch - base];
                if (cur == null) {
                    return null;
                }
            }
            return cur;
        }

    }

}

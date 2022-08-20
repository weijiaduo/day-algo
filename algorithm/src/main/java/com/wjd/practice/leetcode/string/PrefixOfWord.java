package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * <p>
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 * <p>
 * 请你检查检索词searchWord 是否为句子 sentence 中任意单词的前缀。
 * <p>
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * <p>
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * <p>
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * <p>
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
 * <p>
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 *
 * @author weijiaduo
 * @since 2022/8/21
 */
public class PrefixOfWord implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        int result = isPrefixOfWord(sentence, searchWord);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：拆分句子成字符串，然后遍历匹配
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了46.67% 的Java用户
     *
     * @param sentence   句子
     * @param searchWord 单词
     * @return 匹配索引
     */
    private int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}

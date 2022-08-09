package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * <p>
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * <p>
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * <p>
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 *
 * @author weijiaduo
 * @since 2022/8/6
 */
public class StringMatching implements Solution<List<String>> {

    @Override
    public List<String> solve(Object... args) {
        String[] words = {"leetcode", "et", "code"};
        List<String> result = stringMatching(words);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：先排序，避免匹配遗漏的情况
     * <p>
     * 复杂度：时间 O(nlogn) 空间O(1)
     * <p>
     * 执行耗时:3 ms,击败了95.63% 的Java用户
     * 内存消耗:40.1 MB,击败了89.32% 的Java用户
     *
     * @param words 单词数组
     * @return 子串列表
     */
    private List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        List<String> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = i + 1; j < n; j++) {
                if (words[j].contains(word)) {
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }

}

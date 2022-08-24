package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * <p>
 * 你有一个单词列表 words 和一个模式 pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * @since 2022/6/12
 */
public class FindAndReplacePattern implements Solution<List<String>> {

    @Override
    public List<String> solve(Object... args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> result = findAndReplacePattern(words, pattern);
        System.out.println(result);
        return result;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>(words.length);
        for (String word : words) {
            if (isMatch(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    /**
     * 思路：用哈希表保存映射关系，然后逐个字母匹配映射
     *
     * 执行耗时:1 ms,击败了91.03% 的Java用户
     * 内存消耗:41.5 MB,击败了26.92% 的Java用户
     */
    private boolean isMatch(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch1 = word.charAt(i);
            char ch2 = pattern.charAt(i);
            Character m = map.get(ch1);
            if (m == null) {
                if (map.containsValue(ch2)) {
                    return false;
                }
                map.put(ch1, ch2);
                m = ch2;
            }
            if (ch2 != m) {
                return false;
            }
        }

        return true;
    }

}

package com.wjd.practice.leetcode.hash;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 *
 * @author weijiaduo
 * @since 2023/11/1
 */
public class WordPattern {

    /**
     * 思路：哈希，记录字符和单词的相互映射关系，然后遍历判断即可
     * <p>
     * 复杂度：时间 O(n+m) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了59.88% 的Java用户
     */
    @TestCase(input = {"abba", "dog cat cat dog",
            "abba", "dog cat cat fish",
            "aaaa", "dog cat cat dog"},
            output = {"true", "false", "false"})
    public boolean hash(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length(), m = words.length;
        if (n != m) {
            return false;
        }

        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char pc = pattern.charAt(i);
            String ws = words[i];
            String pcs = c2s.get(pc);
            if (pcs != null && !ws.equals(pcs)) {
                // 一个字符映射了多个单词
                return false;
            }
            if (pcs == null && s2c.containsKey(ws)) {
                // 多个字符映射同一个单词
                return false;
            }
            // 新建映射关系
            c2s.put(pc, ws);
            s2c.put(ws, pc);
        }
        return true;
    }

}

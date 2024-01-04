package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * <p>
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author weijiaduo
 * @since 2024/1/4
 */
public class GroupAnagrams {

    /**
     * 思路：哈希+计数
     * <p>
     * 使用哈希保存每种变位字符串
     * <p>
     * key 值就是字符的计数数组
     * <p>
     * value 就是变位字符串列表
     * <p>
     * 复杂度：时间 O(nm) 空间 O(1)
     */
    @TestCase(input = {"[\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]"},
            output = {"[" +
                      "  [\"ate\",\"eat\",\"tea\"]" +
                      "  [\"nat\",\"tan\"]" +
                      "  [\"bat\"]" +
                      "]"})
    public List<List<String>> countMap(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = countKey(s);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 基于排序的字符串 key 值计算
     * <p>
     * 执行耗时:7 ms,击败了71.22% 的Java用户
     * 内存消耗:46.2 MB,击败了30.73% 的Java用户
     *
     * @param s 字符串
     * @return key 值
     */
    private String sortKey(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    /**
     * 基于计数的字符串 key 值计算
     * <p>
     * 执行耗时:9 ms,击败了39.02% 的Java用户
     * 内存消耗:46.7 MB,击败了9.76% 的Java用户
     *
     * @param s 字符串
     * @return key 值
     */
    private String countKey(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

}

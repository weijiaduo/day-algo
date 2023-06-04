package com.wjd.practice.leetcode.string.combination;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。
 * <p>
 * 可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 10⁴
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @since 2022/5/29
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        return countGroupAnagrams(strs);
    }

    /**
     * 思路：给每个字符串排序，如果排序后的字符串一致，那就属于异位字母分词
     * <p>
     * 复杂度：时间 O(nmlogm) 空间 O(nm)
     * <p>
     * 执行耗时:6 ms,击败了78.53% 的Java用户
     * 内存消耗:44.1 MB,击败了83.72% 的Java用户
     */
    private List<List<String>> sortGroupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map.put(s, list);
                ans.add(list);
            }
            list.add(str);
        }
        return ans;
    }

    /**
     * 思路：统计每个字符串中字母的数量，如果数量一致，就属于异位字母分词
     * <p>
     * 这个想法有点意思啊~~~
     * <p>
     * 复杂度：时间 O(nm) 空间 O(nm)
     * <p>
     * 执行耗时:7 ms,击败了39.94% 的Java用户
     * 内存消耗:44.9 MB,击败了14.16% 的Java用户
     */
    private List<List<String>> countGroupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = getCountString(str);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map.put(s, list);
                ans.add(list);
            }
            list.add(str);
        }
        return ans;
    }

    private String getCountString(String str) {
        int[] counts = new int[26];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int index = str.charAt(i) - 'a';
            counts[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) {
                continue;
            }
            char ch = (char) ('a' + i);
            sb.append(ch).append(counts[i]);
        }
        return sb.toString();
    }

}

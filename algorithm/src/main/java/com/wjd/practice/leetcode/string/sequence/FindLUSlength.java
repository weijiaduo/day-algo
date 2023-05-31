package com.wjd.practice.leetcode.string.sequence;

import java.util.*;

/**
 * 522. 最长特殊序列
 * <p>
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。
 * <p>
 * 如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 *
 * @author weijiaduo
 * @since 2022/6/27
 */
public class FindLUSlength {

    public int findLUSLength(String[] strs) {
        // return backtrackFindLUSLength(strs);
        return subSeqFindLUSLength(strs);
    }

    Map<String, Integer> counts;

    /**
     * 思路：回溯，遍历所有的子序列
     * <p>
     * 竟然没有超时~~
     * <p>
     * 执行耗时:65 ms,击败了15.11% 的Java用户
     * 内存消耗:45.5 MB,击败了14.45% 的Java用户
     */
    private int backtrackFindLUSLength(String[] strs) {
        counts = new HashMap<>();
        for (String str : strs) {
            backtrack(str, 0, "", new HashSet<>());
        }

        int maxLength = -1;
        Set<Map.Entry<String, Integer>> set = counts.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            if (entry.getValue() == 1) {
                maxLength = Math.max(maxLength, entry.getKey().length());
            }
        }
        return maxLength;
    }

    /**
     * 回溯，遍历所有的子序列
     */
    private void backtrack(String str, int i, String s, Set<String> strSet) {
        if (i == str.length()) {
            if (!strSet.contains(s)) {
                int count = counts.getOrDefault(s, 0);
                counts.put(s, count + 1);
            }
            return;
        }
        // 回溯，选择当前字符和不选择当前字符
        backtrack(str, i + 1, s, strSet);
        backtrack(str, i + 1, s + str.charAt(i), strSet);
    }

    /**
     * 思路：判断字符串之间是否是子序列的关系，不是的话，最长的字符串长度就是结果
     * <p>
     * 复杂度：时间O(n^2 * l) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.11% 的Java用户
     * 内存消耗:39.3 MB,击败了21.56% 的Java用户
     */
    private int subSeqFindLUSLength(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                // 是别人的子序列，说明不是特殊字符串
                if (i != j && isSubSeq(strs[j], strs[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return strs[i].length();
            }
        }
        return -1;
    }

    /**
     * 是否是另一个字符串的子序列
     */
    private boolean isSubSeq(String str, String subStr) {
        int p = 0;
        if (subStr.length() > str.length()) {
            return false;
        }
        for (int i = 0; i < str.length() && p < subStr.length(); i++) {
            if (str.charAt(i) == subStr.charAt(p)) {
                p++;
            }
        }
        return p == subStr.length();
    }

}

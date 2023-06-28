package com.wjd.practice.leetcode.string.statistics;

/**
 * 1684. 统计一致字符串的数目
 * <p>
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * <p>
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字 符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 *
 * @author weijiaduo
 * @since 2022/11/8
 */
public class CountConsistentStrings {


    public int solve(String allowed, String[] words) {
        return bit(allowed, words);
    }

    /**
     * 思路：使用 boolean[26] 记录下 allowed 的小写字符出现情况，然后遍历 words 即可
     * <p>
     * 复杂度：时间 O(nmk) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了98.53% 的Java用户
     * 内存消耗:41.9 MB,击败了78.74% 的Java用户
     */
    private int arr(String allowed, String[] words) {
        int count = 0;
        // 记录 26 个小写字母是否出现
        boolean[] flags = new boolean[26];
        int n = allowed.length();
        for (int i = 0; i < n; i++) {
            flags[allowed.charAt(i) - 'a'] = true;
        }
        // 验证每个字符串是否满足要求
        for (String word : words) {
            int len = word.length(), m = 1;
            for (int i = 0; i < len; i++) {
                if (!flags[word.charAt(i) - 'a']) {
                    m = 0;
                    break;
                }
            }
            count += m;
        }
        return count;
    }

    /**
     * 思路：小写字符才 26 个，直接用 int 类型就可以表示，每个位表示一个字母
     * <p>
     * 复杂度：时间 O(nmk) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了100.00% 的Java用户
     * 内存消耗:42.3 MB,击败了34.10% 的Java用户
     */
    private int bit(String allowed, String[] words) {
        int count = 0;
        // 记录 26 个小写字母是否出现
        int mask = 0, n = allowed.length();
        for (int i = 0; i < n; i++) {
            mask |= 1 << (allowed.charAt(i) - 'a');
        }
        // 验证每个字符串是否满足要求
        for (String word : words) {
            int len = word.length(), m = 1;
            for (int i = 0; i < len; i++) {
                if ((mask & (1 << word.charAt(i) - 'a')) == 0) {
                    m = 0;
                    break;
                }
            }
            count += m;
        }
        return count;
    }

}

package com.wjd.practice.leetcode.hash;

import com.wjd.practice.TestCase;

/**
 * 383. 赎金信
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 10⁵
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/11/1
 */
public class CanConstruct {

    /**
     * 思路：哈希计数，
     * <p>
     * 统计其中一个字符串的每个字符的数量，
     * <p>
     * 然后判断另一个字符串的所有字符是否都在这些字符里面
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了58.18% 的Java用户
     * 内存消耗:42.8 MB,击败了34.06% 的Java用户
     */
    @TestCase(input = {"a", "b", "aa", "ab", "aa", "aab"},
            output = {"false", "false", "true"})
    public boolean hash(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        if (m < n) {
            // 快速剪枝
            return false;
        }

        // 统计每个字符的出现频率
        int[] cnt = new int[128];
        for (int i = 0; i < m; i++) {
            cnt[magazine.charAt(i)]++;
        }
        for (int i = 0; i < n; i++) {
            // 数量小于 0 时表示提供的字符不够
            if (--cnt[ransomNote.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}

package com.wjd.practice.leetcode.string.compare;

import com.wjd.practice.leetcode.TestCase;

/**
 * 125. 验证回文串
 * <p>
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 10⁵
 * s 仅由可打印的 ASCII 字符组成
 *
 * @since 2022/6/19
 */
public class IsPalindrome {

    /**
     * 思路：双指针分别从左右遍历，找到数字和字母对比即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了96.23% 的Java用户
     * 内存消耗:41.6 MB,击败了31.26% 的Java用户
     */
    @TestCase(input = {"A man, a plan, a canal: Panama", "race a car", " "},
            output = {"true", "false", "true"})
    public boolean doublePoint(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 是否是合法字符（字母+数字）
     *
     * @param ch 字符
     * @return true/false
     */
    private boolean isValid(char ch) {
        return '0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z';
    }

}

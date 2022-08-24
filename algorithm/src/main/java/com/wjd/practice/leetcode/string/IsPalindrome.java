package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

/**
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * @since 2022/6/19
 */
public class IsPalindrome implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String s = "";
        boolean result = isPalindrome(s);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：双指针分别从左右遍历，找到数字和字母对比即可
     *
     * 执行耗时:2 ms,击败了96.23% 的Java用户
     * 内存消耗:41.6 MB,击败了31.26% 的Java用户
     */
    private boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left <= right && !isLegal(s.charAt(left))) {
                left++;
            }
            while (left <= right && !isLegal(s.charAt(right))) {
                right--;
            }
            if (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isLegal(char ch) {
        return '0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z';
    }

}

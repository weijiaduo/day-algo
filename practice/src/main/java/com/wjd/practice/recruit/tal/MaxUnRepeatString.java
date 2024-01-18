package com.wjd.practice.recruit.tal;

import com.wjd.practice.TestCase;

/**
 * 最长不重复子串
 *
 * @author weijiaduo
 * @since 2024/1/18
 */
public class MaxUnRepeatString {

    @TestCase(input = {"abcdedafg", "aaaa", "ab", "aba"},
            output = {"5", "1", "2", "2"})
    public int slide(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int ans = 1;
        boolean[] set = new boolean[26];
        int n = s.length();
        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (set[ch - 'a']) {
                // 收缩窗口
                while (j < i && s.charAt(j) != ch) {
                    set[s.charAt(j) - 'a'] = false;
                    j++;
                }
                j++;
            }
            // 扩展窗口
            set[ch - 'a'] = true;
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}

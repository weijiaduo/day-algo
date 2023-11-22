package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

/**
 * 5. 替换空格
 * <p>
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * <p>
 * 例如，输入"We are happy."，则输出"We%20are%20happy."。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class ReplaceSpace {

    /**
     * 思路：遍历字符串，统计空格数量，然后从后往前替换
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"We are happy."},
            output = {"We%20are%20happy."})
    public String replaceSpace(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // 统计空格数量
        int n = str.length(), cnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                cnt++;
            }
        }
        // 没有空格
        if (cnt == 0) {
            return str;
        }

        // 替换空格
        int k = n + cnt * 2;
        char[] chars = new char[k];
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                chars[--k] = '0';
                chars[--k] = '2';
                chars[--k] = '%';
            } else {
                chars[--k] = ch;
            }
        }
        return new String(chars);
    }

}

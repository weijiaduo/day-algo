package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

/**
 * 面试题 01.06. 字符串压缩
 * <p>
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * <p>
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * <p>
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。
 * <p>
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 *
 * @author weijiaduo
 * @since 2023/12/13
 */
public class CompressString {

    /**
     * 思路：双指针
     * <p>
     * 慢指针指向字符的起始位置，快指针指向字符的结束位置
     * <p>
     * 快慢指针的差值就是字符的数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了77.35% 的Java用户
     * 内存消耗:41.1 MB,击败了27.05% 的Java用户
     */
    @TestCase(input = {"aabcccccaaa", "abbccd"},
            output = {"a2b1c5a3", "abbccd"})
    public String doublePoint(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0, j = 0;
        while (j < n) {
            while (i < n && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            sb.append(s.charAt(j)).append(i - j);
            j = i;
        }
        return sb.length() >= n ? s : sb.toString();
    }

}

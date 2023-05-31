package com.wjd.practice.leetcode.string.transform;

import java.util.Arrays;

/**
 * 面试题 01.02 判定是否互为字符重排
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * @author weijiaduo
 * @since 2022/9/27
 */
public class CheckPermutation {

    /**
     * 思路：排序，对2个字符串排序，排序结果相同就是互为重排
     * <p>
     * 复杂第：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了32.15% 的Java用户
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

}

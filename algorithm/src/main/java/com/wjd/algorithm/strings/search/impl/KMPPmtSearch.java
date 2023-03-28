package com.wjd.algorithm.strings.search.impl;

import com.wjd.algorithm.strings.search.Search;

/**
 * KMP(Partial Match Table) 算法
 *
 * @author weijiaduo
 * @since 2023/3/28
 */
public class KMPPmtSearch implements Search {

    @Override
    public int search(String pat, String txt) {
        int[] pmt = getPmt(pat);
        int i = 0, j = 0;
        int m = pat.length(), n = txt.length();
        while (i < n && j < m) {
            if (txt.charAt(i) == pat.charAt(j)) {
                // 匹配主串和模式串的下一个字符
                i++;
                j++;
            } else if (j != 0) {
                // 一次性滑到最长相等前后缀的位置开始匹配
                j = pmt[j - 1];
            } else {
                // 模式串完全不匹配，滑到主串的下一个字符开始
                i++;
            }
        }
        // 匹配成功
        if (j == m) {
            return i - j;
        }
        return -1;
    }

    /**
     * 获取 Partial Match Table
     * <p>
     * pmt[i] 表示 pat[0...i] 的最长相等前后缀的长度
     *
     * @param pat 模式串
     * @return pmt 数组
     */
    private int[] getPmt(String pat) {
        int m = pat.length();
        int[] pmt = new int[m];
        pmt[0] = 0;
        int i = 1, j = 0;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(j)) {
                // 最长相等前后缀长度 + 1
                i++;
                j++;
                pmt[i - 1] = j;
            } else if (j != 0) {
                // 找次长相等前后缀递归匹配
                j = pmt[j - 1];
            } else {
                // 没有相等的前后缀
                i++;
                pmt[i - 1] = j;
            }
        }
        return pmt;
    }

}

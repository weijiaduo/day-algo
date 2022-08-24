package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 171. Excel表列序号
 * <p>
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 *
 * @author weijiaduo
 * @since 2022/7/5
 */
public class TitleToNumber implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String columnTitle = "ZY";
        int result = titleToNumber(columnTitle);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接按照26进制数转即可，不过要注意+1
     * <p>
     * 复杂度：时间O(n) 空间O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了61.31% 的Java用户
     */
    private int titleToNumber(String columnTitle) {
        int number = 0;
        for (int i = 0, n = columnTitle.length(); i < n; i++) {
            char ch = columnTitle.charAt(i);
            number = number * 26 + (ch - 'A' + 1);
        }
        return number;
    }

}

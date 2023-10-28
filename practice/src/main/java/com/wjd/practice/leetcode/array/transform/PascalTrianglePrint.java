package com.wjd.practice.leetcode.array.transform;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 *
 * @since 2021-05-29
 */
public class PascalTrianglePrint {

    /**
     * 思路：直接模拟，下一行由上一行计算出来
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了96.91% 的Java用户
     * 内存消耗:40 MB,击败了54.64% 的Java用户
     */
    @TestCase(input = {"5", "1"},
            output = {"[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]", "[[1]]"})
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        List<Integer> row = null, last = null;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(last.get(j - 1) + last.get(j));
                }
            }
            ans.add(row);
            last = row;
        }
        return ans;
    }

}

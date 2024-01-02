package com.wjd.practice.book.cracking.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 * <p>
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
 * <p>
 * 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..", // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.", // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @author weijiaduo
 * @since 2024/1/2
 */
public class SolveNQueens {

    /**
     * 思路：回溯，遍历所有可能的情况
     * <p>
     * 根据行选择不同的 queen，然后排除列和对角线的情况
     * <p>
     * 复杂度：世间 O(n!) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了92.98% 的Java用户
     * 内存消耗:43.5 MB,击败了18.60% 的Java用户
     */
    @TestCase(input = {"4"},
            output = {"[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]"})
    public List<List<String>> backtrack(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] rows = new int[n];
        backtrack(rows, 0, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param rows 行列值
     * @param i    当前行
     * @param ans  结果集
     */
    private void backtrack(int[] rows, int i, List<List<String>> ans) {
        if (i >= rows.length) {
            ans.add(format(rows));
            return;
        }
        int n = rows.length;
        for (int j = 0; j < n; j++) {
            if (check(rows, i, j)) {
                rows[i] = j;
                backtrack(rows, i + 1, ans);
            }
        }
    }

    /**
     * 检查是否可以放置
     *
     * @param rows 行列值
     * @param i    当前行
     * @param j    当前列
     * @return true/false
     */
    private boolean check(int[] rows, int i, int j) {
        for (int k = 0; k < i; k++) {
            // 相同列判断
            if (rows[k] == j) {
                return false;
            }
            // 对角线判断
            if (Math.abs(i - k) == Math.abs(j - rows[k])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 格式化皇后字符串
     *
     * @param rows 行列值
     * @return 字符串列表
     */
    private List<String> format(int[] rows) {
        int n = rows.length;
        List<String> ret = new ArrayList<>(n);
        for (int row : rows) {
            char[] chs = new char[n];
            Arrays.fill(chs, '.');
            chs[row] = 'Q';
            ret.add(new String(chs));
        }
        return ret;
    }

}

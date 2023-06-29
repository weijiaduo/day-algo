package com.wjd.practice.leetcode.matrix;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 1253. 重构 2 行二进制矩阵
 * <p>
 * 给你一个 2 行 n 列的二进制数组：
 * <p>
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * <p>
 * <p>
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 * <p>
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * <p>
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 *
 * @author weijiaduo
 * @since 2023/6/29
 */
public class ReconstructMatrix {

    /**
     * 思路：colsum 的值有 3 种情况，
     * <p>
     * 0：upper 和 lower 都是 0
     * <p>
     * 1：upper 或 lower 其中一个是 1
     * <p>
     * 2：upper 和 lower 都是 1
     * <p>
     * 其中，0 和 2 的情况是明确的，不需要考虑
     * <p>
     * 所以只要确定 1 是放在 upper 还是 lower 即可
     * <p>
     * 先确定 2 的数量 cnt2，然后就能得到 upper 和 lower 的 1 的数量
     * <p>
     * upper1 = upper - cnt2
     * <p>
     * lower1 = lower - cnt2
     * <p>
     * 遇到 1 的时候，就看 upper1 和 lower1 的数量来决定放哪里
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:7 ms,击败了84.78% 的Java用户
     * 内存消耗:56.5 MB,击败了78.26% 的Java用户
     */
    @TestCase(input = {"2", "1", "[1,1,1]", "2", "3", "[2,2,1,1]", "5", "5", "[2,1,2,0,1,0,1,2,0,1]"},
            output = {"[[1,1,0],[0,0,1]]", "[]", "[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]"})
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int cnt2 = 0;
        for (int c : colsum) {
            if (c == 2) {
                cnt2++;
            }
        }
        int upper1 = upper - cnt2;
        int lower1 = lower - cnt2;
        int n = colsum.length;
        int[] us = new int[n];
        int[] ls = new int[n];
        for (int i = 0; i < n && upper1 >= 0 && lower1 >= 0; i++) {
            if (colsum[i] == 2) {
                us[i] = 1;
                ls[i] = 1;
            } else if (colsum[i] == 1) {
                if (upper1 > 0) {
                    us[i] = 1;
                    upper1--;
                } else {
                    ls[i] = 1;
                    lower1--;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(2);
        if (upper1 == 0 && lower1 == 0) {
            List<Integer> ul = new ArrayList<>(n);
            List<Integer> ll = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                ul.add(us[i]);
                ll.add(ls[i]);
            }
            ans.add(ul);
            ans.add(ll);
        }
        return ans;
    }

}

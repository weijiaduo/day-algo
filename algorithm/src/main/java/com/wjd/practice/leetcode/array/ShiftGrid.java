package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * <p>
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * <p>
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 *
 * @author weijiaduo
 * @since 2022/7/20
 */
public class ShiftGrid implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k = 4;
        List<List<Integer>> result = shiftGrid(grid, k);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：把二维表看成一条数组，二维表迁移，实际就是数组向右迁移。
     * 先把迁移后的数字按顺序读出来，再重新拆分成二维表
     * <p>
     * 复杂度：时间 O(mn) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了86.68% 的Java用户
     * 内存消耗:42.4 MB,击败了16.25% 的Java用户
     *
     * @param grid 二维表
     * @param k    迁移参数
     * @return 迁移后的二维表
     */
    private List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (grid.length == 0 || grid[0].length == 0) {
            return ans;
        }

        int m = grid.length, n = grid[0].length;
        int size = m * n;
        k = k % size;

        // 按移动后的顺序排成一条
        List<Integer> nums = new ArrayList<>(size);
        for (int i = size - k, j = 0; j < size; i++, j++) {
            nums.add(grid[i % size / n][i % n]);
        }
        // 重新拆分成 m*n 的矩阵
        for (int i = 0, j = 0; i < m; i++, j += n) {
            ans.add(nums.subList(j, j + n));
        }
        return ans;
    }

}

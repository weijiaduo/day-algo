package com.wjd.practice.book.cracking.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 08.02. 迷路的机器人
 * <p>
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。
 * <p>
 * 机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * <p>
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * <p>
 * 说明：r 和 c 的值均不超过 100。
 *
 * @author weijiaduo
 * @since 2023/12/28
 */
public class PathWithObstacles {

    /**
     * 思路：回溯
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:1 ms,击败了97.09% 的Java用户
     * 内存消耗:43.7 MB,击败了13.11% 的Java用户
     */
    @TestCase(input = {"[[0,0,0],[0,1,0],[0,0,0]]"},
            output = {"[[0,0],[0,1],[0,2],[1,2],[2,2]]"})
    public List<List<Integer>> backtrack(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        List<List<Integer>> path = new ArrayList<>(m + n);
        backtrack(obstacleGrid, 0, 0, new boolean[m][n], path);
        return path;
    }

    /**
     * 回溯遍历
     *
     * @param grid    网格
     * @param i       行索引
     * @param j       列索引
     * @param visited 访问标记
     * @param path    访问路径
     * @return 是否找到了目标
     */
    private boolean backtrack(int[][] grid, int i, int j, boolean[][] visited, List<List<Integer>> path) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (visited[i][j] || grid[i][j] == 1) {
            return false;
        }

        // 验证是否找到目标
        visited[i][j] = true;
        path.add(Arrays.asList(i, j));
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }

        // 向右向下寻找
        boolean found = backtrack(grid, i, j + 1, visited, path)
                        || backtrack(grid, i + 1, j, visited, path);
        if (!found) {
            // 找到后不移除路径；没找到则需要回溯路径
            path.remove(path.size() - 1);
        }
        return found;
    }

}

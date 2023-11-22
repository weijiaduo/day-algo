package com.wjd.practice.book.sword.backtrack;

import com.wjd.practice.TestCase;

/**
 * 13. 机器人的运动范围
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * <p>
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * <p>
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class RobotMovingCount {

    /**
     * 思路：回溯法，遍历每个格子，判断是否可以进入
     * <p>
     * 复杂度：时间 O(mn)，空间 O(mn)
     */
    @TestCase(input = {"18", "40", "40"}, output = {"1484"})
    public int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0) {
                    count += backtrack(threshold, rows, cols, i, j, visited);
                }
            }
        }
        return count;
    }

    /**
     * 回溯遍历
     *
     * @param threshold 阈值
     * @param rows      行数
     * @param cols      列数
     * @param i         行号
     * @param j         列号
     * @param visited   访问标记
     * @return 可以进入的格子数
     */
    private int backtrack(int threshold, int rows, int cols, int i, int j, int[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }
        // 0未访问，1已访问，2不可进入
        if (visited[i][j] != 0) {
            return 0;
        }
        if (!canEnter(threshold, i, j)) {
            visited[i][j] = 2;
            return 0;
        }

        visited[i][j] = 1;
        int cnt = 1;
        // 上
        cnt += backtrack(threshold, rows, cols, i - 1, j, visited);
        // 右
        cnt += backtrack(threshold, rows, cols, i, j + 1, visited);
        // 下
        cnt += backtrack(threshold, rows, cols, i + 1, j, visited);
        // 左
        cnt += backtrack(threshold, rows, cols, i, j - 1, visited);
        return cnt;
    }

    /**
     * 是否可以进入
     *
     * @param threshold 阈值
     * @param x         行
     * @param y         列
     * @return 是否可以进入
     */
    private boolean canEnter(int threshold, int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= threshold;
    }

}

package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

/**
 * 1037. 有效的回旋镖
 * <p>
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * <p>
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 * <p>
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * <p>
 * @since 2022/6/8
 */
public class IsBoomerang implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int[][] points = {{0,1},{1,1},{2,2}};
        boolean result = isBoomerang(points);
        System.out.println(result);
        return result;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了61.34% 的Java用户
     */
    public boolean isBoomerang(int[][] points) {
        // 相同
        if (points[0][0] == points[1][0] && points[0][1] == points[1][1]
                || points[1][0] == points[2][0] && points[1][1] == points[2][1]
                || points[2][0] == points[0][0] && points[2][1] == points[0][1]) {
            return false;
        }

        // 垂直
        if (points[0][0] == points[1][0] || points[0][0] == points[2][0]) {
            return points[1][0] != points[2][0];
        }

        // 斜率
        return (points[0][1] - points[1][1]) * (points[0][0] - points[2][0])
                != (points[0][1] - points[2][1]) * (points[0][0] - points[1][0]);
    }

    /**
     * 向量叉乘
     */
    private boolean isBoomerang2(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

}

package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * @since 2022/5/15
 * 812. 最大三角形面积
 * <p>
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * <p>
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * <p>
 * 输出: 2
 */
public class LargestTriangleArea implements Solution<Double> {

    @Override
    public Double solve(Object ...args) {
        int[][] points = {
                {0, 0},
                {0, 1},
                {1, 0},
                {0, 2},
                {2, 0}
        };
        double result = largestTriangleArea(points);
        System.out.println(result);
        return result;
    }

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    int[] c = points[k];
                    double r = triangleArea(a[0], a[1], b[0], b[1], c[0], c[1]);
                    if (r > maxArea) {
                        maxArea = r;
                    }
                }
            }
        }
        return maxArea;
    }

    private double distance(int[] a, int[] b) {
        return Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }

    private double area(double ab, double ac, double bc) {
        double s = (ab + ac + bc) / 2;
        return Math.sqrt(s * (s - ab) * (s - ac) * (s - bc));
    }

    /**
     * 行列式面积法
     */
    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

}

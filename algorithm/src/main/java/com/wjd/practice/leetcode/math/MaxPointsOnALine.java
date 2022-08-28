package com.wjd.practice.leetcode.math;

/**
 * 求在一条直线上的点的最大数量
 */
public class MaxPointsOnALine {

    static class Point {

        public int x;
        public int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        String a = "fdsadsadas";
        // System.out.println(a);
    }

    /**
     * 在同一条直线上的点的最大数量
     */
    public static int maxPoints(Point[] points) {
        if (points == null) {
            return -1;
        }

        if (points.length <= 2) {
            return points.length;
        }

        int maxNum = 0, num;
        for (int i = 0; i < points.length; i++) {
            int count = 1; //等于point[i]的数量
            for (int j = i + 1; j < points.length; j++) {
                num = count + 1;

                // 下一个不等于point[i]的索引，以及（i，j）之间等于point[i]的数量
                if (isSamePoint(points[i], points[j])) {
                    count++;
                } else {
                    for (int k = j + 1; k < points.length; k++) {
                        if (isOnALine(points[i], points[j], points[k])) {
                            num++;
                        }
                    }
                }

                if (num > maxNum) {
                    maxNum = num;
                }
            }
        }

        return maxNum;
    }

    /**
     * 是否是同一个点
     */
    public static boolean isSamePoint(Point p1, Point p2) {
        if (p1 == p2) {
            return true;
        }
        if (p1 != null && p2 == null || p1 == null && p2 != null) {
            return false;
        }

        return (p1.x == p2.x && p1.y == p2.y);
    }

    /**
     * 是否在同一条直线上
     */
    public static boolean isOnALine(Point p1, Point p2, Point p3) {
        if (p1 == null || p2 == null || p3 == null) {
            return false;
        }

        int r1 = (p1.y - p2.y) * (p1.x - p3.x);
        int r2 = (p1.y - p3.y) * (p1.x - p2.x);

        return (r1 == r2);
    }
}

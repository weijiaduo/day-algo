package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *
 * @author weijiaduo
 * @since 2022/6/29
 */
public class MaxPoints implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int result = maxPoints(points);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：统计所有点的斜率，斜率用分子分母表示（double精度会丢失）
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:108 ms,击败了5.16% 的Java用户
     * 内存消耗:41.6 MB,击败了26.52% 的Java用户
     */
    private int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int maxCount = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            Map<Gradient, Integer> counts = new HashMap<>(n - i);
            for (int j = i + 1; j < n; j++) {
                Gradient g = calcGradient(points[i], points[j]);
                counts.put(g, counts.getOrDefault(g, 1) + 1);
            }
            for (Gradient g : counts.keySet()) {
                maxCount = Math.max(counts.get(g), maxCount);
            }
            // 快速剪枝，后面再怎么算也不会超过最大值了
            if (maxCount >= n - i - 1 || maxCount > n / 2) {
                break;
            }
        }
        return maxCount;
    }

    /**
     * 计算两点的斜率
     */
    private Gradient calcGradient(int[] point1, int[] point2) {
        int numerator = point1[1] - point2[1];
        int denominator = point1[0] - point2[0];
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        return new Gradient(numerator, denominator);
    }

    static class Gradient {
        /**
         * 分子
         */
        int numerator;
        /**
         * 分母
         */
        int denominator;

        public Gradient(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Gradient)) {
                return false;
            }
            Gradient g = (Gradient) obj;
            // 斜率相同：分母为0/分母不为0
            return (this.denominator == 0 && g.denominator == 0)
                    || (this.numerator * g.denominator == g.numerator * this.denominator);
        }

        @Override
        public int hashCode() {
            return denominator == 0 ? Objects.hash(0) : Objects.hash(numerator / denominator);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

}

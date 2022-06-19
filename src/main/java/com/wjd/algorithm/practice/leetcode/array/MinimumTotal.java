package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * <p>
 * @since 2022/6/19
 */
public class MinimumTotal implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        Integer[][] values = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (Integer[] value : values) {
            triangle.add(Arrays.asList(value));
        }
        int result = minimumTotal3(triangle);
        System.out.println(result);
        return null;
    }

    /**
     * 思路：使用二维数据计算路径上的和
     *
     * 执行耗时:4 ms,击败了32.52% 的Java用户
     * 内存消耗:41.3 MB,击败了15.78% 的Java用户
     */
    private int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int n = triangle.get(triangle.size() - 1).size();
        int[][] totals = new int[n][n];
        int i = 0, j;
        for (List<Integer> level : triangle) {
            j = 0;
            for (Integer val : level) {
                if (i == 0) {
                    totals[i][j] = val;
                } else if (j == 0) {
                    totals[i][j] = totals[i - 1][j] + val;
                } else if (j == i) {
                    totals[i][j] = totals[i - 1][j - 1] + val;
                } else {
                    totals[i][j] = Math.min(totals[i - 1][j], totals[i - 1][j - 1]) + val;
                }
                j++;
            }
            i++;
        }
        return Arrays.stream(totals[totals.length - 1]).min().getAsInt();
    }

    /**
     * 思路：把二维数组压缩成一维数组，减低空间复杂度
     *
     * 执行耗时:3 ms,击败了77.52% 的Java用户
     * 内存消耗:41.3 MB,击败了14.13% 的Java用
     */
    private int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int n = triangle.get(triangle.size() - 1).size();
        int[] totals = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> level = triangle.get(i);
            for (int j = level.size() - 1; j >= 0; j--) {
                int val = level.get(j);
                if (j > 0) {
                    if (j < i) {
                        totals[j] = Math.min(totals[j], totals[j - 1]);
                    } else if (j == i) {
                        totals[j] = totals[j - 1];
                    }
                }
                totals[j] += val;
            }
        }
        return Arrays.stream(totals).min().getAsInt();
    }

    /**
     * 思路：自底向上计算最小值，避免后面还要遍历一次
     *
     * 执行耗时:2 ms,击败了95.91% 的Java用户
     * 内存消耗:41.3 MB,击败了8.81% 的Java用户
     */
    private int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        int size = triangle.size();
        int n = triangle.get(size - 1).size();
        int[] totals = new int[n];
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                if (i == size - 1) {
                    totals[j] = level.get(j);
                } else {
                    totals[j] = Math.min(totals[j], totals[j + 1]) + level.get(j);
                }
            }
        }
        return totals[0];
    }

}

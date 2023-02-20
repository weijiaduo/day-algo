package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * <p>
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * <p>
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 * 你必须找到一个内存复杂度优于 O(n²) 的解决方案。
 * <p>
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 *
 * @author weijiaduo
 * @since 2022/9/13
 */
public class KthSmallest implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        int result = kthSmallest(matrix, k);
        System.out.println(result);
        return result;
    }

    private int kthSmallest(int[][] matrix, int k) {
        return heapKthSmallest(matrix, k);
    }

    /**
     * 思路：维护一个大小为k的最大值堆
     * <p>
     * 复杂度：时间 O(mn) 空间 O(k)
     * <p>
     * 执行耗时:16 ms,击败了31.99% 的Java用户
     * 内存消耗:46 MB,击败了92.22% 的Java用户
     *
     * @param matrix 矩阵
     * @param k      k
     * @return 第k小元素
     */
    private int heapKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

}

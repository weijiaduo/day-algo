package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.ListNode;
import com.wjd.util.ArrayUtil;

import java.util.Arrays;

/**
 * 周赛300
 * <p>
 * 6111. 螺旋矩阵4
 * <p>
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 * <p>
 * 另给你一个整数链表的头节点 head 。
 * <p>
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 * <p>
 * 返回生成的矩阵。
 * <p>
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 *
 * @author weijiaduo
 * @since 2022/7/3
 */
public class SpiralMatrix implements Solution<int[][]> {

    @Override
    public int[][] solve(Object... args) {
        int m = 1;
        int n = 4;
        int[] values = {3, 0, 2};
        ListNode head = ListNode.build(values);
        int[][] result = spiralMatrix(m, n, head);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 思路：记录四边的索引值，然后按上->右->下->左为一轮循环，直到链尾为止
     */
    private int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        ListNode p = head;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (p != null) {
            // 上边
            for (int j = left; j <= right && p != null; j++) {
                matrix[top][j] = p.val;
                p = p.next;
            }
            top++;
            // 右边
            for (int i = top; i <= bottom && p != null; i++) {
                matrix[i][right] = p.val;
                p = p.next;
            }
            right--;
            // 下边
            for (int j = right; j >= left && p != null; j--) {
                matrix[bottom][j] = p.val;
                p = p.next;
            }
            bottom--;
            // 左边
            for (int i = bottom; i >= top && p != null; i--) {
                matrix[i][left] = p.val;
                p = p.next;
            }
            left++;
        }
        return matrix;
    }

}

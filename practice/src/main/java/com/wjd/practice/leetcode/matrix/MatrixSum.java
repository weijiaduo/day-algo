package com.wjd.practice.leetcode.matrix;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 2679. 矩阵中的和
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。
 * <p>
 * 你需要执行以下操作直到矩阵变为空：
 * <p>
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * <p>
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
 * <p>
 * 请你返回最后的 分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]
 * 输出：15
 * 解释：第一步操作中，我们删除 7 ，6 ，6 和 3 ，将分数增加 7 。下一步操作中，删除 2 ，4 ，5 和 2 ，将分数增加 5 。最后删除 1 ，2
 * ，3 和 1 ，将分数增加 3 。所以总得分为 7 + 5 + 3 = 15 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [[1]]
 * 输出：1
 * 解释：我们删除 1 并将分数增加 1 ，所以返回 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 300
 * 1 <= nums[i].length <= 500
 * 0 <= nums[i][j] <= 10³
 *
 * @author weijiaduo
 * @since 2023/7/4
 */
public class MatrixSum {

    /**
     * 思路：给每一行排序，每次移除的最大值就是每行最后面的那个
     * <p>
     * 复杂度：时间 O(mnlogn + mn) 空间 O(1)
     * <p>
     * 执行耗时:13 ms,击败了96.93% 的Java用户
     * 内存消耗:55.4 MB,击败了41.42% 的Java用户
     */
    @TestCase(input = {"[[7,2,1],[6,4,2],[6,5,3],[3,2,1]]", "[[1]]"},
            output = {"15", "1"})
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int sum = 0;
        int m = nums.length, n = nums[0].length;
        for (int j = n - 1; j >= 0; j--) {
            int max = nums[0][j];
            for (int i = 1; i < m; i++) {
                max = Math.max(nums[i][j], max);
            }
            sum += max;
        }
        return sum;
    }

}

package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;

/**
 * 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * <p>
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class VerifySequenceOfBST {

    /**
     * 思路：后序遍历的最后一个节点是根节点，前面的节点分为两部分，一部分是左子树，一部分是右子树
     * <p>
     * 利用根节点，将前面的节点分为两部分，左子树的节点都小于根节点，右子树的节点都大于根节点
     * <p>
     * 然后递归判断左右子树是否满足上述条件
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = "[5,7,6,9,11,10,8]",
            output = "true")
    public boolean verify(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    /**
     * 验证序列是否满足二叉搜索树的条件
     *
     * @param sequence 序列
     * @param start    [start, end]
     * @param end      [start, end]
     * @return 是否满足二叉搜索树的条件
     */
    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        int root = sequence[end];
        // 左子树的节点都小于根节点
        int left = start;
        while (left < end && sequence[left] < root) {
            left++;
        }
        // 右子树的节点都大于根节点
        int right = left;
        while (right < end) {
            if (sequence[right++] <= root) {
                return false;
            }
        }

        return verify(sequence, start, left - 1)
               && verify(sequence, left, end - 1);
    }

}

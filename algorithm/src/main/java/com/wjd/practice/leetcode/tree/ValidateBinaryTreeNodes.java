package com.wjd.practice.leetcode.tree;

import java.util.Arrays;

/**
 * 1361. 验证二叉树
 * <p>
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * <p>
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * <p>
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * <p>
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * <p>
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 *
 * @author weijiaduo
 * @since 2022/12/4
 */
public class ValidateBinaryTreeNodes {

    /**
     * 思路：想要形成一棵二叉树，有 3 个要素：
     * 1. 每个节点只能有 1 个父节点
     * 2. 只有 1 个根节点
     * 3. 节点不能循环
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:4 ms,击败了78.59% 的Java用户
     * 内存消耗:42.2 MB,击败了91.20% 的Java用户
     */
    public boolean solve(int n, int[] leftChild, int[] rightChild) {
        int[] ufs = new int[n];
        Arrays.fill(ufs, -1);

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            if (left != -1 && !find(ufs, i, left)) {
                return false;
            }
            int right = rightChild[i];
            if (right != -1 && !find(ufs, i, right)) {
                return false;
            }
        }

        // 只有 1 个根节点
        int count = 0;
        for (int i = 0; i < n && count < 2; i++) {
            if (ufs[i] == -1) {
                count++;
            }
        }
        return count == 1;
    }

    /**
     * 查找父子关系，验证是否有多个父节点和循环
     *
     * @param ufs    父子关系数组
     * @param parent 父索引
     * @param child  子索引
     */
    private boolean find(int[] ufs, int parent, int child) {
        // 每个节点只能有 1 个父节点
        if (ufs[child] != -1) {
            return false;
        } else {
            // 节点不能循环
            int p = parent;
            while (p != -1) {
                if (p == child) {
                    return false;
                }
                p = ufs[p];
            }
            ufs[child] = parent;
        }
        return true;
    }

}

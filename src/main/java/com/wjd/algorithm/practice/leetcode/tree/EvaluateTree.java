package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

/**
 * 双周赛 82
 * <p>
 * 6116. 计算布尔二叉树的值
 * <p>
 * 给你一棵 完整二叉树的根，这棵树有以下特征：
 * <p>
 * 叶子节点要么值为0要么值为1，其中0 表示False，1 表示True。
 * 非叶子节点 要么值为 2要么值为 3，其中2表示逻辑或OR ，3表示逻辑与AND。
 * 计算一个节点的值方式如下：
 * <p>
 * 如果节点是个叶子节点，那么节点的 值为它本身，即True或者False。
 * 否则，计算两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算。
 * 返回根节点root的布尔运算值。
 * <p>
 * 输入：root = [2,1,3,null,null,0,1]
 * 输出：true
 * 解释：上图展示了计算过程。
 * AND 与运算节点的值为 False AND True = False 。
 * OR 运算节点的值为 True OR False = True 。
 * 根节点的值为 True ，所以我们返回 true 。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class EvaluateTree implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        Integer[] values = {2, 1, 3, null, null, 0, 1};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        boolean result = evaluateTree(root);
        System.out.println(result);
        return result;
    }

    private boolean evaluateTree(TreeNode root) {
        return dfs(root) == 1;
    }

    /**
     * 思路：后序遍历树即可，先得到子树的结果，再判断根节点
     * <p>
     * 复杂度：时间 O(h) 空间 O(1)
     */
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        if (root.val == 2) {
            return (l + r) > 0 ? 1 : 0;
        } else {
            return (l + r) == 2 ? 1 : 0;
        }
    }

}

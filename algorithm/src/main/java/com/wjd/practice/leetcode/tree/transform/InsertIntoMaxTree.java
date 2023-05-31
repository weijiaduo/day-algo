package com.wjd.practice.leetcode.tree.transform;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 998. 最大二叉树2
 * <p>
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回 null 。
 * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
 * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回 root 。
 * <p>
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回 Construct(b) 。
 * <p>
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 *
 * @author weijiaduo
 * @since 2022/8/30
 */
public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return binaryInsert(root, val);
    }

    /**
     * 思路：递归寻找合适的插入点，并返回插入节点。一直往右子树寻找插入点，因为val是追加在数组最后面的
     * <p>
     * 复杂度：时间 O(logn) 空间 O(h)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了82.37% 的Java用户
     *
     * @param root 根节点
     * @param val  插入值
     * @return 新树根节点
     */
    private TreeNode binaryInsert(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        // 因为是插入最后，所以只会插入到右子树
        root.right = binaryInsert(root.right, val);
        return root;
    }

}

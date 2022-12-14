package com.wjd.structure.tree.bst;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 二叉搜索树实现
 *
 * @author weijiaduo
 * @since 2022/12/14
 */
public class BSTreeImpl implements BSTree {

    /**
     * 根节点
     */
    private TreeNode root;

    public BSTreeImpl() {
    }

    public BSTreeImpl(int[] values) {
        for (int val : values) {
            insert(val);
        }
    }

    /**
     * 获取根节点
     *
     * @return 根节点
     */
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public TreeNode query(int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    @Override
    public TreeNode delete(int val) {
        TreeNode node = root, parent = null;
        while (node != null) {
            if (node.val == val) {
                deleteNode(node, parent);
                return node;
            } else if (node.val > val) {
                parent = node;
                node = node.left;
            } else {
                parent = node;
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 删除指定节点
     *
     * @param node   被删除节点
     * @param parent 被删除节点的父节点
     */
    private void deleteNode(TreeNode node, TreeNode parent) {
        if (node.left == null && node.right == null) {
            // 被删除节点没有子节点
            if (parent == null) {
                root = null;
            } else {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (node.left == null) {
            // 被删除节点左子树为空
            if (parent == null) {
                root = node.right;
            } else {
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
            node.right = null;
        } else if (node.right == null) {
            // 被删除节点右子树为空
            if (parent == null) {
                root = node.left;
            } else {
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
            node.left = null;
        } else {
            // 先移除当前节点右边的最小值
            TreeNode next = node.right, pp = null;
            while (next.left != null) {
                pp = next;
                next = next.left;
            }
            if (pp == null) {
                node.right = next.right;
            } else {
                pp.left = next.right;
            }
            next.right = null;

            // 再用右边最小值替代被删除节点
            next.left = node.left;
            next.right = node.right;
            if (parent == null) {
                root = next;
            } else {
                if (parent.left == node) {
                    parent.left = next;
                } else {
                    parent.right = next;
                }
            }
            node.left = node.right = null;
        }
    }

    @Override
    public TreeNode insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        // 已存在相同值时不插入
        TreeNode node = root;
        while (node.val != val) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return node.left;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return node.right;
                } else {
                    node = node.right;
                }
            }
        }
        return null;
    }

}

package com.wjd.structure.tree.redblack;

import com.wjd.algorithm.tree.redblack.traverse.BuildLevelRedBlackTraverse;

/**
 * 简单红黑树（2-3树）
 * <p>
 * 1. 红链接只能出现在左边
 * <p>
 * 2. 不能出现 2 条相邻的红链接
 *
 * @author weijiaduo
 * @since 2023/1/24
 */
public class SimpleRBTreeImpl implements RBTree {

    /**
     * 红色
     */
    private static final boolean RED = true;
    /**
     * 黑色
     */
    private static final boolean BLACK = false;

    /**
     * 根节点
     */
    private RBTNode root;

    @Override
    public Integer get(int val) {
        RBTNode node = get(root, val);
        return node != null ? node.val : null;
    }

    /**
     * 查找指定值对应的节点
     *
     * @param root 根节点
     * @param val  指定值
     * @return 指定值的节点
     */
    private RBTNode get(RBTNode root, int val) {
        // 没有找到
        if (root == null) {
            return null;
        }
        // 找到对应的节点
        if (root.val == val) {
            return root;
        }
        // 递归二分查找
        if (root.val > val) {
            return get(root.left, val);
        } else {
            return get(root.right, val);
        }
    }

    @Override
    public void insert(int val) {
        root = insert(root, val);
        root.color = BLACK;
    }

    /**
     * 插入新数据
     *
     * @param root 根节点
     * @param val  新数据
     * @return 新根节点
     */
    private RBTNode insert(RBTNode root, int val) {
        // 插入新叶子节点
        if (root == null) {
            return new RBTNode(val);
        }
        // 值已存在，直接返回
        if (root.val == val) {
            return root;
        }
        // 递归插入
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        // 平衡红黑树结构
        return balance(root);
    }

    @Override
    public void remove(int val) {
        if (get(val) == null) {
            return;
        }

        // 确保传给 remove(root) 的是 3-节点
        if (root != null && !hasRed(root)) {
            root.color = RED;
        }
        root = remove(root, val);
        if (isRed(root)) {
            root.color = BLACK;
        }
    }

    /**
     * 删除指定值的节点
     *
     * @param root 根节点，保证 root 是 3-节点，或者 null
     * @param val  指定值
     * @return 新根节点
     */
    private RBTNode remove(RBTNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            // 找到对应的删除节点
            return removeNode(root);
        }
        if (root.val > val) {
            // 删除节点在左子树中
            if (!hasRed(root.left)) {
                // 左子节点是 2-节点，递归前需先转成 3/4-节点
                root = moveRedLeft(root);
            }
            root.left = remove(root.left, val);
        } else {
            // 删除节点在右子树中
            if (isRed(root.left)) {
                // 红色节点在左边，先临时转到右边
                root = rotateRight(root);
            }
            if (!hasRed(root.right)) {
                // 右子节点是 2-节点，递归前需先转成 3/4-节点
                root = moveRedRight(root);
            }
            root.right = remove(root.right, val);
        }
        return balance(root);
    }

    /**
     * 删除指定节点
     *
     * @param node 指定删除节点
     * @return 新根节点
     */
    private RBTNode removeNode(RBTNode node) {
        if (isRed(node)) {
            // 被删除节点是红色，叶子节点直接删除
            if (node.right == null) {
                return null;
            }
            // 内部节点，用后继节点替换删除
            final int delVal = node.val;
            if (!hasRed(node.right)) {
                // 确保 deleteMin 时是 3/4-节点
                node = moveRedRight(node);
            }
            if (node.val == delVal) {
                // 节点没变，用后继节点替换删除
                RBTNode t = min(node.right);
                t.right = deleteMin(node.right);
                t.left = node.left;
                t.color = node.color;
                node = t;
            } else {
                // 节点被右旋走了，递归删除
                node.right = removeNode(node.right);
            }
        } else {
            // 被删除节点是黑色，转成红色再删除
            node = rotateRight(node);
            node.right = removeNode(node.right);
        }
        return balance(node);
    }

    /**
     * 最小值节点
     *
     * @param root 当前节点
     * @return 最小值节点
     */
    private RBTNode min(RBTNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        return min(root.left);
    }

    /**
     * 删除最小值节点
     */
    public void deleteMin() {
        // 确保传给 deleteMin(root) 的是 3-节点
        if (root != null && !hasRed(root)) {
            root.color = RED;
        }
        root = deleteMin(root);
        // 保证根节点始终是黑色
        if (isRed(root)) {
            root.color = BLACK;
        }
    }

    /**
     * 删除最小值节点
     *
     * @param root 父节点，保证 root 是 3-节点，或者 null
     * @return 新父节点
     */
    private RBTNode deleteMin(RBTNode root) {
        if (root == null) {
            return null;
        }
        // 找到最小值节点
        if (root.left == null) {
            return null;
        }
        // 左子节点是 2-节点，递归前需先转成 3/4-节点
        if (!hasRed(root.left)) {
            root = moveRedLeft(root);
        }
        // 递归删除最小值
        root.left = deleteMin(root.left);
        return balance(root);
    }

    /**
     * 删除最大值节点
     */
    public void deleteMax() {
        // 确保传给 deleteMax(root) 的是 3-节点
        if (root != null && !hasRed(root)) {
            root.color = RED;
        }
        root = deleteMax(root);
        // 保证根节点始终是黑色
        if (isRed(root)) {
            root.color = BLACK;
        }
    }

    /**
     * 删除最大值节点
     *
     * @param root 父节点，保证 root 是 3-节点，或者 null
     * @return 新父节点
     */
    private RBTNode deleteMax(RBTNode root) {
        if (root == null) {
            return null;
        }
        // 红色节点在左边，先临时转到右边
        if (isRed(root.left)) {
            root = rotateRight(root);
        }
        // 找到最大值节点
        if (root.right == null) {
            return null;
        }
        // 右子节点是 2-节点，递归前需先转成 3/4-节点
        if (!hasRed(root.right)) {
            root = moveRedRight(root);
        }
        // 递归删除最大值
        root.right = deleteMax(root.right);
        return balance(root);
    }

    /**
     * 左子节点（root.left）是 2-节点，转一个红色节点到左边
     * <p>
     * 1. 从右兄弟借一个
     * <p>
     * 2. 合并根左右节点
     *
     * @param root 父节点
     * @return 新父节点
     */
    private RBTNode moveRedLeft(RBTNode root) {
        if (isRed(root.right.left)) {
            // 右子节点是 3-节点，借一个给左子节点
            flipColor(root, BLACK);
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        } else {
            // 右子节点也是 2-节点，合并根左右节点，临时转成 4-节点
            flipColor(root, BLACK);
        }
        return root;
    }

    /**
     * 右子节点（root.right）是 2-节点，转一个红色节点到右边
     * <p>
     * 1. 从左兄弟借一个
     * <p>
     * 2. 合并根左右节点
     *
     * @param root 父节点
     * @return 新父节点
     */
    private RBTNode moveRedRight(RBTNode root) {
        if (isRed(root.left.left)) {
            // 左子节点是 3-节点，借一个给右子节点
            flipColor(root, BLACK);
            root = rotateRight(root);
        } else {
            // 左子节点也是 2-节点，合并根左右节点，临时转成 4-节点
            flipColor(root, BLACK);
        }
        return root;
    }

    /**
     * 修正红黑树，平衡树结构
     *
     * @param root 根节点
     * @return 新根节点
     */
    private RBTNode balance(RBTNode root) {
        if (root == null) {
            return null;
        }
        // 红节点在右边（2-节点”右插入“/3-节点”中插入“）
        if (isRed(root.right)) {
            root = rotateLeft(root);
        }
        // 连续 2 个红节点（3-节点”左插入“）
        if (isRed(root.left) && isRed(root.left.left)) {
            root = rotateRight(root);
        }
        // 左右两个红节点（3-节点“右插入”）
        if (isRed(root.left) && isRed(root.right)) {
            flipColor(root, RED);
        }
        return root;
    }

    /**
     * 左旋（红节点转到左边）
     *
     * @param root 父节点
     * @return 新父节点
     */
    RBTNode rotateLeft(RBTNode root) {
        RBTNode right = root.right;
        root.right = right.left;
        right.left = root;
        right.color = root.color;
        root.color = RED;
        return right;
    }

    /**
     * 右旋（红节点转到右边）
     *
     * @param root 父节点
     * @return 新父节点
     */
    RBTNode rotateRight(RBTNode root) {
        RBTNode left = root.left;
        root.left = left.right;
        left.right = root;
        left.color = root.color;
        root.color = RED;
        return left;
    }

    /**
     * 1. 父节点染红，子节点染黑
     * <p>
     * 2. 父节点染黑，子节点染红
     *
     * @param root  父节点
     * @param color 父节点颜色
     */
    private void flipColor(RBTNode root, boolean color) {
        root.color = color;
        root.left.color = !color;
        root.right.color = !color;
    }

    /**
     * 是否有红色节点（是否是 3-节点）
     *
     * @param node 节点
     * @return true有红色/false无红色
     */
    private boolean hasRed(RBTNode node) {
        if (node == null) {
            return false;
        }
        // 当前节点或者左子节点是红色
        return isRed(node) || isRed(node.left);
    }

    /**
     * 是否是红色节点
     *
     * @param node 节点
     * @return true红色节点/false黑色节点
     */
    private boolean isRed(RBTNode node) {
        return node != null && node.color == RED;
    }

    @Override
    public String toString() {
        return new BuildLevelRedBlackTraverse().traverse(root).toString();
    }

}

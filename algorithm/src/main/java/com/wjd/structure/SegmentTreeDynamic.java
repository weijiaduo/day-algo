package com.wjd.structure;

/**
 * 线段树模板
 *
 * @author weijiaduo
 * @since 2022/7/7
 */
public class SegmentTreeDynamic {

    static class Node {
        /**
         * 左右节点
         */
        Node left, right;
        /**
         * 节点值
         */
        int val;
        /**
         * 懒惰标记
         */
        int add;
    }

    /**
     * 更新指定区间的值
     * @param node 当前节点
     * @param start 当前区间[start, end]的左边界
     * @param end 当前区间[start, end]的右边界
     * @param l 目标区间[l, r]的左边界
     * @param r 目标区间[l, r]的右边界
     * @param val 更新的值
     */
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            // 区间值更新，包括了子节点的值更新总和
            node.val += (end - start + 1) * val;
            // 懒惰标记
            node.add += val;
            return;
        }

        int mid = start + (end - start) / 2;
        // 同步父节点的懒惰标记到子节点
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            // 遍历左区间
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            // 遍历右区间
            update(node.right, mid + 1, end, l, r, val);
        }
        // 同步更新子节点数据到父节点
        pushUp(node);
    }

    /**
     * 查询指定区间的值
     * @param node 当前节点
     * @param start 当前区间[start, end]的左边界
     * @param end 当前区间[start, end]的右边界
     * @param l 目标区间[l, r]的左边界
     * @param r 目标区间[l, r]的右边界
     * @return 区间值
     */
    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }

        int ans = 0;
        int mid = start + (end - start) / 2;
        // 同步父节点的懒惰标记到子节点
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            // 遍历左区间
            ans += query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            // 遍历右区间
            ans += query(node.right, mid + 1, end, l, r);
        }
        return ans;
    }

    /**
     * 子节点的值上推到父节点
     * @param node 父节点
     */
    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    /**
     * 父节点的值下推到子节点
     * @param node 父节点
     * @param leftNum 左子节点值
     * @param rightNum 右子节点值
     */
    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.val += node.add * leftNum;
        node.right.val += node.add * rightNum;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

}

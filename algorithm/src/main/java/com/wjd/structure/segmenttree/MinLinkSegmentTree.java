package com.wjd.structure.segmenttree;

/**
 * 区间最小值线段树
 *
 * @author weijiaduo
 * @since 2022/9/12
 */
public class MinLinkSegmentTree extends LinkSegmentTree {

    public MinLinkSegmentTree(int low, int high) {
        super(low, high);
    }

    @Override
    protected int mergeQuery(Node node, int start, int end, Integer lVal, Integer rVal) {
        int min = high + 1;
        if (lVal != null) {
            min = lVal;
        }
        if (rVal != null) {
            min = Math.min(rVal, min);
        }
        return min;
    }

    @Override
    protected void writeUp(Node node, int start, int end) {
        node.val = Math.min(node.left.val, node.right.val);
    }

    @Override
    protected void writeDown(Node node, int start, int end, int val) {
        node.val = val;
        node.add = val;
    }
}

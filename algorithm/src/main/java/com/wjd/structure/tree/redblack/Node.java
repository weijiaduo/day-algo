package com.wjd.structure.tree.redblack;

/**
 * 红黑树节点
 */
public class Node {

    /**
     * 父节点
     */
    public Node parent;
    /**
     * 左子节点
     */
    public Node left;
    /**
     * 右子节点
     */
    public Node right;
    /**
     * 节点值
     */
    public int val;
    /**
     * 是否是红色节点
     */
    public boolean isRed;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    @Override
    public String toString() {
        String type = isRed ? "r" : "b";
        return val + type;
    }
}

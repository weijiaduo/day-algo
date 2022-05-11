package com.wjd.algorithm.structure.tree.redblack;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    int val;
    boolean isRed;

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

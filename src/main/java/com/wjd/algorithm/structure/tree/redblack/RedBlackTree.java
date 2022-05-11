package com.wjd.algorithm.structure.tree.redblack;

import java.util.*;

public class RedBlackTree {

    /**
     * 根节点
     */
    private Node root;

    private int size;

    /**
     * 红色节点只能是左节点
     */
    private boolean avl = false;

    /**
     * 获取指定值的节点
     *
     * @param val 值
     * @return 节点
     */
    public Node get(int val) {
        Node p = root;
        while (p != null) {
            if (p.getVal() == val) {
                return p;
            }
            if (p.getVal() > val) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        return null;
    }

    /**
     * 插入值
     *
     * @param val 值
     */
    public void insert(int val) {
        Node insertNode = new Node();
        insertNode.setRed(true);
        insertNode.setLeft(null);
        insertNode.setRight(null);
        insertNode.setVal(val);
        boolean success = add(insertNode);
        if (!success) {
            return;
        }

        if (isAvl()) {
            fixUpAVLInsert(insertNode);
        } else {
            fixUpInsert(insertNode);
        }
        size++;
    }

    private void fixUpInsert(Node node) {
        Node parent = node.getParent();
        Node insertNode = node;
        while (parent != null) {
            // 1. 父节点是黑色
            if (isBlack(parent)) {
                break;
            }

            // 2. 父节点是红色
            Node grandparent = parent.getParent();
            if (parent == grandparent.getLeft()) {
                // 父节点是左节点
                // 2.1 插入节点是右节点
                if (insertNode == parent.getRight()) {
                    rotateLeft(parent);

                    // 转到 2.2
                    insertNode = parent;
                    parent = insertNode.getParent();
                    grandparent = parent.getParent();
                }

                // 2.2 插入节点是左节点
                if (insertNode == parent.getLeft()) {
                    rotateRight(grandparent);
                    setRed(parent);
                    setBlack(insertNode);
                    setBlack(grandparent);
                }
            } else {
                // 父节点是右节点
                // 2.1 插入节点是左节点
                if (insertNode == parent.getLeft()) {
                    rotateRight(parent);

                    // 转到 2.2
                    insertNode = parent;
                    parent = insertNode.getParent();
                    grandparent = parent.getParent();
                }

                // 2.2 插入节点是右节点
                if (insertNode == parent.getRight()) {
                    rotateLeft(grandparent);
                    setRed(parent);
                    setBlack(insertNode);
                    setBlack(grandparent);
                }
            }

            insertNode = parent;
            parent = insertNode.getParent();
        }
        setBlack(root);
    }

    private void fixUpAVLInsert(Node node) {
        Node parent = node.getParent();
        Node insertNode = node;
        while (parent != null) {
            if (isBlack(parent)) {
                // 1. 父节点是黑色
                // 1.1 插入节点是左节点，右兄弟节点必是黑色
                if (insertNode == parent.getLeft()) {
                    break;
                }

                // 2.1 插入节点是右节点
                if (isBlack(parent.getLeft())) {
                    // 2.1.1 左兄弟节点是黑色
                    rotateLeft(parent);
                    setBlack(insertNode);
                    setRed(parent);
                } else {
                    // 2.1.2 左兄弟节点是红色
                    setBlack(parent.getLeft());
                    setBlack(parent.getRight());
                    setRed(parent);
                }
            } else {
                // 2. 父节点是红色，则父节点必是左节点，且左兄弟节点必是黑色
                Node grandparent = parent.getParent();
                // 2.1 插入节点是右节点
                if (insertNode == parent.getRight()) {
                    rotateLeft(parent);

                    // 转到 2.2
                    insertNode = parent;
                    parent = insertNode.getParent();
                    grandparent = parent.getParent();
                }

                // 2.2 插入节点是左节点
                if (insertNode == parent.getLeft()) {
                    rotateRight(grandparent);
                    setBlack(parent.getLeft());
                    setBlack(parent.getRight());
                    setRed(parent);
                }
            }

            insertNode = parent;
            parent = insertNode.getParent();
        }
        setBlack(root);
    }

    /**
     * 删除值
     *
     * @param val 值
     */
    public void delete(int val) {
        Node deleteNode = get(val);
        if (deleteNode == null) {
            return;
        }

        // 交换删除节点
        Node exchangeNode = getExchangeNode(deleteNode);
        deleteNode.setVal(exchangeNode.getVal());
        exchangeNode.setVal(val);
        deleteNode = exchangeNode;

        // 修正树结构
        fixUpDelete(deleteNode);

        // 从树中移除节点
        remove(deleteNode);
    }

    private void fixUpDelete(Node node) {
        Node parent = node.getParent();
        Node deleteNode = node;
        while (parent != null) {
            // 1. 删除节点是红色，父节点必是黑色
            if (isRed(deleteNode)) {
                break;
            }

            // 2. 删除节点是黑色，兄弟节点必定存在
            if (deleteNode == parent.getLeft()) {
                // 删除节点是左节点
                Node sibling = parent.getRight();
                Node siblingLeft = sibling.getLeft();
                Node siblingRight = sibling.getRight();

                // 2.1 侄子中存在红色，兄弟节点必是黑色
                if (isRed(siblingLeft) || isRed(siblingRight)) {
                    // 2.1.1 远侄子是黑色，近侄子是红色
                    if (isBlack(siblingRight)) {
                        rotateRight(sibling);

                        // 转到 2.1.2
                        setRed(sibling);
                        setBlack(siblingLeft);
                        sibling = siblingLeft;
                        siblingLeft = sibling.getLeft();
                        siblingRight = sibling.getRight();
                    }

                    // 2.1.2 远侄子是红色
                    rotateLeft(parent);
                    sibling.setRed(parent.isRed());
                    setBlack(parent);
                    setBlack(siblingRight);
                    break;
                }

                // 2.2 兄弟节点是红色
                if (isRed(sibling)) {
                    rotateLeft(parent);
                    sibling.setRed(parent.isRed());
                    setRed(parent);
                    continue;
                }

                // 2.3 兄弟节点是黑色
                if (isRed(parent)) {
                    // 2.3.1 父节点是红色
                    setBlack(parent);
                    setRed(sibling);
                    break;
                } else {
                    // 2.3.2 父节点是黑色
                    setRed(sibling);
                    deleteNode = parent;
                    parent = deleteNode.getParent();
                }
            } else {
                // 删除节点是右节点
                Node sibling = parent.getLeft();
                Node siblingLeft = sibling.getLeft();
                Node siblingRight = sibling.getRight();

                // 2.1 侄子中存在红色，兄弟节点必是黑色
                if (isRed(siblingLeft) || isRed(siblingRight)) {
                    // 2.1.1 远侄子是黑色，近侄子是红色
                    if (isBlack(siblingLeft)) {
                        rotateLeft(sibling);

                        // 转到 2.1.2
                        setRed(sibling);
                        setBlack(siblingRight);
                        sibling = siblingRight;
                        siblingLeft = sibling.getLeft();
                        siblingRight = sibling.getRight();
                    }

                    // 2.1.2 远侄子是红色
                    rotateRight(parent);
                    sibling.setRed(parent.isRed());
                    setBlack(parent);
                    setBlack(siblingLeft);
                    break;
                }

                // 2.2 兄弟节点是红色
                if (isRed(sibling)) {
                    rotateRight(parent);
                    sibling.setRed(parent.isRed());
                    setRed(parent);
                    continue;
                }

                // 2.3 兄弟节点是黑色
                if (isRed(parent)) {
                    // 2.3.1 父节点是红色
                    setBlack(parent);
                    setRed(sibling);
                    break;
                } else {
                    // 2.3.2 父节点是黑色
                    setRed(sibling);
                    deleteNode = parent;
                    parent = deleteNode.getParent();
                }
            }
        }
        setBlack(root);
    }

    private void rotateRight(Node node) {
        if (node == null || node.getLeft() == null) {
            return;
        }
        Node parent = node.getParent();
        Node left = node.getLeft();
        left.setParent(parent);
        if (parent != null) {
            if (node == parent.getLeft()) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
        }
        node.setLeft(left.getRight());
        if (node.getLeft() != null) {
            node.getLeft().setParent(node);
        }
        node.setParent(left);
        left.setRight(node);

        if (node == root) {
            root = left;
        }
    }

    private void rotateLeft(Node node) {
        if (node == null || node.getRight() == null) {
            return;
        }
        Node parent = node.getParent();
        Node right = node.getRight();
        right.setParent(parent);
        if (parent != null) {
            if (node == parent.getLeft()) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
        }
        node.setRight(right.getLeft());
        if (node.getRight() != null) {
            node.getRight().setParent(node);
        }
        node.setParent(right);
        right.setLeft(node);

        if (node == root) {
            root = right;
        }
    }

    /**
     * 添加节点到树中
     *
     * @param node 需要添加的节点
     * @return 是否添加成功 true/false
     */
    private boolean add(Node node) {
        Node parent = root;
        while (parent != null) {
            if (parent.getVal() == node.getVal()) {
                return false;
            }
            Node temp;
            if (parent.getVal() < node.getVal()) {
                temp = parent.getRight();
            } else {
                temp = parent.getLeft();
            }
            if (temp == null) {
                break;
            }
            parent = temp;
        }
        node.setParent(parent);
        if (parent == null) {
            root = node;
        } else {
            if (parent.getVal() < node.getVal()) {
                parent.setRight(node);
            } else {
                parent.setLeft(node);
            }
        }
        return true;
    }

    /**
     * 从树中移除指定节点
     *
     * @param node 移除节点，必须保证是树中的节点
     */
    private void remove(Node node) {
        size--;
        if (node.getParent() == null) {
            root = null;
            return;
        }
        if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(node.getRight());
        } else {
            node.getParent().setRight(node.getLeft());
        }
    }

    /**
     * 获取可交换的节点
     *
     * @param node 需要交换的节点
     * @return 可交换节点
     */
    private Node getExchangeNode(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return node;
        }
        Node exchangeNode;
        if (node.getRight() != null) {
            // 右子树最小值
            exchangeNode = node.getRight();
            while (exchangeNode.getLeft() != null) {
                exchangeNode = exchangeNode.getLeft();
            }
        } else {
            // 左子树最大值
            exchangeNode = node.getLeft();
            while (exchangeNode.getRight() != null) {
                exchangeNode = exchangeNode.getRight();
            }
        }
        return exchangeNode;
    }

    public int getHeight() {
        if (size() == 0) {
            return 0;
        }
        int height = 0;
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(getRoot());
        int levelNodes = nodeList.size();
        while (!nodeList.isEmpty()) {
            Node curNode = nodeList.pop();
            if (curNode.getLeft() != null) {
                nodeList.add(curNode.getLeft());
            }
            if (curNode.getRight() != null) {
                nodeList.add(curNode.getRight());
            }
            levelNodes--;
            if (levelNodes == 0) {
                height++;
                levelNodes = nodeList.size();
            }
        }
        return height;
    }

    public int geMaxHeight(int size) {
        return (int) (2 * Math.floor(Math.log(size + 1.0)));
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed();
    }

    private boolean isBlack(Node node) {
        return !isRed(node);
    }

    private void setRed(Node node) {
        if (node != null) {
            node.setRed(true);
        }
    }

    private void setBlack(Node node) {
        if (node != null) {
            node.setRed(false);
        }
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return size;
    }

    public boolean isAvl() {
        return avl;
    }

    public void setAvl(boolean avl) {
        this.avl = avl;
    }
}

package com.wjd.structure.tree.redblack;

import java.util.*;

/**
 * 红黑树
 */
public class RBTreeImpl {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 节点数量
     */
    private int size;

    /**
     * 获取指定值的节点
     *
     * @param val 值
     * @return 节点
     */
    public Node get(int val) {
        Node p = root;
        while (p != null) {
            if (p.val == val) {
                return p;
            }
            if (p.val > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 插入值
     *
     * @param val 值
     */
    public Node insert(int val) {
        Node insertNode = new Node();
        insertNode.setRed(true);
        insertNode.setLeft(null);
        insertNode.setRight(null);
        insertNode.setVal(val);
        root = add(root, insertNode);
        if (isBlack(insertNode)) {
            return null;
        }

        fixUpInsert(insertNode);
        size++;
        return insertNode;
    }

    private void fixUpInsert(Node node) {
        Node parent = node.parent;
        Node insertNode = node;
        while (parent != null) {
            // 1. 父节点是黑色
            if (isBlack(parent)) {
                break;
            }

            // 2. 父节点是红色
            Node grandparent = parent.parent;
            if (parent == grandparent.left) {
                // 父节点是左节点
                // 2.1 插入节点是右节点
                if (insertNode == parent.right) {
                    rotateLeft(parent);

                    // 转到 2.2
                    insertNode = parent;
                    parent = insertNode.parent;
                    grandparent = parent.parent;
                }

                // 2.2 插入节点是左节点
                if (insertNode == parent.left) {
                    rotateRight(grandparent);
                    setRed(parent);
                    setBlack(insertNode);
                    setBlack(grandparent);
                }
            } else {
                // 父节点是右节点
                // 2.1 插入节点是左节点
                if (insertNode == parent.left) {
                    rotateRight(parent);

                    // 转到 2.2
                    insertNode = parent;
                    parent = insertNode.parent;
                    grandparent = parent.parent;
                }

                // 2.2 插入节点是右节点
                if (insertNode == parent.right) {
                    rotateLeft(grandparent);
                    setRed(parent);
                    setBlack(insertNode);
                    setBlack(grandparent);
                }
            }

            insertNode = parent;
            parent = insertNode.parent;
        }
        setBlack(root);
    }

    /**
     * 删除值
     *
     * @param val 值
     */
    public Node delete(int val) {
        Node deleteNode = get(val);
        if (deleteNode == null) {
            return null;
        }

        // 交换删除节点
        Node swapNode = getSwapNode(deleteNode);
        deleteNode.setVal(swapNode.getVal());
        swapNode.setVal(val);
        deleteNode = swapNode;

        // 修正树结构
        fixUpDelete(deleteNode);

        // 从树中移除节点
        remove(deleteNode);
        return deleteNode;
    }

    private void fixUpDelete(Node node) {
        Node parent = node.parent;
        Node deleteNode = node;
        while (parent != null) {
            // 1. 删除节点是红色，父节点必是黑色
            if (isRed(deleteNode)) {
                break;
            }

            // 2. 删除节点是黑色，兄弟节点必定存在
            if (deleteNode == parent.left) {
                // 删除节点是左节点
                Node sibling = parent.right;
                Node siblingLeft = sibling.left;
                Node siblingRight = sibling.right;

                // 2.1 侄子中存在红色，兄弟节点必是黑色
                if (isRed(siblingLeft) || isRed(siblingRight)) {
                    // 2.1.1 远侄子是黑色，近侄子是红色
                    if (isBlack(siblingRight)) {
                        rotateRight(sibling);

                        // 转到 2.1.2
                        setRed(sibling);
                        setBlack(siblingLeft);
                        sibling = siblingLeft;
                        siblingLeft = sibling.left;
                        siblingRight = sibling.right;
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
                    parent = deleteNode.parent;
                }
            } else {
                // 删除节点是右节点
                Node sibling = parent.left;
                Node siblingLeft = sibling.left;
                Node siblingRight = sibling.right;

                // 2.1 侄子中存在红色，兄弟节点必是黑色
                if (isRed(siblingLeft) || isRed(siblingRight)) {
                    // 2.1.1 远侄子是黑色，近侄子是红色
                    if (isBlack(siblingLeft)) {
                        rotateLeft(sibling);

                        // 转到 2.1.2
                        setRed(sibling);
                        setBlack(siblingRight);
                        sibling = siblingRight;
                        siblingLeft = sibling.left;
                        siblingRight = sibling.right;
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
                    parent = deleteNode.parent;
                }
            }
        }
        setBlack(root);
    }

    private void rotateRight(Node node) {
        if (node == null || node.left == null) {
            return;
        }

        Node parent = node.parent;
        Node left = node.left;
        left.setParent(parent);
        if (parent != null) {
            if (node == parent.left) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
        }
        node.setLeft(left.right);
        if (node.left != null) {
            node.left.setParent(node);
        }
        node.setParent(left);
        left.setRight(node);

        if (node == root) {
            root = left;
        }
    }

    private void rotateLeft(Node node) {
        if (node == null || node.right == null) {
            return;
        }

        Node parent = node.parent;
        Node right = node.right;
        right.setParent(parent);
        if (parent != null) {
            if (node == parent.left) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
        }
        node.setRight(right.left);
        if (node.right != null) {
            node.right.setParent(node);
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
     * @param root    根节点
     * @param newNode 新节点
     * @return 根节点
     */
    private Node add(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.val < root.val) {
            root.left = add(root.left, newNode);
        } else if (newNode.val > root.val) {
            root.right = add(root.right, newNode);
        }
        return root;
    }

    /**
     * 从树中移除指定节点
     *
     * @param node 移除节点，必须保证是树中的节点
     */
    private void remove(Node node) {
        size--;
        if (node.parent == null) {
            root = null;
            return;
        }
        if (node == node.parent.left) {
            node.parent.setLeft(node.right);
        } else {
            node.parent.setRight(node.left);
        }
    }

    /**
     * 获取可交换的节点
     *
     * @param node 需要交换的节点
     * @return 可交换节点
     */
    private Node getSwapNode(Node node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        Node swapNode;
        if (node.right != null) {
            // 右子树最小值
            swapNode = node.right;
            while (swapNode.left != null) {
                swapNode = swapNode.left;
            }
        } else {
            // 左子树最大值
            swapNode = node.left;
            while (swapNode.right != null) {
                swapNode = swapNode.right;
            }
        }
        return swapNode;
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
            if (curNode.left != null) {
                nodeList.add(curNode.left);
            }
            if (curNode.right != null) {
                nodeList.add(curNode.right);
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

}

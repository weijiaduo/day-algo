package com.wjd.structure.tree.redblack;

/**
 * AVL-红黑树
 *
 * 红色节点只能是左节点
 */
public class AVLRBTreeImpl {

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
        boolean success = add(insertNode);
        if (!success) {
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
            if (isBlack(parent)) {
                // 1. 父节点是黑色
                // 1.1 插入节点是左节点，右兄弟节点必是黑色
                if (insertNode == parent.left) {
                    break;
                }

                // 2.1 插入节点是右节点
                if (isBlack(parent.left)) {
                    // 2.1.1 左兄弟节点是黑色
                    rotateLeft(parent);
                    setBlack(insertNode);
                    setRed(parent);
                } else {
                    // 2.1.2 左兄弟节点是红色
                    setBlack(parent.left);
                    setBlack(parent.right);
                    setRed(parent);
                }
            } else {
                // 2. 父节点是红色，则父节点必是左节点，且左兄弟节点必是黑色
                Node grandparent = parent.parent;
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
                    setBlack(parent.left);
                    setBlack(parent.right);
                    setRed(parent);
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
        Node exchangeNode = getSwapNode(deleteNode);
        deleteNode.setVal(exchangeNode.getVal());
        exchangeNode.setVal(val);
        deleteNode = exchangeNode;

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
                temp = parent.right;
            } else {
                temp = parent.left;
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

    public int size() {
        return size;
    }

}

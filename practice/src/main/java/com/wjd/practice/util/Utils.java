package com.wjd.practice.util;

import com.wjd.structure.list.ListNode;
import com.wjd.structure.tree.binary.TreeNode;
import com.wjd.structure.tree.generic.Node;
import com.wjd.util.StringUtils;

/**
 * 工具类
 *
 * @author weijiaduo
 * @since 2023/10/29
 */
public final class Utils {

    private Utils() {
    }

    public static String toStr(Object object) {
        // 链表节点
        if (object instanceof ListNode) {
            return ListNode.toString((ListNode) object);
        }
        // 树
        if (object instanceof Node) {
            return Node.toString((Node) object);
        }
        // 二叉树
        if (object instanceof TreeNode) {
            return TreeNode.toString((TreeNode) object);
        }
        return StringUtils.toStr(object);
    }

}

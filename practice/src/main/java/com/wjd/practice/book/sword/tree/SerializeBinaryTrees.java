package com.wjd.practice.book.sword.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 37. 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author weijiaduo
 * @since 2023/11/26
 */
public class SerializeBinaryTrees {

    /**
     * 思路：序列化时，按照层序遍历的顺序将节点值放入字符串中，空节点用#表示
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"[8,7,17,9,2,3,5,#,#,#,#,26,#,#,3,#,#,#,11]"},
            output = "8,7,17,9,2,3,5,#,#,#,#,26,#,#,3,#,#,#,11")
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int notNull = 1;
        while (notNull > 0) {
            TreeNode cur = queue.poll();
            if (sb.length() != 0) {
                sb.append(",");
            }
            if (cur == null) {
                sb.append('#');
                continue;
            }

            notNull--;
            sb.append(cur.val);
            queue.add(cur.left);
            if (cur.left != null) {
                notNull++;
            }
            queue.add(cur.right);
            if (cur.right != null) {
                notNull++;
            }
        }
        return sb.toString();
    }

    /**
     * 思路：反序列化时，根据层序遍历字符串中的值生成节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     */
    @TestCase(input = {"8,7,17,9,2,3,5,#,#,#,#,26,#,#,3,#,#,#,11"},
            output = "[8,7,17,9,2,3,5,#,#,#,#,26,#,#,3,#,#,#,11]")
    public TreeNode deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] nums = str.split(",");
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = nums.length, index = 1;
        while (index < n && !queue.isEmpty()) {
            TreeNode cur = queue.poll();

            // 左节点
            TreeNode left = null;
            if (!"#".equals(nums[index])) {
                left = new TreeNode(Integer.parseInt(nums[index]));
                queue.add(left);
            }
            cur.left = left;
            index++;

            TreeNode right = null;
            if (index < n && !"#".equals(nums[index])) {
                right = new TreeNode(Integer.parseInt(nums[index]));
                queue.add(right);
            }
            cur.right = right;
            index++;
        }
        return root;
    }

}

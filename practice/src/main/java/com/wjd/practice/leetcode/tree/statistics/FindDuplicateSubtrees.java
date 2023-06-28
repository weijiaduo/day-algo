package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * <p>
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 *
 * @author weijiaduo
 * @since 2022/9/6
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs2(root);
        return repeat;
    }

    List<TreeNode> repeat = new ArrayList<>();
    Map<String, TreeNode> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    int idx = 0;
    Map<String, Integer> idMap = new HashMap<>();

    /**
     * 思路：序列化树，如果出现重复的序列化值，说明树重复了
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n^2)
     * <p>
     * 执行耗时:15 ms,击败了87.78% 的Java用户
     * 内存消耗:55.4 MB,击败了5.01% 的Java用户
     */
    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(dfs(root.left));
        sb.append(")(");
        sb.append(dfs(root.right));
        sb.append(")");
        String hash = sb.toString();
        if (map.containsKey(hash)) {
            if (!set.contains(hash)) {
                set.add(hash);
                repeat.add(map.get(hash));
            }
        } else {
            map.put(hash, root);
        }
        return hash;
    }

    /**
     * 思路：序列化树，使用id表示不同的树结构，减少序列化长度
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:5 ms,击败了99.64% 的Java用户
     * 内存消耗:42 MB,击败了99.53% 的Java用户
     */
    private int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] arr = {root.val, dfs2(root.left), dfs2(root.right)};
        String hash = Arrays.toString(arr);
        if (map.containsKey(hash)) {
            if (!set.contains(hash)) {
                set.add(hash);
                repeat.add(map.get(hash));
            }
            return idMap.get(hash);
        } else {
            map.put(hash, root);
            idMap.put(hash, ++idx);
            return idx;
        }
    }

}

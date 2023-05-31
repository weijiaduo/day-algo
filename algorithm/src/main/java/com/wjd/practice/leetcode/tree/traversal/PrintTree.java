package com.wjd.practice.leetcode.tree.traversal;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.*;

/**
 * 655. 输出二叉树
 * <p>
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。
 * <p>
 * 构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * <p>
 * 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。
 * <p>
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * <p>
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，
 * <p>
 * 将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。
 * <p>
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * <p>
 * 任意空单元格都应该包含空字符串 "" 。
 * <p>
 * 返回构造得到的矩阵 res 。
 *
 * @author weijiaduo
 * @since 2022/8/22
 */
public class PrintTree {

    /**
     * @param root 根节点
     * @return 二维数组
     */
    public List<List<String>> printTree(TreeNode root) {
        // return bfsPrintTree(root);
        return dfsPrintTree(root);
    }

    /**
     * 思路：
     * <p>
     * 先算出高度，得到最大列数，然后按层次遍历，逐层放置节点，null节点也需要遍历，因为需要它的位置信息
     * <p>
     * 同一层的节点之间的间隔是一样的，所以只要算出该层的节点起始索引以及间隔，就能按层次摆放节点的位置
     * <p>
     * 比如：
     * <p>
     * 倒数第1层的节点间隔数量是1，节点之间偏移就是2
     * <p>
     * 倒数第2层的节点间隔数量是3，节点之间偏移就是4
     * <p>
     * 倒数第3层的节点间隔数量是7，节点之间偏移就是8
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了90.51% 的Java用户
     * 内存消耗:42 MB,击败了15.19% 的Java用户
     *
     * @param root 根节点
     * @return 二维数组
     */
    private List<List<String>> bfsPrintTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int m = height(root) + 1;
        int n = (int) (Math.pow(2, m) - 1);
        int offset = n + 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 0; i < m; i++) {
            String[] arr = new String[n];
            Arrays.fill(arr, "");
            int size = queue.size();
            int index = (offset - 1) / 2;
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    arr[index] = "" + node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                index += offset;
            }
            ans.add(Arrays.asList(arr));
            offset /= 2;
        }
        return ans;
    }

    /**
     * 思路：深度递归，知道了父节点的坐标，可以直接计算出子节点的坐标
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了90.51% 的Java用户
     * 内存消耗:41.8 MB,击败了45.25% 的Java用户
     *
     * @param root 根节点
     * @return 二维数组
     */
    private List<List<String>> dfsPrintTree(TreeNode root) {
        int h = height(root);
        int m = h + 1;
        int n = (int) (Math.pow(2, m) - 1);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            ans.add(list);
        }

        // 父子节点之间的偏移量
        int offset = (int) Math.pow(2, h - 1);
        dfs(ans, root, 0, (n - 1) / 2, offset);
        return ans;
    }

    /**
     * 递归设置节点
     */
    private void dfs(List<List<String>> ans, TreeNode root, int r, int c, int offset) {
        if (root == null) {
            return;
        }
        ans.get(r).set(c, "" + root.val);
        if (root.left != null) {
            dfs(ans, root.left, r + 1, c - offset, offset / 2);
        }
        if (root.right != null) {
            dfs(ans, root.right, r + 1, c + offset, offset / 2);
        }
    }

    /**
     * 二叉树高度
     *
     * @param root 根节点
     * @return 高度
     */
    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}

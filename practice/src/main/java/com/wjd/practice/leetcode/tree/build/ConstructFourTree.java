package com.wjd.practice.leetcode.tree.build;

import com.wjd.practice.TestCase;

/**
 * 427. 建立四叉树
 * <p>
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 * <p>
 * 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
 * <p>
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 * <p>
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者
 * False 赋值给节点，两种值都会被判题机制 接受 。
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * <p>
 * class Node {
 * public boolean val;
 * public boolean isLeaf;
 * public Node topLeft;
 * public Node topRight;
 * public Node bottomLeft;
 * public Node bottomRight;
 * }
 * <p>
 * 我们可以按以下步骤为二维区域构建四叉树：
 * <p>
 * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
 * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
 * 使用适当的子网格递归每个子节点。
 * <p>
 * 如果你想了解更多关于四叉树的内容，可以参考 wiki 。
 * <p>
 * 四叉树格式：
 * <p>
 * 你不需要阅读本节来解决这个问题。只有当你想了解输出格式时才会这样做。输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节
 * 点。
 * <p>
 * 它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。
 * <p>
 * 如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为
 * False ，则表示值为 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：[[0,1],[1,0],[1,1],[1,1],[1,0]]
 * 解释：此示例的解释如下：
 * 请注意，在下面四叉树的图示中，0 表示 false，1 表示 True 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,
 * 1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
 * 输出：[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
 * <p>
 * 解释：网格中的所有值都不相同。我们将网格划分为四个子网格。
 * topLeft，bottomLeft 和 bottomRight 均具有相同的值。
 * topRight 具有不同的值，因此我们将其再分为 4 个子网格，这样每个子网格都具有相同的值。
 * 解释如下图所示：
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * n == 2ˣ 其中 0 <= x <= 6
 *
 * @author weijiaduo
 * @since 2023/12/4
 */
public class ConstructFourTree {

    /**
     * 思路：分治法。将矩阵不断四分，直到不能再分为止
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(logn)
     * <p>
     * 执行耗时:1 ms,击败了44.13% 的Java用户
     * 内存消耗:42.4 MB,击败了29.36% 的Java用户
     */
    @TestCase(input = {"[[0,1],[1,0]]",
            "[[0]]",
            "[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]"},
            output = {"", "", ""})
    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
        return build(grid, 0, 0, grid.length);
    }

    /**
     * 构建四叉树
     *
     * @param grid 矩阵
     * @param i    行下标，左上角
     * @param j    列下标，左上角
     * @param size 网格大小
     * @return 四叉树节点
     */
    private Node build(int[][] grid, int i, int j, int size) {
        Node node = new Node();
        if (size == 1) {
            // 叶子节点
            node.val = grid[i][j] == 1;
            node.isLeaf = true;
            return node;
        }

        // 分治构建子节点
        int newSize = size / 2;
        // TopLeft
        Node tl = build(grid, i, j, newSize);
        // TopRight
        Node tr = build(grid, i, j + newSize, newSize);
        // BottomLeft
        Node bl = build(grid, i + newSize, j, newSize);
        // BottomRight
        Node br = build(grid, i + newSize, j + newSize, newSize);

        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf
            && tl.val == tr.val && tl.val == bl.val && tl.val == br.val) {
            node.isLeaf = true;
            node.val = tl.val;
        } else {
            node.topLeft = tl;
            node.topRight = tr;
            node.bottomLeft = bl;
            node.bottomRight = br;
        }
        return node;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
    }

}

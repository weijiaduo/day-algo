package com.wjd.practice.leetcode.trick;

/**
 * 1483. 树节点的第 K 个祖先
 * <p>
 * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。
 * <p>
 * 树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
 * <p>
 * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
 * <p>
 * 实现 TreeAncestor 类：
 * <p>
 * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 * <p>
 * 输出：
 * [null,1,0,-1]
 * <p>
 * 解释：
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * <p>
 * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
 * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
 * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 5 * 10⁴
 * parent[0] == -1 表示编号为 0 的节点是根节点。
 * 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
 * 0 <= node < n
 * 至多查询 5 * 10⁴ 次
 *
 * @author weijiaduo
 * @since 2023/6/12
 */
public class TreeAncestor {

    /**
     * 祖先节点
     * <p>
     * ancestors[i][j] 表示节点 i 的第 2^j 个祖先
     */
    private final int[][] ancestors;

    /**
     * 复杂度：时间 O(nlogn) 空间 O(nlogn)
     * <p>
     * 执行耗时:68 ms,击败了83.05% 的Java用户
     * 内存消耗:77.8 MB,击败了66.10% 的Java用户
     */
    public TreeAncestor(int n, int[] parent) {
        // 最大的祖先 2^m
        int m = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        ancestors = new int[n][m];

        // 初始化状态
        for (int i = 0; i < n; i++) {
            ancestors[i][0] = parent[i];
        }

        // 状态转移，从近祖先到远祖先
        // ancestors[i][j + 1] = ancestors[ancestors[i][j]][j]
        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                int p = ancestors[i][j];
                ancestors[i][j + 1] = p < 0 ? -1 : ancestors[p][j];
            }
        }
    }

    /**
     * 复杂度：时间 O(logk) 空间 O(1)
     * <p>
     * 查找 node 的第 k 个祖先节点
     *
     * @param node 当前节点
     * @param k    第 k 个祖先节点
     * @return 第 k 个祖先节点
     */
    public int getKthAncestor(int node, int k) {
        int ans = node;
        // 每次跳的次数，比如 13 = 2^3 + 2^2 + 2^0
        // 第1次找第 2^3 个祖先，第2次从第1次基础上再找第 2^2 个祖先，以此类推
        int steps = Integer.SIZE - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < steps; i++) {
            if (((k >> i) & 1) > 0) {
                ans = ancestors[ans][i];
                if (ans < 0) {
                    break;
                }
            }
        }
        return ans;
    }

}

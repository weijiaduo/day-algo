package com.wjd.practice.leetcode.math;

/**
 * 779. 第K个语法符号
 * <p>
 * 我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。
 * <p>
 * 接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * <p>
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 *
 * @author weijiaduo
 * @since 2022/10/20
 */
public class KthGrammar {

    public int solve(int n, int k) {
        // return fullTree(n, k);
        // return dfs(n, k);
        return bit(n, k);
    }

    /**
     * 思路：满二叉树，叶子节点的序号可以倒推出父节点的序号，这样就能得到叶子节点到根节点的路径
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了13.01% 的Java用户
     */
    public int fullTree(int n, int k) {
        // 满二叉树节点编号
        int exp = 1;
        for (int i = 0; i < n - 1; i++) {
            k += exp;
            exp *= 2;
        }

        // 从叶子节点逆推到根节点的路径
        // 0表示左子节点，1表示有子节点
        int[] path = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int p = k / 2;
            if (k == 2 * p) {
                path[i] = 0;
            } else {
                path[i] = 1;
            }
            k = p;
        }

        // 从根节点按照路径正推到叶子节点
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            int c = path[i];
            if (ans == 0) {
                ans = c == 0 ? 0 : 1;
            } else {
                ans = c == 0 ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     * 思路：每一行的右半部分是由左半部分反转而来，0反转成1，1反转成0
     * <p>
     * 0
     * 01
     * 0110
     * 01101001
     * ...
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了12.38% 的Java用户
     */
    private int dfs(int n, int k) {
        // 根节点
        if (n == 1) {
            return 0;
        }
        // k 在左半部分，不需要反转
        if (k <= (1 << (n - 2))) {
            return dfs(n - 1, k);
        }
        // k 在右半部分，需要反转
        return dfs(n - 1, k - (1 << (n - 2))) ^ 1;
    }

    /**
     * 思路：假设每行索引从0开始
     * <p>
     * 每一行的第i个字符，将在下一行的第2i和第2i+1的位置上生成2个字符。
     * <p>
     * 其中，2i的字符和i的字符保持一致，而2i+1的字符与i的字符相反。
     * <p>
     * 由此可知：
     * <p>
     * 偶数位的字符是未经过反转的；
     * 奇数位的字符都是经过反转的。
     * <p>
     * 因此，如果 k 是奇数，则说明经过一次反转。
     * <p>
     * 不断将 k = k / 2，递归判断奇偶性，直到 0 为止，过程中统计 k 为奇数的次数。
     * <p>
     * 根节点是 0，如果最终次数是奇数，说明经过了反转，结果就是 1；反之结果就是 0。
     * <p>
     * 而奇数的出现次数，实际上就是 k 的二进制中的 1 的数量。
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了80.00% 的Java用户
     */
    private int bit(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }

}

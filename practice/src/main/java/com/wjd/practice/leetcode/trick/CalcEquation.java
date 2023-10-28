package com.wjd.practice.leetcode.trick;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. 除法求值
 * <p>
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
 * <p>
 * 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
 * <p>
 * 每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，
 * <p>
 * 请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * <p>
 * 如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
 * ,["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 注意：x 是未定义的 => -1.0
 * <p>
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * <p>
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
 * "a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 *
 * @author weijiaduo
 * @since 2023/10/14
 */
public class CalcEquation {

    /**
     * 思路：并查集，能求值的数字，肯定在同一个集合内
     * <p>
     * 复杂度：时间 O(mlogn) 空间 O(m)
     * <p>
     * 执行耗时:1 ms,击败了69.72% 的Java用户
     * 内存消耗:39.8 MB,击败了85.35% 的Java用户
     */
    @TestCase(input = {"[[\"a\",\"b\"],[\"b\",\"c\"]]", "[2.0,3.0]", "[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]",
            "[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]", "[1.5,2.5,5.0]", "[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]",
            "[[\"a\",\"b\"]]", "[0.5]", "[[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]",
            "[[\"a\",\"e\"],[\"b\",\"e\"]]", "[4.0,3.0]", "[[\"a\",\"b\"],[\"e\",\"e\"],[\"x\",\"x\"]]"},
            output = {"[6.00000,0.50000,-1.00000,1.00000,-1.00000]",
                    "[3.75000,0.40000,5.00000,0.20000]",
                    "[0.50000,2.00000,-1.00000,-1.00000]",
                    "[1.33333,1.0,-1.0]"})
    public double[] ufs(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int idx = 0;
        Map<String, Integer> name2id = new HashMap<>();
        for (List<String> eq : equations) {
            String src = eq.get(0);
            String tar = eq.get(1);
            if (!name2id.containsKey(src)) {
                name2id.put(src, idx++);
            }
            if (!name2id.containsKey(tar)) {
                name2id.put(tar, idx++);
            }
        }

        ArrayUnionFind uf = new ArrayUnionFind(idx + 1);
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            int src = name2id.get(eq.get(0));
            int tar = name2id.get(eq.get(1));
            double val = values[i];
            uf.union(src, tar, val);
        }

        int m = queries.size();
        double[] ans = new double[m];
        for (int i = 0; i < m; i++) {
            List<String> q = queries.get(i);
            int a = name2id.getOrDefault(q.get(0), -1);
            int b = name2id.getOrDefault(q.get(1), -1);
            if (a < 0 || b < 0) {
                ans[i] = -1.0;
            } else {
                ans[i] = uf.calc(a, b);
            }
        }
        return ans;
    }

    /**
     * 并查集
     */
    static class ArrayUnionFind {

        /**
         * 父节点存储
         */
        private final int[] parent;
        /**
         * 节点深度
         */
        private final double[] weights;

        public ArrayUnionFind(int n) {
            parent = new int[n];
            weights = new double[n];
            init(n);
        }

        /**
         * 初始化并查集
         */
        private void init(int n) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weights[i] = 1.0;
            }
        }

        /**
         * 查找元素根节点
         */
        public int find(int x) {
            if (parent[x] != x) {
                // 路径压缩
                int p = parent[x];
                parent[x] = find(p);
                weights[x] *= weights[p];

            }
            // 路径压缩后，最终会指向根节点
            return parent[x];
        }

        /**
         * 合并元素子集合
         */
        public void union(int a, int b, double weight) {
            int rx = find(a);
            int ry = find(b);
            if (rx == ry) {
                return;
            }

            parent[rx] = ry;
            weights[rx] = weights[b] * weight / weights[a];
        }

        /**
         * 计算 a/b
         */
        public double calc(int a, int b) {
            int rx = find(a);
            int ry = find(b);
            if (rx != ry) {
                return -1.0;
            } else {
                return weights[a] / weights[b];
            }
        }

    }

}

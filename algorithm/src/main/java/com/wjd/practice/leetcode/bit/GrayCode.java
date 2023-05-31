package com.wjd.practice.leetcode.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 89. 格雷编码
 * <p>
 * n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
 * <p>
 * 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1）
 * <p>
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * <p>
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 * <p>
 *
 * @since 2022/6/10
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        int size = (int) Math.pow(2, n);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            boolean result = dfs(size, i, ans, new HashMap<>());
            if (result) {
                return ans;
            }
        }
        return new ArrayList<>(0);
    }

    /**
     * 真够慢的，哈哈哈哈~
     * <p>
     * 执行耗时:14 ms,击败了9.43% 的Java用户
     * 内存消耗:60.7 MB,击败了5.04% 的Java用户
     */
    private boolean dfs(int n, int k, List<Integer> path, Map<Integer, Boolean> memo) {
        if (memo.getOrDefault(k, false)) {
            return false;
        }

        memo.put(k, true);
        path.add(k);

        if (n == path.size()) {
            int first = path.get(0);
            int last = path.get(path.size() - 1);
            for (int i = 0; i < 16; i++) {
                int t = first ^ (1 << i);
                if (t == last) {
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < 16; i++) {
            int next = k ^ (1 << i);
            if (dfs(n, next, path, memo)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        memo.put(k, false);

        return false;
    }

    /**
     * 官解1
     * <p>
     * 执行耗时:6 ms,击败了70.02% 的Java用户
     * 内存消耗:46.8 MB,击败了63.15% 的Java用户
     */
    public List<Integer> grayCode1(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }

    /**
     * 官解2
     * <p>
     * 执行耗时:4 ms,击败了97.93% 的Java用户
     * 内存消耗:46.8 MB,击败了59.87% 的Java用户
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }

}

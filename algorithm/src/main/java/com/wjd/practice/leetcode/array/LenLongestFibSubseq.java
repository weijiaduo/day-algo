package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.*;

/**
 * 873. 最长的斐波那契序列的长度
 * <p>
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * <p>
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。
 * <p>
 * 如果一个不存在，返回 0 。
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class LenLongestFibSubseq implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] arr = {1, 3, 4, 7, 10, 11, 12, 18, 23, 35};
        int result = lenLongestFibSubseq(arr);
        System.out.println(result);
        return result;
    }

    private int lenLongestFibSubseq(int[] arr) {
        // 方法1
        // return dfs(arr, 0, new ArrayList<>());
        // 方法2
        // Map<Integer, Integer> pos = new HashMap<>(arr.length);
        // for (int i = 0; i < arr.length; i++) {
        //     pos.put(arr[i], i);
        // }
        // return dfs2(arr, 0, new ArrayList<>(), pos);
        // 方法3
        return direct(arr);
    }

    /**
     * 思路：当前元素有2种情况，选择和不选择，回溯遍历所有情况
     * <p>
     * 和我想得差不多，应该会超时
     * <p>
     * Time Limit Exceeded
     */
    private int dfs(int[] arr, int index, List<Integer> seq) {
        if (index >= arr.length) {
            return seq.size() > 2 ? seq.size() : 0;
        }
        if (seq.size() >= 2 && arr[index] > seq.get(seq.size() - 2) + seq.get(seq.size() - 1)) {
            // 递增，后面肯定不满足了
            return seq.size() > 2 ? seq.size() : 0;
        }

        int max = 0;
        // 选择当前元素
        if (seq.size() < 2 || arr[index] == seq.get(seq.size() - 2) + seq.get(seq.size() - 1)) {
            seq.add(arr[index]);
            max = Math.max(dfs(arr, index + 1, seq), max);
            seq.remove(seq.size() - 1);
        }
        // 不选择当前元素
        max = Math.max(dfs(arr, index + 1, seq), max);
        return max;
    }

    /**
     * 思路：遍历选择2个起点，有了起点之后，就可以直接算出后面的值
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n^2)
     * <p>
     * 执行耗时:608 ms,击败了5.04% 的Java用户
     * 内存消耗:41.6 MB,击败了75.03% 的Java用户
     */
    private int dfs2(int[] arr, int index, List<Integer> seq, Map<Integer, Integer> pos) {
        if (index >= arr.length) {
            return seq.size() > 2 ? seq.size() : 0;
        }

        int max = 0;
        if (seq.size() < 2) {
            // 选择当前元素作为起点
            seq.add(arr[index]);
            max = Math.max(dfs2(arr, index + 1, seq, pos), max);
            seq.remove(seq.size() - 1);
            // 不选择当前元素作为起点
            max = Math.max(dfs2(arr, index + 1, seq, pos), max);
        } else {
            // 确定2个起点后，后面的元素就确定好了
            int next = seq.get(seq.size() - 2) + seq.get(seq.size() - 1);
            Integer p = pos.get(next);
            if (p != null) {
                // 下一个元素还存在，继续遍历
                seq.add(next);
                max = Math.max(dfs2(arr, p + 1, seq, pos), max);
                seq.remove(seq.size() - 1);
            } else {
                // 没有下一个元素了
                max = seq.size() > 2 ? seq.size() : 0;
            }
        }
        return max;
    }

    /**
     * 思路：暴力法，先遍历取前2个起点，后面直接查找就行
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:194 ms,击败了47.17% 的Java用户
     * 内存消耗:41.3 MB,击败了91.78% 的Java用户
     */
    private int direct(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> pos = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            pos.put(arr[i], i);
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int first = arr[i], second = arr[j];
                int count = 2;
                while (pos.containsKey(first + second)) {
                    count++;
                    second = first + second;
                    first = second - first;
                }
                if (count > 2) {
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

}

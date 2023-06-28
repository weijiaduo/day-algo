package com.wjd.practice.leetcode.array.combination;

/**
 * 667. 优美的排列2
 * <p>
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * <p>
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|
 * , ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * <p>
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * <p>
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 *
 * @author weijiaduo
 * @since 2022/9/8
 */
public class ConstructArray2 {

    /**
     * 思路：官解还是牛批，这道题不会
     * <p>
     * 正序 [1,2,⋯,n] 相邻的差均为 1
     * <p>
     * 后半部分交叉到前半部分，[1,n,2,n−1,3,⋯] 相邻的差从 n-1 开始，依次递减 1。
     * <p>
     * 组合上面2种情况，k个不同值的情况应该是 [1,2,⋯,n−k,n,n−k+1,n−1,n−k+2,⋯]
     * <p>
     * 实际就是把数组后面的部分元素，倒序交叉原数组
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了89.01% 的Java用户
     */
    private int[] constructArray(int n, int k) {
        int[] arr = new int[n];

        // 前面n-k个元素，有1个不同的值
        for (int i = 0; i < n - k; i++) {
            arr[i] = i + 1;
        }

        // 后面k个元素，有k-1个不同的值
        int x = n - k + 1, y = n;
        for (int i = n - k; i < n; i++) {
            arr[i] = y--;
            if (i + 1 < n) {
                arr[++i] = x++;
            }
        }

        return arr;
    }

}

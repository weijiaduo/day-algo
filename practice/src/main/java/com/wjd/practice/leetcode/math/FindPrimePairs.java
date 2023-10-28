package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 周赛 352
 * <p>
 * 6916. 和等于目标值的质数对
 * <p>
 * 给你一个整数 n 。如果两个整数 x 和 y 满足下述条件，则认为二者形成一个质数对：
 * <p>
 * 1 <= x <= y <= n
 * x + y == n
 * x 和 y 都是质数
 * 请你以二维有序列表的形式返回符合题目要求的所有 [xi, yi] ，列表需要按 xi 的 非递减顺序 排序。
 * <p>
 * 如果不存在符合要求的质数对，则返回一个空数组。
 * <p>
 * 注意：质数是大于 1 的自然数，并且只有两个因子，即它本身和 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：[[3,7],[5,5]]
 * 解释：在这个例子中，存在满足条件的两个质数对。
 * 这两个质数对分别是 [3,7] 和 [5,5]，按照题面描述中的方式排序后返回。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：[]
 * 解释：可以证明不存在和为 2 的质数对，所以返回一个空数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 106
 *
 * @author weijiaduo
 * @since 2023/7/2
 */
public class FindPrimePairs {

    /**
     * 思路：预处理质数，然后遍历所有整数，判断是否符合条件即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行用时：318 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：53.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    @TestCase(input = {"10", "2"},
            output = {"[[3,7],[5,5]]", "[]"})
    public List<List<Integer>> findPrimePairs(int n) {
        // 预处理质数
        int[] flg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (flg[i] != 0) {
                continue;
            }
            flg[i] = 1;
            for (int j = 2 * i; j <= n; j += i) {
                flg[j] = -1;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (flg[i] == 1 && flg[n - i] == 1) {
                ans.add(Arrays.asList(i, n - i));
            }
        }
        return ans;
    }

}

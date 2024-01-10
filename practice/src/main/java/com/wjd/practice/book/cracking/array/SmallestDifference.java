package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 面试题 16.06. 最小差
 * <p>
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * <p>
 * 示例：
 * <p>
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 *
 * @author weijiaduo
 * @since 2024/1/10
 */
public class SmallestDifference {

    /**
     * 思路：排序+双指针
     * <p>
     * 先对两个数组排序，然后用两个指针分别指向两个数组
     * <p>
     * 每次选择小值的指针移动，因为可以让二者接近
     * <p>
     * 比如指针一开始指向是 1 和 8
     * <p>
     * 然后由于 1 < 8，所以 1 的指针往后移动到 3
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     * <p>
     * 执行耗时:21 ms,击败了75.00% 的Java用户
     * 内存消耗:53.2 MB,击败了15.86% 的Java用户
     */
    @TestCase(input = {"[1, 3, 15, 11, 2]", "[23, 127, 235, 19, 8]",
            "[0]", "[2147483647]",
            "[-2147483648,1]", "[2147483647,0]",
            "[1,2,11,15]", "[4,12,19,23,127,235]"},
            output = {"3", "2147483647", "1", "1"})
    public int sort(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = Integer.MAX_VALUE;
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            long diff = (long) a[i] - (long) b[j];
            ans = Math.min(Math.abs(diff), ans);
            if (ans == 0) {
                break;
            }
            if (diff < 0) {
                i++;
            } else {
                j++;
            }
        }
        return (int) ans;
    }

}

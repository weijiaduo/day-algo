package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

/**
 * 面试题 10.01. 合并排序的数组
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出:[1,2,2,3,5,6]
 * <p>
 * 说明:
 * <p>
 * A.length == n + m
 *
 * @author weijiaduo
 * @since 2024/1/4
 */
public class MergeSortedArray {

    /**
     * 思路：倒着遍历合并即可
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了6.64% 的Java用户
     */
    @TestCase(input = {"[1,2,3,0,0,0]", "3", "[2,5,6]", "3"},
            output = {"[1,2,2,3,5,6]"})
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            int num;
            if (i >= 0 && j >= 0) {
                num = a[i] > b[j] ? a[i--] : b[j--];
            } else if (i >= 0) {
                num = a[i--];
            } else {
                num = b[j--];
            }
            a[k] = num;
        }
    }

}

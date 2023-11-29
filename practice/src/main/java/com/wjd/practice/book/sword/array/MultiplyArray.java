package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 66. 构建乘积数组
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * <p>
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * <p>
 * 不能使用除法。
 *
 * @author weijiaduo
 * @since 2023/11/30
 */
public class MultiplyArray {

    /**
     * 思路：分别计算每个位置左边和右边的乘积，然后相乘即可。
     * <p>
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * <p>
     * 可以看成是左边 A[0]*A[1]*...*A[i-1] 和右边 A[i+1]*...*A[n-1] 两部分的乘积。
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3]"}, output = {"[6,3,2]"})
    public int[] multiply(int[] a) {
        if (a == null) {
            return null;
        }

        int n = a.length;
        int[] b = new int[n];
        if (n == 0) {
            return b;
        }

        // 计算左边的乘积
        b[0] = 1;
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        // 计算右边的乘积
        int temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            b[i] = b[i] * temp;
            temp *= a[i];
        }

        return b;
    }

}

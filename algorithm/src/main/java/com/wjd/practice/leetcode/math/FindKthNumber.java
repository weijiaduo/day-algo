package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

/**
 * 668. 乘法表中第k小的数
 *
 * @since 2022/5/18
 */
public class FindKthNumber implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int m = 5;
        int n = 5;
        int k = 5;
        int result = findKthNumber(m, n, k);
        System.out.println(result);
        return result;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // 统计有多少个数字比mid小
            // 遍历每一行
            int count = 0;
            for (int i = 1; i <= m; i++) {
                int c = mid / i;
                if (c > n) {
                    c = n;
                }
                count += c;
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
            System.out.println(count);
        }

        return right;
    }

}

package com.wjd.practice.leetcode.array.binary;

/**
 * 668. 乘法表中第k小的数
 *
 * @since 2022/5/18
 */
public class FindKthNumber {

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

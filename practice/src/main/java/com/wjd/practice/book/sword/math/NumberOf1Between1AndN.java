package com.wjd.practice.book.sword.math;

import com.wjd.practice.TestCase;

/**
 * 43. 1～n整数中1出现的次数
 * <p>
 * 求整数1～n中1出现的次数
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class NumberOf1Between1AndN {

    /**
     * 思路：暴力法，遍历所有数字，统计1的个数
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     */
    @TestCase(input = {"0", "1", "5", "10", "55", "10000", "21235"},
            output = {"0", "1", "1", "2", "16", "4001", "18690"})
    public int brute(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getNumberOf1(i);
        }
        return count;
    }

    /**
     * 统计数字中1的个数
     *
     * @param n 数字
     * @return 1的个数
     */
    public int getNumberOf1(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    /**
     * 思路：分别计算个位，十位，百位...上1的个数
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    @TestCase(input = {"0", "1", "5", "10", "55", "10000", "21235"},
            output = {"0", "1", "1", "2", "16", "4001", "18690"})
    public int digit(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            // 例如 n=1204，
            // 查找十位时，ln=12，mn=0，rn=4;
            // 查找百位时，ln=1，mn=2，rn=04;
            int ln = n / i / 10, mn = n / i % 10, rn = n % i;
            if (mn == 0) {
                // 若 mn=0，则以 mn 这个位置为 1 的数量有 ln*i 个
                // 例如 k=(0~ln-1)1(.*)
                count += ln * i;
            } else if (mn == 1) {
                // 若 mn=1，则以 mn 这个位置为 1 的数量有 ln*i+rn+1 个
                // 例如 k=(0~ln-1)1(.*) 或 k=(ln)1(0~rn)
                count += ln * i + rn + 1;
            } else if (mn >= 2) {
                // 若 mn>=2，则以 mn 这个位置为 1 的数量有 (ln+1)*i 个
                // 例如 k=(0~ln)1(.*)
                count += (ln + 1) * i;
            }
        }
        return count;
    }

}

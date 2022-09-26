package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 788. 旋转数字
 * <p>
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
 * 下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *
 * @author weijiaduo
 * @since 2022/9/25
 */
public class RotatedDigits implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 20;
        int result = rotateDigits2(n);
        System.out.println(result);
        return result;
    }

    final int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    /**
     * 思路：模拟，直接验证数字的每个数位，看是否符合要求
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(logn)
     */
    private int rotateDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 验证是否是有效的旋转数字
     */
    private boolean isValid(int num) {
        String s = "" + num;
        int n = s.length();
        boolean diff = false;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - '0';
            if (check[index] == -1) {
                return false;
            } else if (check[index] == 1) {
                diff = true;
            }
        }
        return diff;
    }

    char[] digits;
    int[][] cache;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了58.13% 的Java用户
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     */
    private int rotateDigits2(int n) {
        digits = String.valueOf(n).toCharArray();
        int length = digits.length;
        cache = new int[length][2];
        for (int[] a : cache) {
            Arrays.fill(a, -1);
        }
        return dfs(0, 0, true);
    }

    /**
     * 深度遍历搜索 + 记忆化存储
     *
     * @param i       当前第i位
     * @param diff    前面数字是否已经有旋转数字了
     * @param isLimit 当前数字是否收到边界限制
     * @return 从当前第i位开始可构成多少个满足要求的数字数量
     */
    private int dfs(int i, int diff, boolean isLimit) {
        if (i == digits.length) {
            // diff=0表示无效旋转，diff=1表示有效旋转
            return diff;
        }

        // 不受约束时才记忆存储，受限制和不受限制的数量是不同的
        if (!isLimit && cache[i][diff] >= 0) {
            return cache[i][diff];
        }

        int sum = 0;
        // 受限制时的最大值为当前值，否则为 9
        int up = isLimit ? digits[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            if (check[d] != -1) {
                sum += dfs(i + 1, diff | check[d], isLimit && (d == up));
            }
        }

        // 不受约束时才记忆存储，受限制和不受限制的数量是不同的
        if (!isLimit) {
            cache[i][diff] = sum;
        }
        return sum;
    }

}

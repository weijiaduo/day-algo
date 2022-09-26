package com.wjd.practice.leetcode.bit;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 面试题 17.19 消失的两个数字
 * <p>
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。
 * <p>
 * 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 *
 * @author weijiaduo
 * @since 2022/9/26
 */
public class MissingTwo implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] nums = {1};
        int[] result = missingTwo(nums);
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 思路：
     * <p>
     * 假设丢失的数字是 x1, x2。
     * <p>
     * 数组 nums 和 [1-n] 所有数字异或，剩下的值就是丢失的 2 个数字的异或值 x = x1^x2
     * <p>
     * x 数位中的 1，是 x1^x2 得到的，那么 x1, x2 中，肯定有一个是 1，一个是 0，异或结果才能是 1
     * <p>
     * 因此可以利用这个数位的值 1/0，分成 2 类，一类位值是 1 的，一类位值是 0 的
     * <p>
     * 按照分类，将 nums 和 [1-n] 所有数字分类，最后 x1 和 x2 肯定在不同分类中
     * <p>
     * 而没有丢失的数据，分别在 nums 和 [1-n] 中存在，肯定分到同一类中
     * <p>
     * 此时将 2 个分类分别异或，最后 2 个分类的异或结果就分别是 x1 和 x2
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:43.8 MB,击败了15.71% 的Java用户
     */
    private int[] missingTwo(int[] nums) {
        int n = nums.length + 2;

        // 求出2个丢失数字的异或结果 x1^x2
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        for (int i = 1; i <= n; i++) {
            x ^= i;
        }

        // 取出异或结果x的最低位1
        int mask = x & (-x);

        // 按照位值分类，并异或求结果
        int x1 = 0, x2 = 0;
        for (int num : nums) {
            if ((num & mask) == mask) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & mask) == mask) {
                x1 ^= i;
            } else {
                x2 ^= i;
            }
        }

        return new int[]{x1, x2};
    }

}

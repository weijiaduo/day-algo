package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 56.1 数组中数字出现的次数
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * <p>
 * 请写程序找出这两个只出现一次的数字。
 * <p>
 * 要求时间复杂度是 O(n)，空间复杂度是 O(1)。
 * <p>
 * 例如输入数组 {1, 2, 3, 4, 4, 1}，输出 2 和 3。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class NumbersAppearOnce {

    /**
     * 思路：异或运算
     * <p>
     * 数组所有数字异或起来， 最后等于两个只出现一次的数字异或起来
     * <p>
     * 找到异或结果中第一个为 1 的位，说明两个数字在这一位上不同
     * <p>
     * 根据这一位是否为 1，将数组分成两组，每组包含一个只出现一次的数字
     * <p>
     * 两组分别异或，得到两个数字
     * <p>
     * 比如 {2, 4, 3, 6, 3, 2, 5, 5}，异或结果为 0010
     * <p>
     * 说明两个数字在第二位上不同，所以可以根据第二位是否为 1 将数组分成两组
     * <p>
     * 第一组 {2, 3, 6, 3, 2}，异或结果为 0100，得到数字 4
     * <p>
     * 第二组 {4, 5, 5}，异或结果为 0001，得到数字 1
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,4,4,1]"},
            output = {"[2,3]"})
    public int[] find(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        // 找出两个只出现一次的数字异或结果中有差异的位
        int groupMark = getGroupMark(nums);
        // 根据这一位是否为 1，将数组分成两组
        // 两组分别进行异或，最终可得到两个数字
        int num1 = 0, num2 = 0;
        for (int t : nums) {
            if ((groupMark & t) == 0) {
                num1 ^= t;
            } else {
                num2 ^= t;
            }
        }
        return new int[]{num1, num2};
    }

    /**
     * 获取分组标记位
     *
     * @param nums 数组
     * @return 分组标记位
     */
    private int getGroupMark(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }
        // 取最右边的 1 作为分组标记位
        return mask & (mask - 1) ^ mask;
    }

}

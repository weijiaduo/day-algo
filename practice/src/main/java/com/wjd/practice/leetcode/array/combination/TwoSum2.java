package com.wjd.practice.leetcode.array.combination;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * <p>
 * numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @since 2021-05-29
 */
public class TwoSum2 {

    /**
     * 升序数组中，两个数满足相加之和等于目标数
     *
     * @param numbers 升序数组
     * @param target  目标和
     * @return 两个数的索引
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length < 2) {
            return result;
        }
        int lp = 0, rp = numbers.length - 1;
        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];
            if (sum == target) {
                result[0] = lp + 1;
                result[1] = rp + 1;
                break;
            }
            if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return result;
    }

}

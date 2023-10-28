package com.wjd.practice.leetcode.array.combination;

import com.wjd.practice.TestCase;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，
 * <p>
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * <p>
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * <p>
 * 则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 提示：
 * <p>
 * 2 <= numbers.length <= 3 * 10⁴
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 *
 * @since 2021-05-29
 */
public class TwoSum2 {

    /**
     * 思路：双指针，左右指针分别指向前后两端。计算 2 个数的和
     * <p>
     * 1. 如果大于指定值，收缩右边界
     * <p>
     * 2. 如果小于指定值，收缩左边界
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了98.81% 的Java用户
     * 内存消耗:45 MB,击败了42.39% 的Java用户
     */
    @TestCase(input = {"[2,7,11,15]", "9", "[2,3,4]", "6", "[-1,0]", "-1"},
            output = {"[1,2]", "[1,3]", "[1,2]"})
    public int[] doublePoint(int[] numbers, int target) {
        int lp = 0, rp = numbers.length - 1;
        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];
            if (sum == target) {
                return new int[]{lp + 1, rp + 1};
            }
            if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return new int[]{-1, -1};
    }

}

package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 61. 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌,判断是不是一个顺子,
 * <p>
 * 即这5张牌是不是连续的。2~10为数字本身,A为1,J为11,Q为12,K为13,
 * <p>
 * 而大、小王为 0 ,可以看成任意数字。A 不能视为 14。
 *
 * @author weijiaduo
 * @since 2023/11/29
 */
public class ContinuousCards {

    /**
     * 思路：排序 + 遍历
     * <p>
     * 遍历每个非 0 元素，看它们之间的差值是否小于等于 0 的个数
     * <p>
     * 如果小于等于 0 的个数，说明可以通过用 0 补充差值，构成连续的顺子
     * <p>
     * 比如 [3,6]，差值是 6 - 3 - 1 = 2，如果有 2 个 0，就可以构成顺子 [3,4,5,6]
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     */
    @TestCase(input = {
            "[1,0,3,0,2]",
            "[1,1,3,0,2]",
            "[1,4,3,5,2]"},
            output = {"true", "false", "true"})
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        // 排序
        Arrays.sort(numbers);

        // 统计 0 的个数
        int numOfZero = 0;
        int n = numbers.length;
        for (int i = 0; i < n && numbers[i] == 0; i++) {
            numOfZero++;
        }

        // 统计非 0 的差值和
        int numOfGap = 0;
        for (int i = numOfZero; i < n - 1; i++) {
            // 有对子，则不可能是顺子
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            numOfGap += numbers[i + 1] - numbers[i] - 1;
        }

        return numOfGap <= numOfZero;
    }

}

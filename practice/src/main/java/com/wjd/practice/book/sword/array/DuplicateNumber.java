package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 3. 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * <p>
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * <p>
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class DuplicateNumber {

    /**
     * 思路：遍历数组，将数字放到对应的下标位置，如果下标位置已经有对应的数字，则返回
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[2,3,1,0,2,5,3]", "[1,2,0]"},
            output = {"2", "-1"})
    public int duplicate(int[] numbers) {
        if (numbers == null) {
            return -1;
        }

        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            // 摆放数字到对应的下标位置
            while (numbers[i] != i) {
                // 超出范围的数字
                if (numbers[i] >= n) {
                    return -1;
                }
                // 找到重复数字
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                // 交换数字
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return -1;
    }

}

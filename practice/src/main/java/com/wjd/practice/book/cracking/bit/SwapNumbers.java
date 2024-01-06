package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 16.01. 交换数字
 * <p>
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * <p>
 * 提示：
 * <p>
 * numbers.length == 2
 * -2147483647 <= numbers[i] <= 2147483647
 *
 * @author weijiaduo
 * @since 2024/1/6
 */
public class SwapNumbers {

    /**
     * 思路：异或
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.4 MB,击败了5.19% 的Java用户
     */
    @TestCase(input = {"[1,2]", "[0,2147483647]", "[0,-2147483648]"},
            output = {"[2,1]", "[2147483647,0]", "[-2147483648,0]"})
    public int[] swap(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }

}

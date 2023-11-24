package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * <p>
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * <p>
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author weijiaduo
 * @since 2023/11/24
 */
public class ReorderArray {

    /**
     * 思路：左右双指针
     * <p>
     * 左指针从左往右找偶数，右指针从右往左找奇数，找到后交换
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,4,5,6,7]"},
            output = {"[1,7,3,5,4,6,2]"})
    public void reorder(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int lp = 0, rp = array.length - 1;
        while (lp < rp) {
            // 左指针找偶数
            while (lp < rp && (array[lp] & 1) == 1) {
                lp++;
            }
            // 右指针找奇数
            while (lp < rp && (array[rp] & 1) == 0) {
                rp--;
            }
            if (lp < rp) {
                int t = array[lp];
                array[lp] = array[rp];
                array[rp] = t;
            }
        }
    }

}

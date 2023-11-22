package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 4. 二维数组中的查找
 * <p>
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序。
 * <p>
 * 每一列都按照从上到下递增的顺序排序。
 * <p>
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class FindNumberInSortedArray {

    /**
     * 思路：排除法，从右上角开始查找，
     * <p>
     * 如果当前数字大于目标数字，则向左移动一位。
     * <p>
     * 如果当前数字小于目标数字，则向下移动一位。
     * <p>
     * 复杂度：时间 O(m+n) 空间 O(1)
     */
    @TestCase(input = {"[[1,2],[3,4],[5,6]]", "2"}, output = "true")
    public boolean find(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int rows = array.length, cols = array[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}

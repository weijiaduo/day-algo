package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

/**
 * 面试题 10.03. 搜索旋转数组
 * <p>
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * <p>
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。
 * <p>
 * 若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * <p>
 * 示例2:
 * <p>
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * <p>
 * 提示:
 * <p>
 * arr 长度范围在[1, 1000000]之间
 *
 * @author weijiaduo
 * @since 2024/1/4
 */
public class SearchInRotateArray {

    /**
     * 思路：二分法
     * <p>
     * 需要注意数组里面的重复值判断，以及返回更小索引的情况
     * <p>
     * 由于重复值的存在，情况变得复杂很多
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.3 MB,击败了5.16% 的Java用户
     */
    @TestCase(input = {"[15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14]", "5",
            "[15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14]", "11",
            "[3,3,4,1,2,2,3,3]", "3",
            "[1,-2]", "-2"},
            output = {"8", "-1", "0", "1"})
    public int binary(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            // 返回更小的索引
            if (arr[l] == target) {
                return l;
            }
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                r = m;
            } else if (arr[m] > arr[l]) {
                // 左边有序
                if (arr[l] < target && target < arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (arr[m] < arr[r]) {
                // 右边有序
                if (arr[m] < target && target <= arr[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // 无法确定左右两边的有序性
                // 但可以确定 arr[l] != target
                l++;
            }
        }
        return -1;
    }

}

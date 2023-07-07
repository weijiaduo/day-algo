package com.wjd.practice.leetcode.array.sort;

import com.wjd.practice.leetcode.TestCase;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组nums ，
 * <p>
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * <p>
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @since 2022/6/4
 */
public class SortColors {

    /**
     * 思路：双指针法，左指针指向0，右指针指向2
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了36.67% 的Java用户
     */
    @TestCase(input = {"[2,0,2,1,1,0]", "[2,0,1]"},
            output = {"[0,0,1,1,2,2]", "[0,1,2]"})
    public void doublePoint(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                // 从前往后交换，元素已经验证过了
                // 下一个访问元素是下一个位置
                nums[i] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[i] == 2) {
                // 从后往前交换，元素还没有验证过
                // 下一个元素还是当前位置
                nums[i--] = nums[p2];
                nums[p2--] = 2;
            }
        }
    }

}

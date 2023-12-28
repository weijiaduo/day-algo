package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

/**
 * 面试题 08.03. 魔术索引
 * <p>
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * <p>
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * <p>
 * 若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * <p>
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * <p>
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 *
 * @author weijiaduo
 * @since 2023/12/28
 */
public class FindMagicIndex {

    /**
     * 思路：朴素遍历，验证是否满足条件
     * <p>
     * 假如 nums[i] > i，那么在 [i, nums[i]) 之间的数字肯定是不符合的
     * <p>
     * 可利用这个特性来剪枝
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.7 MB,击败了5.19% 的Java用户
     */
    @TestCase(input = {"[0, 2, 3, 4, 5]", "[1, 1, 1]"},
            output = {"0", "1"})
    public int find(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ) {
            if (nums[i] == i) {
                return i;
            }
            i = Math.max(nums[i], i + 1);
        }
        return -1;
    }

}

package com.wjd.practice.leetcode.array.statistics;

import java.util.HashSet;
import java.util.Set;

/**
 * 645. 错误的集合
 * <p>
 * 集合 s 包含从 1 到 n 的整数。
 * <p>
 * 不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 * @author weijiaduo
 * @since 2023/5/18
 */
public class FindErrorNums {

    /**
     * 思路：先用哈希找出重复元素，再通过总和之差得到重复元素和丢失元素的差值，就能推算出丢失元素
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:6 ms,击败了51.82% 的Java用户
     * 内存消耗:43.5 MB,击败了18.70% 的Java用户
     *
     * @param nums 数组
     * @return 丢失的2个数
     */
    public int[] findErrorNums(int[] nums) {
        int repeat = 0, missing = 0;
        int n = nums.length;
        long expectSum = (long) (1 + n) * n / 2;
        long actualSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
            } else {
                actualSum += num;
            }
        }
        missing = (int) (expectSum - actualSum);
        return new int[]{repeat, missing};
    }

}

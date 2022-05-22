package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 41. 缺失的第一个整数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * <p>
 * @since 2022/5/22
 */
public class FirstMissingPositive implements Solution<Integer> {

    @Override
    public Integer solve(Object args) {
        int[] nums = {1};
        int result = firstMissingPositive(nums);
        System.out.println(result);
        return null;
    }

    /**
     * 索引排序法
     * <p>
     * 执行耗时:2 ms,击败了94.73% 的Java用户
     * 内存消耗:96.9 MB,击败了70.02% 的Java用户
     */
    public int firstMissingPositive(int[] nums) {
        int next = 0;
        while (next < nums.length) {
            int num = nums[next];
            if (next == num - 1) {
                // 数字在正确的位置
                next++;
                continue;
            }

            if (0 < num && num <= nums.length) {
                // 正常数字范围内
                int temp = nums[num - 1];
                if (temp != num) {
                    // 避免重复数字出现死循环
                    nums[num - 1] = num;
                    nums[next] = temp;
                    // 交换后，next 不用变
                    continue;
                }
            }
            next++;
        }

        // 顺序遍历数字，找到缺失的数字
        for (next = 1; next <= nums.length; next++) {
            if (nums[next - 1] != next) {
                return next;
            }
        }
        return next;
    }

    /**
     * 官方解法
     * <p>
     * 这个解法还挺骚气的~~~~
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        // 非法数值都改成超出正常范围的值
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // 改成负数，标记成此处索引的值存在
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                // 不是负数，证明此处索引对应的值不存在
                return i + 1;
            }
        }
        return n + 1;
    }
}

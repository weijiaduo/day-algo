package com.wjd.practice.leetcode.array.statistics;

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
 *
 * @since 2022/5/22
 */
public class FirstMissingPositive {

    /**
     * 思路：将数字放到它对应的索引位置上，如果索引和数字对不上，就说明丢失了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了97.45% 的Java用户
     * 内存消耗:57.9 MB,击败了10.69% 的Java用户
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i == num - 1) {
                // 数字在正确的位置
                continue;
            }

            if (0 < num && num <= n) {
                int temp = nums[num - 1];
                if (temp != num) {
                    // 避免重复数字出现死循环
                    nums[num - 1] = num;
                    nums[i] = temp;
                    // 交换后，i 不用变
                    i--;
                }
            }
        }

        // 顺序遍历数字，找到缺失的数字
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }
        return n + 1;
    }

    /**
     * 官方解法
     * <p>
     * 这个解法还挺骚气的~~~~
     * <p>
     * 思路：将 nums[i] 对应索引位置的值改成负数，最后如果 nums[i] 不是负数，表明该位置的数字丢失了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    private int firstMissingPositive2(int[] nums) {
        // 非法数值都改成超出正常范围的值
        int n = nums.length;
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

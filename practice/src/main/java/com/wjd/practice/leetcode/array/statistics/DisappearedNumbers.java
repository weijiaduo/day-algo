package com.wjd.practice.leetcode.array.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * <p>
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * @since 2021-05-31
 */
public class DisappearedNumbers {

    /**
     * 思路：把 nums[i]-1 当成索引，设置到它应该在的位置，过程类似于排序
     * <p>
     * 然后再遍历一轮数组，如果指定索引上的值不等于索引，就认为是丢失了
     * <p>
     * 复杂度: 时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了49.01% 的Java用户
     * 内存消耗:52 MB,击败了6.03% 的Java用户
     *
     * @param nums 数组
     * @return 消失的数字
     */
    private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i] - 1;
            while (0 <= t && t < n && nums[t] != nums[i]) {
                // 循环交换到正确的位置
                int tmp = nums[t];
                nums[t] = nums[i];
                nums[i] = tmp;
                t = nums[i] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * 思路：把索引 nums[i] - 1 的值加上 n，使其和大于 n
     * <p>
     * 再遍历数组，如果发现 nums[i] 的值没有大于 n，则表明该索引对应的数字丢失了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了99.10% 的Java用户
     * 内存消耗:51.9 MB,击败了7.42% 的Java用户
     *
     * @param nums 数组
     * @return 消失的数字
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = (nums[i] - 1) % n;
            nums[t] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

}

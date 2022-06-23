package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * @author weijiaduo
 * @since 2022/6/23
 */
public class LongestConsecutive implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutive(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：哈希表，使用哈希保存每个值的连续长度
     *
     * 执行耗时:29 ms,击败了43.70% 的Java用户
     * 内存消耗:58 MB,击败了24.75% 的Java用户
     */
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        Map<Integer, Integer> lengths = new HashMap<>(n);
        for (int num : nums) {
            if (lengths.containsKey(num)) {
                continue;
            }

            // 获取左边和右边的连续长度
            int left = lengths.getOrDefault(num - 1, 0);
            int right = lengths.getOrDefault(num + 1, 0);
            int length = left + 1 + right;
            lengths.put(num, length);
            if (left > 0) {
                // 更新左边界
                lengths.put(num - left, length);
            }
            if (right > 0) {
                // 更新右边界
                lengths.put(num + right, length);
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    /**
     * 官解：遍历到x，就寻找后面的 x+1, x+2...， 同时为了避免重复遍历，需要判断 x-1 是否已经遍历过了
     *
     * 好像也不是很快啊，话说最快的方法是啥？
     *
     * 执行耗时:19 ms,击败了56.17% 的Java用户
     * 内存消耗:59.8 MB,击败了8.21% 的Java用户
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            // 前一个值已经遍历过了，就不再重复遍历
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 寻找一直连续的序列
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}

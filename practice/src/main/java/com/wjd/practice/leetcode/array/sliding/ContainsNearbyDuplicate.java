package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * <p>
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * 0 <= k <= 10⁵
 *
 * @since 2021-05-29
 */
public class ContainsNearbyDuplicate {

    /**
     * 思路：哈希表，记录数字的上一个位置
     * <p>
     * 当遍历到当前数字时，判断和上一个位置的距离即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:14 ms,击败了95.54% 的Java用户
     * 内存消耗:53.8 MB,击败了75.45% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "3",
            "[1,0,1,1]", "1",
            "[1,2,3,1,2,3]", "2",
            "[1,2,1]", "0"},
            output = {"true", "true", "false", "false"})
    public boolean hash(int[] nums, int k) {
        int n = nums.length;
        // 初始化容量很重要，有些用例会导致扩容频繁
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            Integer j = map.get(nums[i]);
            if (j != null && i - j <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 思路：滑动窗口，使用一个大小为 k 的窗口
     * <p>
     * 统计窗口内的字符，如果出现重复，则满足条件
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:14 ms,击败了95.54% 的Java用户
     * 内存消耗:54.5 MB,击败了61.85% 的Java用户
     */
    @TestCase(input = {"[1,2,3,1]", "3",
            "[1,0,1,1]", "1",
            "[1,2,3,1,2,3]", "2",
            "[1,2,1]", "0"},
            output = {"true", "true", "false", "false"})
    public boolean slide(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 右边扩展
            if (!set.add(nums[i])) {
                return true;
            }
            // 左边收缩
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}

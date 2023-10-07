package com.wjd.practice.leetcode.hash;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2215. 找出两数组的不同
 * <p>
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 * <p>
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * <p>
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * <p>
 * 注意：列表中的整数可以按 任意 顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出：[[1,3],[4,6]]
 * 解释：
 * 对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在nums2 中。
 * <p>
 * 因此，answer[0] = [1,3]。
 * <p>
 * 对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在nums2 中。
 * <p>
 * 因此，answer[1] = [4,6]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * 输出：[[3],[]]
 * 解释：
 * 对于 nums1 ，nums1[2] 和 nums1[3] 没有出现在 nums2 中。
 * <p>
 * 由于 nums1[2] == nums1[3] ，二者的值只需要在answer[0] 中出现一次，故 answer[0] = [3]。
 * <p>
 * nums2 中的每个整数都在 nums1 中出现，因此，answer[1] = [] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 *
 * @author weijiaduo
 * @since 2023/10/7
 */
public class FindDifference {

    /**
     * 思路：哈希，分别用哈希表记录两个数组的值，然后找出不同
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了69.70% 的Java用户
     * 内存消耗:43.3 MB,击败了59.85% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[2,4,6]", "[1,2,3,3]", "[1,1,2,2]"},
            output = {"[[1,3],[4,6]]", "[[3],[]]"})
    public List<List<Integer>> hash(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();
        for (Integer num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }
        List<Integer> list2 = new ArrayList<>();
        for (Integer num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(2);
        ans.add(list1);
        ans.add(list2);
        return ans;
    }

}

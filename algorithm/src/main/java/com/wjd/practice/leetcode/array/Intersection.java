package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.*;

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * @author weijiaduo
 * @since 2022/9/8
 */
public class Intersection implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersection2(nums1, nums2);
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 思路：用Set来标记数据，判断重复时则是交集
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了95.36% 的Java用户
     * 内存消耗:41.2 MB,击败了96.68% 的Java用户
     *
     * @param nums1 数组
     * @param nums2 数组
     * @return 数组交集
     */
    private int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> interSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                interSet.add(num);
            }
        }

        int k = 0;
        int size = interSet.size();
        int[] ans = new int[size];
        for (int num : interSet) {
            ans[k++] = num;
        }

        return ans;
    }

    /**
     * 思路：先排序，然后逐个比较2个数组元素的大小，相等即交叉，并且去掉重复值
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了95.36% 的Java用户
     * 内存消耗:41.9 MB,击败了9.02% 的Java用户
     *
     * @param nums1 数组
     * @param nums2 数组
     * @return 数组交集
     */
    private int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                while (i < m && nums1[i] == nums1[i - 1]) {
                    i++;
                }
                j++;
                while (j < n && nums2[j] == nums2[j - 1]) {
                    j++;
                }
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int size = list.size();
        int[] ans = new int[size];
        for (int k = 0; k < size; k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }

}

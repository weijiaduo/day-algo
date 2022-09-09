package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.*;

/**
 * 350. 两个数组的交集2
 * <p>
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * <p>
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * <p>
 * 可以不考虑输出结果的顺序。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * @author weijiaduo
 * @since 2022/9/9
 */
public class Intersection2 implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 思路：用Map来记录次频率，判断重复时减去频率
     * <p>
     * 复杂度：时间 O(m + n) 空间 O(m + n)
     * <p>
     * 执行耗时:3 ms,击败了39.49% 的Java用户
     * 内存消耗:41.3 MB,击败了81.92% 的Java用户
     *
     * @param nums1 数组
     * @param nums2 数组
     * @return 数组交集
     */
    private int[] intersect(int[] nums1, int[] nums2) {
        // 小数组优先遍历
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // 统计小数组的数字频率
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 遍历大数组，减去频率获得交叉值
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int c = count.getOrDefault(num, 0);
            if (c > 0) {
                list.add(num);
                count.put(num, c - 1);
            }
        }

        int k = 0;
        int size = list.size();
        int[] ans = new int[size];
        for (int num : list) {
            ans[k++] = num;
        }

        return ans;
    }

    /**
     * 思路：先排序，然后逐个比较2个数组元素的大小，相等即交叉
     * <p>
     * 复杂度：时间 O(mlogm + nlogn) 空间 O(min(m, n))
     * <p>
     * 执行耗时:2 ms,击败了96.30% 的Java用户
     * 内存消耗:41.7 MB,击败了41.05% 的Java用户
     *
     * @param nums1 数组
     * @param nums2 数组
     * @return 数组交集
     */
    private int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
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

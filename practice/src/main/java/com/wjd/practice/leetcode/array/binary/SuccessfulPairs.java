package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2300. 咒语和药水的成功对数
 * <p>
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，
 * <p>
 * 其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * <p>
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * <p>
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * <p>
 * 提示：
 * <p>
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 10⁵
 * 1 <= spells[i], potions[i] <= 10⁵
 * 1 <= success <= 10¹⁰
 *
 * @author weijiaduo
 * @since 2023/10/12
 */
public class SuccessfulPairs {

    /**
     * 思路：二分法，对药水进行排序，然后用二分法定位 >= 指定值的索引，就能拿到数量
     * <p>
     * 复杂度：时间 O(mlogm + nlogm) 空间 O(logm)
     * <p>
     * 执行耗时:49 ms,击败了38.61% 的Java用户
     * 内存消耗:55.4 MB,击败了56.56% 的Java用户
     */
    @TestCase(input = {"[5,1,3]", "[1,2,3,4,5]", "7",
            "[3,1,2]", "[8,5,8]", "16"},
            output = {"[4,0,3]", "[2,0,2]"})
    public int[] binary(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = (int) Math.ceil(1.0 * success / spells[i]);
            ans[i] = m - firstGreatEqual(potions, val);
        }
        return ans;
    }

    /**
     * 二分法，求第一个大于等于 val 的位置
     *
     * @param arr 有序数组
     * @param val 指定值
     * @return 索引
     */
    private int firstGreatEqual(int[] arr, int val) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= val) {
                if (m == 0 || arr[m - 1] < val) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return n;
    }

    /**
     * 思路：双指针，对两个数组都进行排序，然后用双指针来判断其合法位置
     * <p>
     * 复杂度：时间 O(mlogm + nlogm) 空间 O(n + logm)
     * <p>
     * 执行耗时:71 ms,击败了5.25% 的Java用户
     * 内存消耗:63.4 MB,击败了5.08% 的Java用户
     */
    @TestCase(input = {"[5,1,3]", "[1,2,3,4,5]", "7",
            "[3,1,2]", "[8,5,8]", "16"},
            output = {"[4,0,3]", "[2,0,2]"})
    public int[] doublePoint(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[][] idxes = new int[n][2];
        for (int i = 0; i < n; i++) {
            idxes[i][0] = spells[i];
            idxes[i][1] = i;
        }
        Arrays.sort(idxes, Comparator.comparingInt(a -> a[0]));

        int[] ans = new int[n];
        for (int i = 0, j = m - 1; i < n; i++) {
            int idx = idxes[i][1];
            int val = idxes[i][0];
            while (j >= 0 && (long) val * potions[j] >= success) {
                j--;
            }
            ans[idx] = m - 1 - j;
        }
        return ans;
    }

}

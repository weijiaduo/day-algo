package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到K个最接近的元素
 * <p>
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * @author weijiaduo
 * @since 2022/8/25
 */
public class FindClosestElements implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        int[] arr = {1, 3};
        int k = 1;
        int x = 5;
        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println(result);
        return null;
    }

    /**
     * 思路：
     * <p>
     * 先用二分法找到第一个大于等于x的值，因为要求是从小到大获取结果
     * <p>
     * 然后再用左右双指针，从这个数向左右两边扩展，直至拿到K个数
     * <p>
     * 复杂度：时间 O(logn + k) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了99.16% 的Java用户
     * 内存消耗:43.5 MB,击败了39.85% 的Java用户
     *
     * @param arr 数组
     * @param k   k
     * @param x   x
     * @return k个数
     */
    private List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);
        if (k <= 0) {
            return ans;
        }

        // 找到第一个大于等于x的值
        int rp = binaryFindNotLessThan(arr, x);
        int lp = rp - 1;

        // 双指针法向两边扩展
        int n = arr.length;
        while (rp - lp - 1 < k) {
            if (lp < 0 && rp >= n) {
                break;
            }
            if (lp < 0) {
                rp++;
            } else if (rp >= n) {
                lp--;
            } else {
                if (x - arr[lp] <= arr[rp] - x) {
                    lp--;
                } else {
                    rp++;
                }
            }
        }

        for (int i = lp + 1; i < rp; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    /**
     * 二分查找第一个大于等于x的值
     */
    private int binaryFindNotLessThan(int[] arr, int x) {
        int n = arr.length;
        int lp = 0, rp = n - 1;
        while (lp <= rp) {
            int mp = lp + (rp - lp) / 2;
            if (x <= arr[mp]) {
                if (mp == 0 || x > arr[mp - 1]) {
                    return mp;
                }
                rp = mp - 1;
            } else {
                lp = mp + 1;
            }
        }
        return lp;
    }

}

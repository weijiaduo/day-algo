package com.wjd.algorithm.structure;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 6, 3};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = partSortLeftPointer(a, left, right);
            quickSort(a, left, mid - 1);
            quickSort(a, mid + 1, right);
        }
    }

    /**
     * 从小到大
     * 一般法
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int partSortLeft(int[] a, int left, int right) {
        if (a == null || left > right) {
            return -1;
        }

        // 左端基准值
        int x = a[left];
        int lp = left, rp = right;
        while (lp < rp) {

            // 先右遍历取小值
            while (lp < rp && a[rp] >= x) {
                rp--;
            }

            // 再左遍历取大值
            while (lp < rp && a[lp] <= x) {
                lp++;
            }

            if (lp < rp) {
                a[lp] = a[lp] ^ a[rp];
                a[rp] = a[lp] ^ a[rp];
                a[lp] = a[lp] ^ a[rp];
            }
        }

        // 交换基准值
        if (left < lp) {
            a[lp] = a[lp] ^ a[left];
            a[left] = a[lp] ^ a[left];
            a[lp] = a[lp] ^ a[left];
        }

        return lp;
    }

    /**
     * 从小到大
     * 挖坑法
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int partSortLeftHole(int[] a, int left, int right) {
        if (a == null || left > right) {
            return -1;
        }

        // 左端基准值
        int x = a[left];
        int lp = left, rp = right;
        while (lp < rp) {

            // 先右遍历取小值
            while (lp < rp && a[rp] >= x) {
                rp--;
            }
            a[lp] = a[rp];

            // 再左遍历取大值
            while (lp < rp && a[lp] <= x) {
                lp++;
            }
            a[rp] = a[lp];
        }

        // 基准值
        a[lp] = x;

        return lp;
    }

    /**
     * 从小到大
     * 前后指针法
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int partSortLeftPointer(int[] a, int left, int right) {
        if (a == null || left > right) {
            return -1;
        }

        // 左端基准值
        int x = a[left];
        int cur = right, pre = cur + 1;
        while (cur > left) {
            if (a[cur] > x) {
                --pre;
                if (pre != cur) {
                    a[pre] = a[pre] ^ a[cur];
                    a[cur] = a[pre] ^ a[cur];
                    a[pre] = a[pre] ^ a[cur];
                }
            }
            --cur;
        }

        // 基准值
        if (--pre != left) {
            a[pre] = a[pre] ^ a[left];
            a[left] = a[pre] ^ a[left];
            a[pre] = a[pre] ^ a[left];
        }

        return pre;
    }

}

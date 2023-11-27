package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

/**
 * 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * <p>
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * <p>
 * 如果不存在则输出0。
 *
 * @author weijiaduo
 * @since 2023/11/27
 */
public class MoreThanHalfNumber {

    /**
     * 思路：摩尔投票法，每次从数组中找出一对不同的元素，将其从数组中删除，直到数组为空或只剩下一种元素
     * <p>
     * 如果存在超过一半的元素，则这个元素一定会留到最后
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,2,2,2,5,4,2]"}, output = "2")
    public int moore(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int x = nums[0], cnt = 1;
        for (int i = 1; i < n; i++) {
            if (cnt == 0) {
                x = nums[i];
                cnt = 1;
            } else {
                if (nums[i] == x) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }

        return check(nums, x) ? x : 0;
    }

    /**
     * 思路：快速排序的思想
     * <p>
     * 如果存在超过一半的元素，则排序后，中间的元素一定是该元素
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"[1,2,3,2,2,2,5,4,2]"}, output = "2")
    public int quicksort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int x = 0;
        int left = 0, right = nums.length - 1, mid = nums.length >> 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == mid) {
                x = nums[index];
                break;
            } else if (index > mid) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }

        return check(nums, x) ? x : 0;
    }

    /**
     * 快速排序的分区函数
     *
     * @param nums 数组
     * @param low  [low, high] 闭区间
     * @param high [low, high] 闭区间
     * @return 分区点
     */
    private int partition(int[] nums, int low, int high) {
        int lp = low, rp = high;
        int x = nums[low];
        while (lp < rp) {
            while (lp < rp && nums[rp] >= x) {
                rp--;
            }
            while (lp < rp && nums[lp] <= x) {
                lp++;
            }
            swap(nums, lp, rp);
        }
        swap(nums, low, lp);
        return lp;
    }

    /**
     * 交换数组中两个元素
     *
     * @param nums 数组
     * @param i    元素下标
     * @param j    元素下标
     */
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 检查该数字出现次数是否超过一半
     *
     * @param nums 数组
     * @param num  数字
     * @return true/false
     */
    private boolean check(int[] nums, int num) {
        int count = 0, len = nums.length;
        for (int j : nums) {
            if (j == num) {
                count++;
            }
        }
        return count > (len >> 1);
    }

}

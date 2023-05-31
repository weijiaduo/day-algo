package com.wjd.practice.leetcode.array.statistics;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * <p>
 * 多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @since 2021-05-29
 */
public class MajorityElement {

    /**
     * 寻找出现次数大于一半的元素
     *
     * @param nums 数组
     * @return 大于一半数量的元素
     */
    public int majorityElement(int[] nums) {
        // 投票法，相同值+1，不同值-1
        // 因为有一半元素以上是同一个值，所以最终投票结果肯定是超过半数的那个元素
        int x = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                x = nums[i];
                count++;
                continue;
            }
            if (x == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return x;
    }

}

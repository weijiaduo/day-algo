package com.wjd.practice.leetcode.array.transform;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * <p>
 * 给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。
 * <p>
 * 你可以执行此过程任意次。
 * <p>
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 * <p>
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出：true
 * 解释：你可以按照如下步骤使 arr 变成 target：
 * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 *
 * @author weijiaduo
 * @since 2022/8/24
 */
public class RotateBeEqual {

    /**
     * 思路：
     * <p>
     * 交换数组中i和j的位置，只需要先翻转[i,j]，再翻转[i+1,j-1]，就能得到。
     * <p>
     * 所以，2个数组是否可以通过翻转得到，只需要判断它包含的数字是否相同即可。
     * <p>
     * 因为只要数字都相同，那么就能通过翻转替换元素位置，从而得到另一个数组。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了8.25% 的Java用户
     * 内存消耗:41.5 MB,击败了17.22% 的Java用户
     *
     * @param target 数组
     * @param arr    数组
     * @return true/false
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : target) {
            int c = count.getOrDefault(num, 0);
            count.put(num, c + 1);
        }
        for (int num : arr) {
            int c = count.getOrDefault(num, 0);
            count.put(num, c - 1);
        }
        for (int c : count.values()) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

}

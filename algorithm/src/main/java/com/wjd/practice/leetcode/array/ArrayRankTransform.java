package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 * <p>
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 *
 * @author weijiaduo
 * @since 2022/7/28
 */
public class ArrayRankTransform implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] result = arrayRankTransform(arr);
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 思路：对数组排序，再统计排名，最后再从统计中获取排名值，排名记录在哈希表中
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:21 ms,击败了76.10% 的Java用户
     * 内存消耗:56.2 MB,击败了69.88% 的Java用户
     *
     * @param arr 数组
     * @return 排名索引数组
     */
    private int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return arr;
        }

        // 数组排序
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);

        // 统计排名
        Map<Integer, Integer> map = new HashMap<>(n);
        int last = copy[0], k = 1;
        map.put(copy[0], k);
        for (int i = 1; i < n; i++) {
            if (copy[i] == last) {
                continue;
            }
            last = copy[i];
            map.put(copy[i], ++k);
        }

        // 排名索引
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = map.get(arr[i]);
        }
        return indexes;
    }

}

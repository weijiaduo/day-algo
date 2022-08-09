package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * <p>
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 *
 * @author weijiaduo
 * @since 2022/7/4
 */
public class MinimumAbsDifference implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> result = minimumAbsDifference(arr);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：先排序，然后遍历一遍数组即可
     * <p>
     * 复杂度：时间 O(nlogn + n) 空间 O(n)
     * <p>
     * 执行耗时:16 ms,击败了99.30% 的Java用户
     * 内存消耗:51.3 MB,击败了59.61% 的Java用户
     */
    private List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }

}

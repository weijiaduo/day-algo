package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 436. 寻找右区间
 * <p>
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * <p>
 * @since 2022/5/20
 */
public class FindRightInterval implements Solution<int[]> {

    @Override
    public int[] solve(Object ...args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        int[] result = doublePointFindRightInterval(intervals);
        int[] result2 = quickFindRightInterval(intervals);
        ArrayUtil.print(result);
        ArrayUtil.print(result2);
        return result;
    }

    /**
     * 暴力法
     */
    public int[] findRightInterval(int[][] intervals) {
        // 按照区间的起始点，从小到大排序
        Integer[] index = new Integer[intervals.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(o -> intervals[o][0]));

        // 验证每个区间是否存在“右侧”区间
        int[] result = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            int k = index[i];
            result[k] = -1;
            for (int j = i; j < index.length; j++) {
                if (intervals[k][1] <= intervals[index[j]][0]) {
                    result[k] = index[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 二分查找
     */
    public int[] quickFindRightInterval(int[][] intervals) {
        // 按照区间的起始点，从小到大排序
        Integer[] index = new Integer[intervals.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(o -> intervals[o][0]));

        // 验证每个区间是否存在“右侧”区间
        int[] result = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            int k = index[i];
            result[k] = -1;
            int left = i, right = index.length - 1;
            // 利用二分搜索加快寻找速度
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (intervals[k][1] <= intervals[index[mid]][0]) {
                    result[k] = index[mid];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }

    /**
     * 双指针查找
     */
    public int[] doublePointFindRightInterval(int[][] intervals) {
        // 按照区间的起始点和终结点，从小到大排序
        Integer[] startIndex = new Integer[intervals.length];
        Integer[] endIndex = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startIndex[i] = i;
            endIndex[i] = i;
        }
        Arrays.sort(startIndex, Comparator.comparingInt(o -> intervals[o][0]));
        Arrays.sort(endIndex, Comparator.comparingInt(o -> intervals[o][1]));

        // 验证每个可能是“右侧”区间的区间
        int[] result = new int[startIndex.length];
        for (int i = 0, j = 0; i < endIndex.length; i++) {
            int k = endIndex[i];
            result[k] = -1;
            // 找到比当前的终结点还大的起始点
            for (; j < startIndex.length; j++) {
                if (intervals[k][1] <= intervals[startIndex[j]][0]) {
                    result[k] = startIndex[j];
                    break;
                }
            }
        }
        return result;
    }

}

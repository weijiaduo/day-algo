package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 * <p>
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。
 * <p>
 * 另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * <p>
 * 请你以 任意顺序 连接pieces 中的数组以形成 arr 。
 * <p>
 * 但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 *
 * @author weijiaduo
 * @since 2022/9/22
 */
public class CanFormArray implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        boolean result = canFormArray2(arr, pieces);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：因为元素数值都不相同，直接遍历，模拟拼接即可
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了95.04% 的Java用户
     */
    private boolean canFormArray(int[] arr, int[][] pieces) {
        int m = arr.length, n = pieces.length;
        boolean[] visited = new boolean[n];
        int index = 0;
        while (index < m) {
            // 在 pieces 中找到等于当前元素的数组
            int i = 0;
            while (i < n && (visited[i] || pieces[i][0] != arr[index])) {
                i++;
            }
            // 没找到，肯定无法连接形成数组
            if (i == n) {
                return false;
            }

            // 验证每个元素是否相同
            int len = pieces[i].length;
            for (int j = 0; j < len; j++) {
                if (arr[index + j] != pieces[i][j]) {
                    return false;
                }
            }

            // 拼接成功，到下一条
            visited[i] = true;
            index += len;
        }
        return true;
    }

    /**
     * 思路：哈希表，数字各不相同，可将 pieces 每个数组的[0]元素作为哈希表的key，来快速定位
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了73.76% 的Java用户
     * 内存消耗:40.8 MB,击败了54.97% 的Java用户
     */
    private boolean canFormArray2(int[] arr, int[][] pieces) {
        // 记录每个 piece 的开头元素
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = pieces.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(pieces[i][0], i);
        }

        int m = arr.length;
        for (int i = 0; i < m; ) {
            // 找出每个对应的 piece
            Integer index = indexMap.get(arr[i]);
            if (index == null) {
                return false;
            }

            // 验证 piece 的每个元素是否相等
            int len = pieces[index].length;
            for (int j = 0; j < len; j++) {
                if (arr[i + j] != pieces[index][j]) {
                    return false;
                }
            }
            i += len;
        }
        return true;
    }

}

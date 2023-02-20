package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 6188. 按身高排序
 *
 * @author weijiaduo
 * @since 2022/9/25
 */
public class SortPeople implements Solution<String[]> {

    @Override
    public String[] solve(Object... args) {
        String[] names = {"Alice","Bob","Bob"};
        int[] height = {155,185,150};
        String[] result = sortPeople(names, height);
        System.out.println(Arrays.toString(result));
        return result;
    }

    private String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = names[indexes[i]];
        }
        return ans;
    }

}

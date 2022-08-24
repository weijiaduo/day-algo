package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021-05-29
 *
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class PascalTrianglePrint implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object ...args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);
        System.out.println(result);
        return result;
    }

    /**
     * 生产杨辉三角
     *
     * @param numRows 行数
     * @return 杨辉三角
     */
    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        int[] nums = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                nums[0] = 1;
            } else {
                // 倒着加，因为用到了前一个j-1
                for (int j = i; j > 0; j--) {
                    nums[j] = nums[j - 1] + nums[j];
                }
            }
            result.add(arrayToList(nums, i + 1));
        }
        return result;
    }

    /**
     * 数组转成列表
     *
     * @param num 数组
     * @param len 长度
     * @return 列表
     */
    private List<Integer> arrayToList(int[] num, int len) {
        List<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(num[i]);
        }
        return list;
    }
}

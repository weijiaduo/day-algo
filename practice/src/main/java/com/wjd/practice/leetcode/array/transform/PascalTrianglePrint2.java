package com.wjd.practice.leetcode.array.transform;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * @since 2021-05-29
 */
public class PascalTrianglePrint2 {

    /**
     * 生产杨辉三角
     *
     * @param rowIndex 行数索引
     * @return 杨辉三角
     */
    public List<Integer> getRow(int rowIndex) {
        int size = rowIndex + 1;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                nums[0] = 1;
            } else {
                // 倒着加，因为用到了前一个j-1
                for (int j = i; j > 0; j--) {
                    nums[j] = nums[j - 1] + nums[j];
                }
            }
        }
        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(nums[i]);
        }
        return result;
    }

}

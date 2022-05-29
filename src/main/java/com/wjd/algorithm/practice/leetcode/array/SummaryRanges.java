package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021-05-29
 *
 * 228. 汇总区间
 * <p>
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class SummaryRanges implements Solution<List<String>> {

    @Override
    public List<String> solve(Object ...args) {
        int[] nums = {0};
        List<String> result = summaryRanges(nums);
        System.out.println(result);
        return null;
    }

    /**
     * 数组转区间列表
     *
     * @param nums 数组
     * @return 区间列表
     */
    private List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>(nums.length);
        int lp = 0, rp = 0;
        while (rp < nums.length) {
            while (rp + 1 < nums.length && nums[rp] + 1 == nums[rp + 1]) {
                rp++;
            }
            if (nums[lp] == nums[rp]) {
                result.add("" + nums[rp]);
            } else {
                result.add(nums[lp] + "->" + nums[rp]);
            }
            rp++;
            lp = rp;
        }
        return result;
    }
}

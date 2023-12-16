package com.wjd.practice.leetcode.array.section;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * <p>
 * 给定一个 无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * <p>
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * @since 2021-05-29
 */
public class SummaryRanges {

    /**
     * 思路：双指针，直接遍历数组，找到每个区间的左右边界即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100%% 的Java用户
     * 内存消耗:39.84 MB,击败了27.36% 的Java用户
     */
    @TestCase(input = {"[0,1,2,4,5,7]", "[0,2,3,4,6,8,9]"},
            output = {
                    """
                            ["0->2","4->5","7"]""",
                    """
                            ["0","2->4","6","8->9"]"""})
    public List<String> doublePoint(int[] nums) {
        int n = nums.length;
        List<String> ret = new ArrayList<>(n);
        int low, high = 0;
        while (high < n) {
            low = high;
            while (high + 1 < n && nums[high] + 1 == nums[high + 1]) {
                high++;
            }
            // 不使用 StringBuilder 的性能差别有点大
            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low != high) {
                sb.append("->").append(nums[high]);
            }
            ret.add(sb.toString());
            high++;
        }
        return ret;
    }

}

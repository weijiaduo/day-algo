package com.wjd.practice.leetcode.array.combination;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * <p>
 * 满足 i != j、i != k 且 j !=k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * <p>
 * 请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -10⁵ <= nums[i] <= 10⁵
 *
 * @author weijiaduo
 * @since 2021-06-30
 */
public class ThreeSum {

    /**
     * 思路：三数之和 nums[i] + nums[j] + nums[k] = 0，等价于 nums[j] + nums[k] = -nums[i]
     * <p>
     * 先定好 nums[i]，然后去数组中找出两数之和 nums[j] + nums[k]
     * <p>
     * 并且假设 nums[i] <= nums[j] <= nums[k]，
     * <p>
     * 因为它们3个数加起来等于 0，那么必定有 nums[i] <= 0 且 nums[k] >= 0
     * <p>
     * 复杂度：时间 O(nlogn + n^2) 空间 O(1)
     * <p>
     * 执行耗时:29ms,击败了87.44% 的Java用户
     * 内存消耗:48.11MB,击败了52.58% 的Java用户
     *
     * @param nums 数组
     * @return 所有三元组
     */
    @TestCase(input = {"[-1,0,1,2,-1,-4]", "[0,1,1]", "[0,0,0]"},
            output = {"[[-1,-1,2],[-1,0,1]]", "[]", "[0,0,0]"})
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return ans;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return ans;
        }
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            // 去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            ans.addAll(twoSum(nums, -nums[i], i + 1, n - 1));
        }
        return ans;
    }

    /**
     * 求2数之和
     *
     * @param nums  升序数组
     * @param sum   两数和
     * @param start 起始地址
     * @param end   结束地址
     * @return 两数，或null
     */
    private List<List<Integer>> twoSum(int[] nums, int sum, int start, int end) {
        List<List<Integer>> ans = new ArrayList<>();
        int lp = start, rp = end;
        while (lp < rp) {
            int temp = nums[lp] + nums[rp];
            if (temp == sum) {
                ans.add(Arrays.asList(-sum, nums[lp], nums[rp]));
                // 去重
                do {
                    lp++;
                } while (lp < rp && nums[lp] == nums[lp - 1]);
                do {
                    rp--;
                } while (lp < rp && nums[rp] == nums[rp + 1]);
            } else if (temp < sum) {
                lp++;
            } else {
                rp--;
            }
        }
        return ans;
    }

}

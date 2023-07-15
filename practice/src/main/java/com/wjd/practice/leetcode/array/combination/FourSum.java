package com.wjd.practice.leetcode.array.combination;

import com.wjd.practice.leetcode.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * <p>
 * 请你找出并返回满足下述全部条件且不重复的四元组
 * <p>
 * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 *
 * @author weijiaduo
 * @since 2021-07-01
 */
public class FourSum {

    /**
     * 思路：排序 + 回溯 + 双指针
     * <p>
     * 排序后，外面 2 层循环，里面 1 层双指针遍历
     * <p>
     * 复杂度：时间 O(n^3) 空间 O(logn)
     * <p>
     * 执行耗时:15 ms,击败了61.48% 的Java用户
     * 内存消耗:43.2 MB,击败了9.69% 的Java用户
     */
    @TestCase(input = {"[1,0,-1,0,-2,2]", "0", "[2,2,2,2,2]", "8", "[1000000000,1000000000,1000000000,1000000000]", "-294967296", "[1,-2,-5,-4,-3,3,3,5]", "-11"},
            output = {"[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]", "[[2,2,2,2]]", "[]", "[[-5,-4,-3,1]]"})
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        List<Integer> values = new ArrayList<>(4);
        for (int i = 0; i < nums.length - 3; i++) {
            // 升序剪枝
            if (nums[i] >= 0 && nums[i] > target) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            values.add(nums[i]);
            ans.addAll(threeSum(nums, (long) target - nums[i], i + 1, nums.length - 1, values));
            values.remove(values.size() - 1);
        }
        return ans;
    }

    /**
     * 回溯，3 数之和
     *
     * @param nums   升序数组
     * @param target 三数和
     * @param start  [start, end]
     * @param end    [start, end]
     * @param values 值集合
     */
    private List<List<Integer>> threeSum(int[] nums, long target, int start, int end, List<Integer> values) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start; i < end - 1; i++) {
            // 升序剪枝
            if (nums[i] >= 0 && nums[i] > target) {
                break;
            }
            // 去重
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            values.add(nums[i]);
            ans.addAll(twoSum(nums, target - nums[i], i + 1, end, values));
            values.remove(values.size() - 1);
        }
        return ans;
    }

    /**
     * 双指针，2 数之和
     *
     * @param nums   升序数组
     * @param target 两数和
     * @param start  [start, end]
     * @param end    [start, end]
     * @param values 值集合
     * @return 两数，或null
     */
    private List<List<Integer>> twoSum(int[] nums, long target, int start, int end, List<Integer> values) {
        List<List<Integer>> ans = new ArrayList<>();
        int lp = start, rp = end;
        int size = values.size() + 2;
        while (lp < rp) {
            long temp = (long) nums[lp] + nums[rp];
            if (temp == target) {
                List<Integer> list = new ArrayList<>(size);
                list.addAll(values);
                list.add(nums[lp]);
                list.add(nums[rp]);
                ans.add(list);

                // 去重
                while (lp < rp && nums[lp] == nums[++lp]) ;
                while (lp < rp && nums[rp] == nums[--rp]) ;
            } else if (temp < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return ans;
    }

}

package com.wjd.practice.leetcode.array.transform;

import com.wjd.practice.leetcode.TestCase;

/**
 * 26. 删除有序数组中的重复项
 * <p>
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 元素的 相对顺序 应该保持一致 。然后返回 nums 中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
 * <p>
 * nums 的其余元素与 nums 的大小不重要。
 * <p>
 * 返回 k 。
 * <p>
 * 判题标准:
 * <p>
 * 系统会用下面的代码来测试你的题解:
 * <p>
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * <p>
 * int k = removeDuplicates(nums); // 调用
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * <p>
 * 如果所有断言都通过，那么您的题解将被 通过。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 已按 非严格递增 排列
 *
 * @author weijiaduo
 * @since 2023/10/22
 */
public class RemoveDuplicates1 {

    /**
     * 思路：双指针，一个遍历，一个执行非重复数组末尾
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.7 MB,击败了71.07% 的Java用户
     */
    @TestCase(input = {"[1,1,2]", "[0,0,1,1,1,2,2,3,3,4]"},
            output = {"2", "5"})
    public int doublePoint(int[] nums) {
        int n = nums.length;
        int lp = 0, rp = 1;
        while (rp < n) {
            if (nums[rp] != nums[lp]) {
                if (lp + 1 < rp) {
                    nums[lp + 1] = nums[rp];
                }
                lp++;
            }
            rp++;
        }
        return lp + 1;
    }

    /**
     * 思路：双指针，一个遍历，一个执行非重复数组末尾
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.98MB,击败了14.62% 的Java用户
     */
    @TestCase(input = {"[1,1,2]", "[0,0,1,1,1,2,2,3,3,4]"},
            output = {"2", "5"})
    public int doublePoint2(int[] nums) {
        int p = 0, k = 1;
        for (int num : nums) {
            if (p < k || nums[p - k] != num) {
                nums[p++] = num;
            }
        }
        return p;
    }

}

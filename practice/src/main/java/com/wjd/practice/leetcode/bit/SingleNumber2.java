package com.wjd.practice.leetcode.bit;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 137. 只出现一次的数字
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * <p>
 * 请你找出并返回那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 * @author weijiaduo
 * @since 2022/6/25
 */
public class SingleNumber2 {

    /**
     * 思路：使用哈希表来保存每个数的出现次数
     * <p>
     * 复杂度：时间 O(n), 空间 O(n)
     * <p>
     * 执行耗时:5 ms,击败了34.10% 的Java用户
     * 内存消耗:41.2 MB,击败了13.87% 的Java用户
     */
    @TestCase(input = {"[2,2,3,2]", "[0,1,0,1,0,1,99]"},
            output = {"3", "99"})
    public int map(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 只能说，官解牛皮
     * <p>
     * 官解：统计整数的32位bit的值，重复3次数字的bit加起来的3取余应该是3/0，只出现1次的数字bit加起来的3取余应该是1/0
     * <p>
     * 复杂度：时间 O(n)，空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了90.30% 的Java用户
     * 内存消耗:41.4 MB,击败了5.06% 的Java用户
     */
    @TestCase(input = {"[2,2,3,2]", "[0,1,0,1,0,1,99]"},
            output = {"3", "99"})
    public int bitCount(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            // 统计bit=1出现的次数
            for (int num : nums) {
                total += (num >> i) & 0x01;
            }
            // bit=1的次数对3取余为1，说明是只出现1次的数字的bit
            if (total % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 这完全想不到啊
     * <p>
     * 官解：运用数字电路的逻辑进行计算
     * <p>
     * 复杂度：时间 O(n)， 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了90.30% 的Java用户
     * 内存消耗:41.2 MB,击败了10.92% 的Java用户
     */
    @TestCase(input = {"[2,2,3,2]", "[0,1,0,1,0,1,99]"},
            output = {"3", "99"})
    public int logistic(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num);
            int bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }

    /**
     * 官解：运用数字电路的逻辑进行计算
     * <p>
     * 复杂度：时间 O(n)， 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了6.28% 的Java用户
     */
    @TestCase(input = {"[2,2,3,2]", "[0,1,0,1,0,1,99]"},
            output = {"3", "99"})
    public int logistic2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

}

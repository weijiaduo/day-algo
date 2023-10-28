package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 * <p>
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * <p>
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。
 * <p>
 * 注意，允许有多个孩子同时拥有 最多的糖果数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candies = [2,3,5,1,3], extraCandies = 3
 * 输出：[true,true,true,false,true]
 * 解释：
 * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
 * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
 * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
 * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * <p>
 * 示例 2：
 * <p>
 * 输入：candies = [4,2,1,1,2], extraCandies = 1
 * 输出：[true,false,false,false,false]
 * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 * <p>
 * 示例 3：
 * <p>
 * 输入：candies = [12,1,12], extraCandies = 10
 * 输出：[true,false,true]
 * <p>
 * 提示：
 * <p>
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 *
 * @author weijiaduo
 * @since 2023/10/3
 */
public class KidsWithCandies {

    /**
     * 思路：先找出最大值，然后遍历数组，判断当前糖果+额外糖果能否达到最大值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100% 的Java用户
     * 内存消耗:39.4 MB,击败了48.73% 的Java用户
     */
    @TestCase(input = {"[2,3,5,1,3]", "3", "[4,2,1,1,2]", "1", "[12,1,12]", "10"},
            output = {"[true,true,true,false,true]", "[true,false,false,false,false]", "[true,false,true]"})
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0], n = candies.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int x : candies) {
            max = Math.max(x, max);
        }
        for (int x : candies) {
            ans.add(x + extraCandies >= max);
        }
        return ans;
    }

}

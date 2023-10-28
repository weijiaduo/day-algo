package com.wjd.practice.leetcode.array.prefix;

import com.wjd.practice.TestCase;

/**
 * 1732. 找到最高海拔
 * <p>
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。
 * <p>
 * 自行车手从海拔为 0 的点 0 开始骑行。
 * <p>
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
 * <p>
 * 请你返回 最高点的海拔 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 * <p>
 * 提示：
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 *
 * @author weijiaduo
 * @since 2023/10/7
 */
public class LargestAltitude {

    /**
     * 思路：前缀和，前缀和就是高度，只要统计最大前缀和即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.8 MB,击败了91.11% 的Java用户
     */
    @TestCase(input = {"[-5,1,5,0,-7]", "[-4,-3,-2,-1,4,3,2]"},
            output = {"1", "0"})
    public int prefix(int[] gain) {
        int ans = 0, sum = 0;
        for (int g : gain) {
            sum += g;
            ans = Math.max(sum, ans);
        }
        return ans;
    }

}

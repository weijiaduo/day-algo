package com.wjd.practice.leetcode.trie;

import com.wjd.structure.tree.trie.BitTrie;

/**
 * 421. 数组种两个数的最大异或值
 * <p>
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10⁵
 * 0 <= nums[i] <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public class FindMaximumXOR {

    /**
     * 思路：先用数字的二进制串构成字典树，然后对字典树进行异或匹配。
     * <p>
     * 得到最大异或值得匹配规则如下：
     * <p>
     * 1. 匹配碰到 1 时，尽量往 0 分支走；
     * <p>
     * 2. 匹配碰到 0 时，尽量往 1 分支走。
     * <p>
     * 复杂度：时间 O(nlogc) 空间 O(nlogc)
     * <p>
     * 执行耗时:835 ms,击败了10.62% 的Java用户
     * 内存消耗:165.5 MB,击败了31.28% 的Java用户
     *
     * @param nums 数组
     * @return 最大异或值
     */
    public int findMaximumXOR(int[] nums) {
        BitTrie trie = new BitTrie();
        int maxXOR = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            trie.insert(nums[i - 1]);
            maxXOR = Math.max(maxXOR, trie.maxXOR(nums[i]));
        }
        return maxXOR;
    }

}

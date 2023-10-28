package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 771. 宝石与石头
 * <p>
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * <p>
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 *
 * @author weijiaduo
 * @since 2023/7/24
 */
public class NumJewelsInStones {

    /**
     * 思路：哈希记录哪些是宝石，然后遍历石头统计宝石数量即可
     * <p>
     * 复杂度：时间 O(m + n) 空间 O(R)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了61.41% 的Java用户
     */
    @TestCase(input = {"aA", "aAAbbbb", "z", "ZZ"},
            output = {"3", "0"})
    public int hash(String jewels, String stones) {
        int ans = 0;
        boolean[] mark = new boolean[128];
        Arrays.fill(mark, false);
        for (int i = jewels.length() - 1; i >= 0; i--) {
            mark[jewels.charAt(i)] = true;
        }
        for (int i = stones.length() - 1; i >= 0; i--) {
            char ch = stones.charAt(i);
            if (mark[ch]) {
                ans++;
            }
        }
        return ans;
    }

}

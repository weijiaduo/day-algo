package com.wjd.practice.leetcode.hash;

import com.wjd.practice.leetcode.TestCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 1207. 独一无二的出现次数
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author weijiaduo
 * @since 2023/10/7
 */
public class UniqueOccurrences {

    /**
     * 思路：哈希，使用哈希记录数字的频率，最后将频率都放到哈希中，
     * <p>
     * 如果不同数字的数量和不同频率的数量一致，则返回 true，否则 false
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了85.56% 的Java用户
     * 内存消耗:39.4 MB,击败了73.43% 的Java用户
     */
    @TestCase(input = {"[1,2,2,1,1,3]", "[1,2]", "[-3,0,1,-3,1,1,1,-3,10,0]"},
            output = {"true", "false", "true"})
    public boolean hash(int[] arr) {
        Map<Integer, Integer> feq = new HashMap<>();
        for (int num : arr) {
            int cnt = feq.getOrDefault(num, 0);
            feq.put(num, cnt + 1);
        }
        HashSet<Integer> valueSet = new HashSet<>(feq.values());
        return feq.keySet().size() == valueSet.size();
    }

}

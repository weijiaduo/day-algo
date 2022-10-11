package com.wjd.practice.leetcode.array;

import com.wjd.structure.binaryindextree.BinaryIndexTree;

import java.util.*;

/**
 * 315. 计算右侧小于当前元素的个数
 * <p>
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
 * <p>
 * 数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 * @author weijiaduo
 * @since 2022/10/11
 */
public class CountSmaller {

    Map<Integer, Integer> indexMap;

    /**
     * 思路：树状数组记录每个数字的出现次数，从右往左遍历，从树状数组内拿出小于当前值的区间内的数字数量
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:78 ms,击败了36.38% 的Java用户
     * 内存消耗:59.4 MB,击败了61.60% 的Java用户
     */
    public List<Integer> solve(int[] nums) {
        discretization(nums);
        BinaryIndexTree bit = new BinaryIndexTree(indexMap.size() + 1);

        int n = nums.length;
        List<Integer> ans = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {
            // 偏移修正为非负数
            int idx = getIdx(nums[i]);
            // 查询小于当前值的数字数量
            ans.add(bit.query(0, idx - 1));
            // 计数加1
            bit.update(idx, 1);
        }
        Collections.reverse(ans);
        return ans;
    }

    /**
     * 离散化，聚合数字
     */
    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = set.size();
        Integer[] indexArr = set.toArray(new Integer[0]);
        Arrays.sort(indexArr);
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(indexArr[i], i);
        }
    }

    /**
     * 查找指定数字的索引
     */
    private int getIdx(int num) {
        return indexMap.get(num) + 1;
    }

}

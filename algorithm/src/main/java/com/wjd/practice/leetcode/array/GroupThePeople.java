package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 * <p>
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 * <p>
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。
 * <p>
 * 例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 * <p>
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 * <p>
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。
 * <p>
 * 如果有多个答案，返回其中 任何 一个。
 * <p>
 * 可以 保证 给定输入 至少有一个 有效的解。
 * <p>
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 *
 * @author weijiaduo
 * @since 2022/8/12
 */
public class GroupThePeople implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object... args) {
        int[] groupSize = {2, 1, 3, 3, 3, 2};
        List<List<Integer>> result = groupThePeople(groupSize);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：先遍历收集每个分组的用户，最后再根据分组长度把用户集合切分
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:6 ms,击败了68.90% 的Java用户
     * 内存消耗:42 MB,击败了66.77% 的Java用户
     *
     * @param groupSizes 分组数组
     * @return 用户分组集合
     */
    private List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            list.add(i);
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> list = map.get(i);
            if (list == null) {
                continue;
            }
            // 按照分组长度拆分用户
            for (int j = 0; j < list.size(); j += i) {
                ans.add(list.subList(j, j + i));
            }
        }
        return ans;
    }

}

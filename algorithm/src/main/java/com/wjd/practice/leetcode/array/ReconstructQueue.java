package com.wjd.practice.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * <p>
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * <p>
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * <p>
 * 返回的队列应该格式化为数组 queue ，
 * <p>
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 *
 * @author weijiaduo
 * @since 2022/10/21
 */
public class ReconstructQueue {

    public int[][] solve(int[][] people) {
        return high2low(people);
    }

    /**
     * 思路：身高h降序，数量k升序，按照k逐个插入列表
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:5 ms,击败了99.69% 的Java用户
     * 内存消耗:42.6 MB,击败了14.62% 的Java用户
     */
    private int[][] high2low(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        List<int[]> list = new ArrayList<>(people.length);
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[0][]);
    }
}

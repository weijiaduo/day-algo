package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @since 2021-06-09
 * <p>
 * 830. 较大分组的位置
 * <p>
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 */
public class LargeGroupPositions implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object args) {
        String s = "abcdddeeeeaabbbcdddd";
        List<List<Integer>> result = largeGroupPositions(s);
        System.out.println(result);
        return result;
    }

    /**
     * 较大分组的位置
     *
     * @param s 字符串
     * @return 集合
     */
    private List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int p = 0, q = 1;
        int length = s.length(), len = 3;
        while (q <= length) {
            if (q == length || s.charAt(q) != s.charAt(p)) {
                if (q - p >= len) {
                    result.add(Arrays.asList(p, q - 1));
                }
                p = q;
            }
            q++;
        }
        return result;
    }
}

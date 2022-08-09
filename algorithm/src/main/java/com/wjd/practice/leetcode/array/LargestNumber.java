package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 179. 最大数
 * <p>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * @author weijiaduo
 * @since 2022/7/7
 */
public class LargestNumber implements Solution<String> {

    @Override
    public String solve(Object... args) {
        int[] nums = {3, 30, 34, 5, 9};
        String result = largestNumber(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 比我预料的要慢很多啊
     * <p>
     * 思路：对数字进行排序，不是按照数值排序，而是他们从前往后的数字大小排序，大的在前，最后拼成字符串即可
     * <p>
     * 复杂度：时间 O(nlogn) 空间O(n)
     * <p>
     * 执行耗时:9 ms,击败了10.84% 的Java用户
     * 内存消耗:41.3 MB,击败了25.60% 的Java用户
     */
    private String largestNumber(int[] nums) {
        // 1、转成字符串
        // 2、对字符串进行排序，按拼接字符串结果，从大到小排序
        // 3、连接所有字符串
        StringBuilder sb = Arrays.stream(nums)
                .mapToObj(value -> "" + value)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        // 去掉字符串前面的0
        int i = 0;
        for (; i < sb.length() - 1; i++) {
            if (sb.charAt(i) != '0') {
                break;
            }
        }
        return sb.substring(i);
    }

}

package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 10.05. 稀疏数组搜索
 * <p>
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
 * s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
 * s = "ball"
 * 输出：4
 * <p>
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 *
 * @author weijiaduo
 * @since 2024/1/5
 */
public class FindString {

    /**
     * 思路：直接遍历搜索
     * <p>
     * 复杂度：时间 O(nm) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了34.80% 的Java用户
     * 内存消耗:43.1 MB,击败了12.22% 的Java用户
     */
    @TestCase(input = {"[\"at\", \"\", \"\", \"\", \"ball\", \"\", \"\", \"car\", \"\", \"\",\"dad\", \"\", \"\"]", "ta",
            "[\"at\", \"\", \"\", \"\", \"ball\", \"\", \"\", \"car\", \"\", \"\",\"dad\", \"\", \"\"]", "ball"},
            output = {"-1", "4"})
    public int brute(String[] words, String s) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (s.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 思路：将字符串及其索引放入哈希表，根据哈希表获取结果
     * <p>
     * 复杂度：时间 O(nm) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了6.58% 的Java用户
     * 内存消耗:43.3 MB,击败了6.58% 的Java用户
     */
    @TestCase(input = {"[\"at\", \"\", \"\", \"\", \"ball\", \"\", \"\", \"car\", \"\", \"\",\"dad\", \"\", \"\"]", "ta",
            "[\"at\", \"\", \"\", \"\", \"ball\", \"\", \"\", \"car\", \"\", \"\",\"dad\", \"\", \"\"]", "ball"},
            output = {"-1", "4"})
    public int hash(String[] words, String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = n - 1; i >= 0; i--) {
            map.put(words[i], i);
        }
        return map.getOrDefault(s, -1);
    }

    /**
     * 思路：先将数组排序，再利用二分法寻找
     * <p>
     * 复杂度：时间 O(nm + nlogn) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43 MB,击败了13.79% 的Java用户
     */
    @TestCase(input = {"[\"at\", \"\", \"\", \"\", \"ball\", \"\", \"\", \"car\", \"\", \"\",\"dad\", \"\", \"\"]", "ta",
            "[\"at\", \"\", \"\", \"\", \"ball\", \"\", \"\", \"car\", \"\", \"\",\"dad\", \"\", \"\"]", "ball"},
            output = {"-1", "4"})
    public int binary(String[] words, String s) {
        int l = 0, r = words.length - 1;
        while (l <= r) {
            // 向前寻找最靠近的字符串
            int m = l + (r - l) / 2;
            while (m > l && words[m].isEmpty()) {
                m--;
            }

            int c = words[m].compareTo(s);
            if (c == 0) {
                // 避免 r 一直不变导致死循环
                if (m == l) {
                    return m;
                }
                r = m;
            } else if (c < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}

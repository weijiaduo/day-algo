package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 50.2 字符流中第一个只出现一次的字符
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * <p>
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * <p>
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class FirstCharacterInStream {

    /**
     * 字符集大小
     */
    final int R = 256;
    /**
     * 记录字符的出现次数
     */
    final int[] counts;
    /**
     * 字符流的长度
     */
    int size = 0;

    /**
     * 思路：哈希表
     * <p>
     * 用哈希表记录每个字符出现的次数
     * <p>
     * 当字符流插入一个字符时，如果字符第一次出现，那么记录字符出现的位置
     * <p>
     * 如果字符不是第一次出现，那么将字符出现的位置设置为 -1
     * <p>
     * 时间复杂度：插入 O(1) 查找 O(1)
     * <p>
     * 空间复杂度：O(1)
     */
    public FirstCharacterInStream() {
        counts = new int[R];
        Arrays.fill(counts, -1);
    }

    public void insert(char ch) {
        if (counts[ch] == -1) {
            // 第一次出现
            counts[ch] = size;
        } else if (counts[ch] >= 0) {
            // 多次出现
            counts[ch] = -2;
        }
        size++;
    }

    public char find() {
        int p = R;
        for (int i = 0; i < R; i++) {
            if (counts[i] >= 0 && counts[i] < p) {
                p = i;
            }
        }
        return p < R ? (char) p : '#';
    }

    @TestCase(input = {"google"}, output = {"[g,g,g,#,l,l]"})
    public List<Character> test(String s) {
        List<Character> ans = new ArrayList<>();
        FirstCharacterInStream firstAppear = new FirstCharacterInStream();
        for (int i = 0; i < s.length(); i++) {
            firstAppear.insert(s.charAt(i));
            ans.add(firstAppear.find());
        }
        return ans;
    }

}

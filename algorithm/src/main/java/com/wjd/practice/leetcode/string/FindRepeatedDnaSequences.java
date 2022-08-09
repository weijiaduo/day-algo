package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * <p>
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如， "ACGAATTCCG" 是一个 DNA序列 。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * @author weijiaduo
 * @since 2022/7/7
 */
public class FindRepeatedDnaSequences implements Solution<List<String>> {

    @Override
    public List<String> solve(Object... args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences3(s);
        System.out.println(result);
        return result;
    }

    final int size = 10;

    /**
     * 猜到了，这种方式应该不是很快
     * <p>
     * 思路：滑动窗口，使用哈希表记录每个窗口字符串的数量，大于1则是重复序列
     * <p>
     * 复杂度：时间 O(Cn) 空间 O(n)
     * <p>
     * 执行耗时:21 ms,击败了58.06% 的Java用户
     * 内存消耗:49.9 MB,击败了34.14% 的Java用户
     */
    private List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - size; i++) {
            String ss = s.substring(i, i + size);
            int count = counts.getOrDefault(ss, 0) + 1;
            if (count > 2) {
                continue;
            }
            counts.put(ss, count);
            if (count == 2) {
                ans.add(ss);
            }
        }
        return ans;
    }

    /**
     * 嗯，更慢了，我以为会快一些的
     * <p>
     * 思路：4个字母，10个位置，刚好用40bits表示它们
     * <p>
     * 执行耗时:34 ms,击败了5.19% 的Java用户
     * 内存消耗:49.8 MB,击败了45.09% 的Java用户
     */
    private List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= size) {
            return ans;
        }

        // 构建10个字符的滑动窗口
        Map<Long, Integer> counts = new HashMap<>();
        long indexes = 0;
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            indexes = bitCount(ch, 1, i, indexes);
        }
        counts.put(indexes, 1);

        // 滑动窗口移动
        for (int i = size; i < n; i++) {
            char ch = s.charAt(i);
            // 滑动窗口去掉最低位字符
            indexes = bitCount(s.charAt(i - size), -1, 0, indexes);
            // 滑动窗口加上最高位字符
            indexes = bitCount(ch, 1, 9, indexes);

            int count = counts.getOrDefault(indexes, 0) + 1;
            if (count > 2) {
                continue;
            }
            counts.put(indexes, count);
            if (count == 2) {
                ans.add(s.substring(i - 9, i + 1));
            }
        }
        return ans;
    }

    private long bitCount(char ch, int operand, int index, long indexes) {
        long mask = 0;
        switch (ch) {
            case 'A':
                // (40,30]表示A出现的位置
                mask = 1L << (30 + index);
                break;
            case 'C':
                // (30,20]表示C出现的位置
                mask = 1L << (20 + index);
                break;
            case 'G':
                // (20,10]表示G出现的位置
                mask = 1L << (size + index);
                break;
            case 'T':
                // (10,0]表示T出现的位置
                mask = 1L << index;
                break;
            default:
                break;
        }
        if (operand > 0) {
            // 增加高位字符
            indexes |= mask;
        } else {
            // 移除低位字符
            indexes &= ~mask;
            // 移除低位字符后，剩下的索引都需要减1
            indexes >>= 1;
        }
        return indexes;
    }

    Map<Character, Integer> bitMap = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    /**
     * 耗时比我想象的多啊
     * <p>
     * 官解：每个字符用2个bit表示，10个字符就是20个bit
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:23 ms,击败了35.70% 的Java用户
     * 内存消耗:45.6 MB,击败了95.60% 的Java用户
     */
    private List<String> findRepeatedDnaSequences3(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= size) {
            return ans;
        }

        // 构建10个字符的滑动窗口
        Map<Integer, Integer> counts = new HashMap<>();
        int indexes = 0;
        for (int i = 0; i < size; i++) {
            indexes = (indexes << 2) | bitMap.get(s.charAt(i));
        }
        counts.put(indexes, 1);

        for (int i = size; i < n; i++) {
            // 去掉最低位字符，加上最高位字符
            indexes = (indexes << 2) | bitMap.get(s.charAt(i));
            // 只取低20位
            indexes &= (1 << 20) - 1;

            int count = counts.getOrDefault(indexes, 0) + 1;
            if (count > 2) {
                continue;
            }
            counts.put(indexes, count);
            if (count == 2) {
                ans.add(s.substring(i - 9, i + 1));
            }
        }

        return ans;
    }

}

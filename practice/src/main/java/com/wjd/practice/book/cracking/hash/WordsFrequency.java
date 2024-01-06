package com.wjd.practice.book.cracking.hash;

import com.wjd.practice.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 * <p>
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * <p>
 * 示例：
 * <p>
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an","apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 * <p>
 * 提示：
 * <p>
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 *
 * @author weijiaduo
 * @since 2024/1/6
 */
public class WordsFrequency {

    Map<String, Integer> freq;

    public WordsFrequency() {
        this(new String[0]);
    }

    /**
     * 思路：哈希记录频率
     * <p>
     * 执行耗时:157 ms,击败了24.21% 的Java用户
     * 内存消耗:91.8 MB,击败了13.69% 的Java用户
     */
    public WordsFrequency(String[] book) {
        freq = new HashMap<>();
        for (String word : book) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return freq.getOrDefault(word, 0);
    }

    @TestCase(input = "1")
    public void test(int unused) {
        String[] book = new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency = new WordsFrequency(book);
        System.out.println(wordsFrequency.get("you")); // 返回0，"you"没有出现过
        System.out.println(wordsFrequency.get("have")); // 返回2，"have"出现2次
        System.out.println(wordsFrequency.get("an")); // 返回1
        System.out.println(wordsFrequency.get("apple")); // 返回1
        System.out.println(wordsFrequency.get("pen")); // 返回1
    }

}

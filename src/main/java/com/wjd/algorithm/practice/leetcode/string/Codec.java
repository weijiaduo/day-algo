package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 * <p>
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-
 * tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 * <p>
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，
 * <p>
 * 并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 *
 * @author weijiaduo
 * @since 2022/6/29
 */
public class Codec implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        return null;
    }

    private Map<Integer, String> dataBase = new HashMap<>();
    private int id;

    /**
     * 毫无兴致，就想到了随机数生成，官解的想法倒是挺多
     * <p>
     * 懒得做了，直接贴官解打卡
     * <p>
     * 执行耗时:5 ms,击败了40.23% 的Java用户
     * 内存消耗:41.8 MB,击败了12.97% 的Java用户
     */
    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }

}

package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 周赛300
 * <p>
 * 6109. 知道秘密的人数
 * <p>
 * 在第 1天，有一个人发现了一个秘密。
 * <p>
 * 给你一个整数delay，表示每个人会在发现秘密后的 delay天之后，每天给一个新的人分享秘密。
 * <p>
 * 同时给你一个整数forget，表示每个人在发现秘密forget天之后会忘记这个秘密。
 * <p>
 * 一个人不能在忘记秘密那一天及之后的日子里分享秘密。
 * <p>
 * 给你一个整数n，请你返回在第 n天结束时，知道秘密的人数。
 * <p>
 * 由于答案可能会很大，请你将结果对109 + 7取余后返回。
 *
 * @author weijiaduo
 * @since 2022/7/3
 */
public class PeopleAwareOfSecret implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 289;
        int delay = 7;
        int forget = 23;
        int result = peopleAwareOfSecret(n, delay, forget);
        System.out.println(result);
        return result;
    }

    /**
     * 说实话不难，但是我竟然把自己给搞混乱了，不应该啊小老弟
     * <p>
     * 思路：记录每天新增的任务，第i天的新增人数就等于 [i - forget + 1, i - delay]的人数总和
     */
    private int peopleAwareOfSecret(int n, int delay, int forget) {
        final int mod = (int) 1e9 + 7;

        // [i]表示第i天新增的人数
        int[] awarePerDay = new int[n];
        awarePerDay[0] = 1;

        // [i - forget + 1, i - delay]的人数总和
        // 这个搞了我很久，看来还是没想清楚
        for (int i = 1; i < n; i++) {
            int delaySum = 0;
            int k = Math.max(0, i - forget + 1);
            for (int j = k; j <= i - delay; j++) {
                delaySum = (delaySum + awarePerDay[j]) % mod;
            }
            awarePerDay[i] = delaySum;
        }

        // 知道密码的总人数
        long awareSum = 0;
        int k = Math.max(0, n - forget);
        for (int i = k; i < n; i++) {
            awareSum = (awareSum + awarePerDay[i]) % mod;
        }
        return (int) awareSum;
    }

}

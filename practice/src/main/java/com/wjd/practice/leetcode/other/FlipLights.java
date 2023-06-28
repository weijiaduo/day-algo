package com.wjd.practice.leetcode.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 672. 灯泡开关2
 * <p>
 * 房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 * <p>
 * 这 4 个开关各自都具有不同的功能，其中：
 * <p>
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * <p>
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 * <p>
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 * <p>
 * 输入：n = 1, presses = 1
 * 输出：2
 * 解释：状态可以是：
 * - 按压开关 1 ，[关]
 * - 按压开关 2 ，[开]
 *
 * @author weijiaduo
 * @since 2022/9/15
 */
public class FlipLights {

    public int flipLights(int n, int presses) {
        char[] lights = new char[n + 1];
        Arrays.fill(lights, '1');
        Set<String> visited = new HashSet<>();
        Set<String> ans = new HashSet<>();
        backtrack(lights, presses, visited, ans);
        System.out.println(ans);
        return ans.size();
    }

    /**
     * 思路：回溯，灯泡状态记录成字符串，使用哈希集合记录去重
     * <p>
     * 复杂度：时间 O(n * 4^p) 空间 O(n^p)
     * <p>
     * 执行耗时:556 ms,击败了5.11% 的Java用户
     * 内存消耗:55.9 MB,击败了5.11% 的Java用户
     *
     * @param lights 灯泡状态
     * @param k      倒数第几轮
     * @param ans    去重集合
     */
    private void backtrack(char[] lights, int k, Set<String> visited, Set<String> ans) {
        String key = new String(lights) + k;
        if (visited.contains(key)) {
            return;
        }
        if (k == 0) {
            ans.add(key);
            return;
        }

        // 标记为已访问
        visited.add(key);

        // 开关1，反转所有状态
        int n = lights.length;
        for (int i = 1; i < n; i++) {
            lights[i] = lights[i] == '0' ? '1' : '0';
        }
        backtrack(lights, k - 1, visited, ans);
        for (int i = 1; i < n; i++) {
            lights[i] = lights[i] == '0' ? '1' : '0';
        }

        // 开关2，反转偶数状态
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                lights[i] = lights[i] == '0' ? '1' : '0';
            }
        }
        backtrack(lights, k - 1, visited, ans);
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                lights[i] = lights[i] == '0' ? '1' : '0';
            }
        }

        // 开关3，反转奇数状态
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                lights[i] = lights[i] == '0' ? '1' : '0';
            }
        }
        backtrack(lights, k - 1, visited, ans);
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                lights[i] = lights[i] == '0' ? '1' : '0';
            }
        }

        // 开关4，反转编号 3k+1 的状态
        for (int i = 0; 3 * i + 1 < n; i++) {
            int j = 3 * i + 1;
            lights[j] = lights[j] == '0' ? '1' : '0';
        }
        backtrack(lights, k - 1, visited, ans);
        for (int i = 0; 3 * i + 1 < n; i++) {
            int j = 3 * i + 1;
            lights[j] = lights[j] == '0' ? '1' : '0';
        }
    }

    /**
     * 大家真的太厉害了，我都没想到找规律
     * <p>
     * 思路：
     * <p>
     * n盏灯泡，实际上是6盏一组的循环，所以只需判断前6盏灯泡状态即可。
     * <p>
     * 但还可以更进一步，前6盏灯泡中，根据前3盏灯泡能推断出后3盏灯泡的状态，所以最终只用判断前3盏灯就够了
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了32.85% 的Java用户
     *
     * @param n       n 盏灯
     * @param presses 次数
     * @return 不同可能状态
     */
    private int flipLights2(int n, int presses) {
        // 不按开关
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            // 1盏灯只有2种状态
            return 2;
        } else if (n == 2) {
            // 2盏灯最多组合出4种状态，但是只按1次的话，只能出现3种状态
            return presses == 1 ? 3 : 4;
        } else {
            // 3盏灯最多组合出8种状态，但是只按一次的话，只能出现7种状态
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

}

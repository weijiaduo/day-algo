package com.wjd.practice.leetcode.array.simulate;

/**
 * 周赛 301
 * <p>
 * 6112. 装满杯子需要的最短总时长
 * <p>
 * 现有一台饮水机，可以制备冷水、温水和热水。
 * <p>
 * 每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
 * <p>
 * 给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。
 * <p>
 * 返回装满所有杯子所需的 最少 秒数。
 *
 * @author weijiaduo
 * @since 2022/7/10
 */
public class FillCups {

    /**
     * 思路：直接模拟，每次选最大的2个值减一
     */
    public int fillCups(int[] amount) {
        int ans = 0;
        int n = amount.length;
        while (true) {
            int max1 = -1, max2 = -1;
            for (int i = 0; i < n; i++) {
                if (max1 == -1 || amount[i] > amount[max1]) {
                    max2 = max1;
                    max1 = i;
                } else if (max2 == -1 || amount[i] > amount[max2]) {
                    max2 = i;
                }
            }
            if (amount[max1] == 0) {
                break;
            }
            amount[max1]--;
            if (max1 != max2) {
                amount[max2]--;
            }
            ans++;
        }
        return ans;
    }

    /**
     * 思路：分为2种情况，每次都减2；先减2再减1
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了29.82%的用户
     */
    private int fillCups2(int[] amount) {
        // 开头部分每次减2，后面部分减1，总次数就是最大值
        int num1 = Math.max(amount[0], Math.max(amount[1], amount[2]));
        // 开头到结尾，每次减2，不过最后1次可能是减1，总次数就是总数/2向上取整
        int num2 = (amount[0] + amount[1] + amount[2] + 1) / 2;
        return Math.max(num1, num2);
    }

}

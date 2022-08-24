package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 497. 非重叠矩形中的随机点
 *
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左
 * 下角点，(xi, yi) 是第 i 个矩形的右上角角点。
 *
 * 设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。
 *
 * 所有满足要求的点必须等概率被返回。
 *
 * @since 2022/6/9
 */
public class RandomRect implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        return null;
    }

    Random rand;
    List<Integer> arr;
    int[][] rects;

    /**
     * 不会，先打个卡吧
     *
     * 执行耗时:50 ms,击败了67.48% 的Java用户
     * 内存消耗:47.7 MB,击败了12.14% 的Java用户
     */
    public RandomRect(int[][] rects) {
        rand = new Random();
        arr = new ArrayList<>();
        arr.add(0);
        this.rects = rects;
        for (int[] rect : rects) {
            int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
            arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
        }
    }

    public int[] pick() {
        int k = rand.nextInt(arr.get(arr.size() - 1));
        int rectIndex = binarySearch(arr, k + 1) - 1;
        k -= arr.get(rectIndex);
        int[] rect = rects[rectIndex];
        int a = rect[0], b = rect[1], y = rect[3];
        int col = y - b + 1;
        int da = k / col;
        int db = k - col * da;
        return new int[]{a + da, b + db};
    }

    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = arr.get(mid);
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}

package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * LCR 159. 库存管理 III
 * <p>
 * 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。
 * <p>
 * 请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stock = [2,5,7,4], cnt = 1
 * 输出：[2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：stock = [0,2,3,6], cnt = 2
 * 输出：[0,2] 或 [2,0]
 * <p>
 * 提示：
 * <p>
 * 0 <= cnt <= stock.length <= 10000 0 <= stock[i] <= 10000
 *
 * @author weijiaduo
 * @since 2024/2/2
 */
public class InventoryManagement {

    /**
     * 思路：大顶堆，维护 cnt 个最小元素
     * <p>
     * 复杂度：时间 O(nlogk) 空间 O(k)
     * <p>
     * 执行耗时:18 ms,击败了15.69% 的Java用户
     * 内存消耗:44.7 MB,击败了31.78% 的Java用户
     */
    @TestCase(input = {"[2,5,7,4]", "1", "[0,2,3,6]", "2"},
            output = {"[2]", "[2,0]"})
    public int[] heap(int[] stock, int cnt) {
        int[] ans = new int[cnt];
        if (cnt == 0) {
            return ans;
        }

        // 1. 维护 cnt 个元素的大顶堆
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : stock) {
            if (maxHeap.size() < cnt) {
                maxHeap.add(num);
                continue;
            }
            if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(num);
            }
        }

        // 2. 获取堆中的元素
        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }
        return ans;
    }

    /**
     * 思路：快速选择分区
     * <p>
     * 按照快排的思想，将数据分成两部分
     * <p>
     * 只要找到分区到第 cnt 个位置，那么前面部分就是最小值了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:44.9 MB,击败了14.30% 的Java用户
     */
    @TestCase(input = {"[2,5,7,4]", "1", "[0,2,3,6]", "2"},
            output = {"[2]", "[2,0]"})
    public int[] quickSelect(int[] stock, int cnt) {
        int[] ans = new int[cnt];
        if (cnt == 0) {
            return ans;
        }

        quickSelect(stock, 0, stock.length - 1, cnt);
        System.arraycopy(stock, 0, ans, 0, cnt);
        return ans;
    }

    private void quickSelect(int[] stock, int low, int high, int cnt) {
        if (low <= high) {
            int m = partition(stock, low, high);
            if (m == cnt - 1) {
                return;
            }
            if (m < cnt - 1) {
                quickSelect(stock, m + 1, high, cnt);
            } else {
                quickSelect(stock, low, m - 1, cnt);
            }
        }
    }

    private int partition(int[] arr, int low, int high) {
        int cmp = arr[high];
        int left = low, right = high;
        while (left < right) {
            while (left < right && arr[left] <= cmp) {
                left++;
            }
            while (left < right && arr[right] >= cmp) {
                right--;
            }
            swap(arr, left, right);
        }
        swap(arr, left, high);
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.*;

/**
 * 220. 存在重复元素3
 * <p>
 * 给你一个整数数组 nums 和两个整数 k 和 t 。
 * <p>
 * 请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 * @author weijiaduo
 * @since 2022/9/3
 */
public class ContainsNearbyAlmostDuplicate implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        boolean result = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(result);
        return result;
    }

    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 方法1
        // return bf(nums, k, t);
        // 方法2
        // return sortSet(nums, k, t);
        // 方法3
        // return sortSet2(nums, k, t);
        // 方法4
        return bucket(nums, k, t);
    }

    /**
     * 思路：按照步长，暴力遍历所有步长判断
     * <p>
     * 复杂度：时间 O(kn) 空间 O(1)
     * <p>
     * 执行耗时:1912 ms,击败了7.01% 的Java用户
     * 内存消耗:41.8 MB,击败了99.04% 的Java用户
     */
    private boolean bf(int[] nums, int k, int t) {
        int n = nums.length;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j + i < n; j++) {
                long a = nums[j];
                long b = nums[j + i];
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 思路：维护一个最多k+1个元素的有序集合，增加新元素时，先删除最前面的元素，再二分查找新元素位置插入
     * <p>
     * 复杂度：时间 (nk + nlogk) 空间 O(k)
     * <p>
     * 执行耗时:572 ms,击败了24.51% 的Java用户
     * 内存消耗:43.1 MB,击败了49.49% 的Java用户
     */
    private boolean sortSet(int[] nums, int k, int t) {
        List<Integer> list = new ArrayList<>(k);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // 维护滑动窗口大小，移除最前面的元素
            if (list.size() > k) {
                list.remove((Integer) nums[i - k - 1]);
            }

            // 找到合适的位置插入，保持有序性
            int index = findNotLessThan(list, num);
            list.add(index, num);

            // 验证插入位置两边的值是否满足条件
            long a = num;
            if (index > 0) {
                long b = list.get(index - 1);
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
            if (index < n - 1) {
                long b = list.get(index + 1);
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 找到一个大于等于指定值val的位置
     *
     * @param list 列表
     * @param val  指定值
     * @return 一个大于等于x的索引
     */
    private int findNotLessThan(List<Integer> list, int val) {
        int n = list.size();
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int m = list.get(mid);
            if (m >= val) {
                if (mid == 0 || list.get(mid - 1) <= val) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 思路：维护一个k个元素的有序集合
     * <p>
     * abs(num[i] - nums[j]) <= t 等价于 nums[i] - t <= nums[j] <= nums[i] + t
     * <p>
     * 找到有序集合里面是否存在 nums[i] - t <= x，再判断是否 x <= nums[i] + t
     * <p>
     * 如果都满足，说明 nums[j] = x 时，就是符合题目要求的返回结果
     * <p>
     * 复杂度：时间 (nlogk) 空间 O(k)
     * <p>
     * 执行耗时:34 ms,击败了78.62% 的Java用户
     * 内存消耗:43.3 MB,击败了40.73% 的Java用户
     */
    private boolean sortSet2(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 找到大于等于 nums[i] - t 的值 x
            Long x = set.ceiling(((long) num - (long) t));
            // 判断x是否存在，且满足 x <= nums[i] + t
            if (x != null && x <= ((long) num + (long) t)) {
                return true;
            }

            // 添加元素到有序集合
            set.add((long) num);

            // 维护有序集合大小，移除最前面的元素
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 思路：桶排序，每个桶大小为 t + 1，判断同一个桶和相邻桶的绝对值是否满足条件
     * <p>
     * 复杂度：时间 O(n) 空间 O(k)
     * <p>
     * 执行耗时:19 ms,击败了98.01% 的Java用户
     * 内存消耗:44.3 MB,击败了12.55% 的Java用户
     */
    private boolean bucket(int[] nums, int k, int t) {
        int n = nums.length;
        int w = t + 1;
        // 以整数 Integer 的值范围作为桶索引
        Map<Integer, Long> bucketMap = new HashMap<>(k);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int index = bucketIndex(num, w);
            // 当前桶已有值，满足要求
            if (bucketMap.containsKey(index)) {
                return true;
            }
            // 判断左边桶和当前桶的差值
            Long prev = bucketMap.get(index - 1);
            if (prev != null && ((long) num - prev) < w) {
                return true;
            }
            // 判断右边桶和当前桶的差值
            Long next = bucketMap.get(index + 1);
            if (next != null && (next - (long) num) < w) {
                return true;
            }
            // 添加元素到桶内
            bucketMap.put(index, (long) num);
            // 维护滑动窗口大小，移除最前面的元素
            if (i >= k) {
                bucketMap.remove(bucketIndex(nums[i - k], w));
            }
        }
        return false;
    }

    /**
     * 计算某个值的所属桶
     *
     * @param val 指定值
     * @param w   通大小
     * @return 桶索引
     */
    private int bucketIndex(int val, int w) {
        if (val >= 0) {
            return val / w;
        }
        return (val + 1) / w - 1;
    }

}

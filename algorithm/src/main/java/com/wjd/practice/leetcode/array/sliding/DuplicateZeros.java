package com.wjd.practice.leetcode.array.sliding;

/**
 * 1089. 复写零
 * <p>
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 *
 * @since 2022/6/17
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        // offsetDuplicateZeros(arr);
        bitDuplicateZeros(arr);
    }

    /**
     * 思路：遍历一遍数组，找到偏移后的最后一个数字，再从后往前遍历偏移，遇零则重复
     * <p>
     * 注意：需要注意的是最后一个0的问题，有可能最后一个0没办法重复
     * <p>
     * 执行耗时:1 ms,击败了80.21% 的Java用户
     * 内存消耗:41.8 MB,击败了26.79% 的Java用户
     */
    public void offsetDuplicateZeros(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 计算最后一个位置的偏移量
        int k = 0, offset = 0, n = arr.length;
        for (; k < n; k++) {
            if (arr[k] == 0) {
                offset++;
            }
            if (k + offset >= n - 1) {
                break;
            }
        }

        // 从后往前遍历偏移
        for (int i = n - 1; k >= 0; k--, i--) {
            arr[i] = arr[k];
            if (arr[k] == 0 && k + offset <= n - 1) {
                // 最后一个零可能没位置重复了
                arr[--i] = arr[k];
            }
        }
    }

    /**
     * 思路：数值范围是0~9，只用了低4位0~3，采用位操作把偏移值写到高4位4~7，边遍历边更新即可
     * <p>
     * 这个位操作很有意思，评论区果然多大佬
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了59.72% 的Java用户
     */
    public void bitDuplicateZeros(int[] arr) {
        int i = 0, j = 0, n = arr.length;
        while (j < n) {
            // 低4位是旧值
            int val = arr[i] & 0xf;
            // 高4位是新值
            arr[j] = arr[j] | (val << 4);
            j++;
            if (val == 0) {
                j++; // 0再怎么移位还是0
            }

            // 更新新值
            arr[i] >>= 4;
            i++;
        }
        while (i < n) {
            // 更新新值
            arr[i] >>= 4;
            i++;
        }
    }

}

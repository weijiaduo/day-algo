package com.wjd.practice.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.19. 水域大小
 * <p>
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * <p>
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。
 * <p>
 * 池塘的大小是指相连接的水域的个数。
 * <p>
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * <p>
 * 输出： [1,2,4]
 * <p>
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * @author weijiaduo
 * @since 2023/6/22
 */
public class PondSizes {

    final int[][] offset = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    /**
     * 思路：深度优先遍历，找到所有为 0 的位置，然后遍历即可
     * <p>
     * 复杂度：时间 O(mn) 空间 O(mn)
     * <p>
     * 执行耗时:8 ms,击败了94.69% 的Java用户
     * 内存消耗:70.2 MB,击败了64.81% 的Java用户
     */
    public int[] pondSizes(int[][] land) {
        List<Integer> sizes = new ArrayList<>();
        int num = 1;
        int m = land.length, n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    sizes.add(dfs(land, i, j, num++));
                }
            }
        }

        // 流式操作有点慢啊
        // 执行耗时:18 ms,击败了18.16% 的Java用户
        // 内存消耗:70.2 MB,击败了67.60% 的Java用户
        // return sizes.stream().sorted().mapToInt(i -> i).toArray();

        int[] ans = new int[sizes.size()];
        int k = 0;
        for (int s : sizes) {
            ans[k++] = s;
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 标记相邻位置为指定的编号 num
     *
     * @return 返回相关节点的数量
     */
    private int dfs(int[][] land, int i, int j, int num) {
        int m = land.length, n = land[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (land[i][j] != 0) {
            return 0;
        }
        int size = 1;
        land[i][j] = num;
        for (int[] f : offset) {
            size += dfs(land, i + f[0], j + f[1], num);
        }
        return size;
    }

}

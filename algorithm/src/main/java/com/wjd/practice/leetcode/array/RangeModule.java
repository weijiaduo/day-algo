package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;
import com.wjd.structure.segmenttree.MinLinkSegmentTree;

/**
 * 715. Range 模块
 * <p>
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 * <p>
 * 半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。
 * <p>
 * 实现 RangeModule 类:
 * <p>
 * RangeModule() 初始化数据结构的对象。
 * <p>
 * void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。
 * <p>
 * 添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
 * <p>
 * boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
 * <p>
 * void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
 * <p>
 * 输入
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * 输出
 * [null, null, null, true, false, true]
 *
 * @author weijiaduo
 * @since 2022/6/20
 */
public class RangeModule implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        RangeModule rangeModule = new RangeModule();
        System.out.println(rangeModule.queryRange(21, 34));
        System.out.println(rangeModule.queryRange(27, 87));
        rangeModule.addRange(44, 53);
        rangeModule.addRange(69, 89);
        System.out.println(rangeModule.queryRange(23, 26));
        System.out.println(rangeModule.queryRange(80, 84));
        System.out.println(rangeModule.queryRange(11, 12));
        rangeModule.removeRange(86, 91);
        rangeModule.addRange(87, 94);
        rangeModule.removeRange(34, 52);
        rangeModule.addRange(1, 59);
        rangeModule.removeRange(62, 96);
        rangeModule.removeRange(34, 83);
        System.out.println(rangeModule.queryRange(11, 59));
        System.out.println(rangeModule.queryRange(59, 79));
        System.out.println(rangeModule.queryRange(1, 13));
        System.out.println(rangeModule.queryRange(21, 23));
        rangeModule.removeRange(9, 61);
        rangeModule.addRange(17, 21);
        rangeModule.removeRange(4, 8);
        System.out.println(rangeModule.queryRange(19, 25));
        return null;
    }

    final int low = 1;
    final int high = (int) 1e9;
    MinLinkSegmentTree segmentTree;

    /**
     * 思路：区间和线段树，区间节点保存 0/1，0表示未跟踪，1表示已跟踪
     * <p>
     * 执行耗时:176 ms,击败了5.00% 的Java用户
     * 内存消耗:67.7 MB,击败了27.77% 的Java用户
     */
    public RangeModule() {
        segmentTree = new MinLinkSegmentTree(low, high);
    }

    public void addRange(int left, int right) {
        segmentTree.update(left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        int ret = segmentTree.query(left, right - 1);
        return ret > 0;
    }

    public void removeRange(int left, int right) {
        segmentTree.update(left, right - 1, -1);
    }

}


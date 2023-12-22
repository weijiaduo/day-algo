package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 * <p>
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * <p>
 * 给定一个由不同节点组成的二叉搜索树 root，输出所有可能生成此树的数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: [[2,1,3],[2,3,1]]
 * 解释: 数组 [2,1,3]、[2,3,1] 均可以通过从左向右遍历元素插入树中形成以下二叉搜索树
 * //      2
 * //     / \
 * //    1   3
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [4,1,null,null,3,2]
 * 输出: [[4,1,3,2]]
 * <p>
 * 提示：
 * <p>
 * 二叉搜索树中的节点数在
 * [0, 1000] 的范围内
 * 1 <= 节点值 <= 10^6
 * 用例保证符合要求的数组数量不超过 5000
 *
 * @author weijiaduo
 * @since 2023/12/22
 */
public class BSTSequences {

    /**
     * 思路：排列问题
     * <p>
     * 肯定是先插入父节点，然后再插入子节点
     * <p>
     * 但是左右子树是互不干涉的，也就是说，左右子树的顺序可以随意交叉
     * <p>
     * 比如左子树的顺序有 [[1,2],[2,1]]，右子树的顺序有 [[3,4],[4,3]]
     * <p>
     * 那么左右子树交叉后的结果有：
     * <p>
     * [[1,2,3,4],[1,3,2,4],[1,3,4,2],[3,1,2,4],[3,1,4,2],[3,4,1,2]]
     * <p>
     * 复杂度：时间 O(2^n) 空间 O(n)
     * <p>
     * 执行耗时:19 ms,击败了6.06% 的Java用户
     * 内存消耗:44.6 MB,击败了9.09% 的Java用户
     */
    @TestCase(input = {"[2,1,3]", "[4,1,null,null,3,2]"},
            output = {"[[2,1,3],[2,3,1]]", "[[4,1,3,2]]"})
    public List<List<Integer>> sequence(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        if (root == null) {
            ans.add(prefix);
            return ans;
        }

        // 父节点在前
        prefix.add(root.val);

        // 左右子序列
        List<List<Integer>> left = sequence(root.left);
        List<List<Integer>> right = sequence(root.right);

        // 左右子序列交叉
        for (List<Integer> l1 : left) {
            for (List<Integer> l2 : right) {
                insect(l1, 0, l2, 0, prefix, ans);
            }
        }
        return ans;
    }

    /**
     * 两个列表序列交叉
     *
     * @param l1  列表1
     * @param i   下标
     * @param l2  列表2
     * @param j   下标
     * @param l   列表
     * @param ans 结果集
     */
    private void insect(List<Integer> l1, int i, List<Integer> l2, int j, List<Integer> l, List<List<Integer>> ans) {
        if (i >= l1.size() && j >= l2.size()) {
            ans.add(new ArrayList<>(l));
            return;
        }
        if (i < l1.size()) {
            l.add(l1.get(i));
            insect(l1, i + 1, l2, j, l, ans);
            l.remove(l.size() - 1);
        }
        if (j < l2.size()) {
            l.add(l2.get(j));
            insect(l1, i, l2, j + 1, l, ans);
            l.remove(l.size() - 1);
        }
    }

}

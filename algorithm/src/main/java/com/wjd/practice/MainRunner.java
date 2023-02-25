package com.wjd.practice;

import com.wjd.practice.stack.ComputeExpression;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainRunner {

    public static void main(String[] args) {
        // 1161. 最大层内元素和
        // run(MaxLevelSum.class);
        // 1403. 非递增顺序的最小子序列
        // run(MinSubsequence.class);
        // 623. 在二叉树中增加一行
        // run(AddOneRow.class);
        // 1408. 数组中的字符串匹配
        // run(StringMatching.class);
        // 1413. 逐步求和得到正数的最小值
        // run(MinStartValue.class);
        // 640. 求解方程
        // run(SolveEquation.class);
        // 1417. 重新格式化字符串
        // run(Reformat.class);
        // 1282. 用户分组
        // run(GroupThePeople.class);
        // 1422. 分割字符串的最大得分
        // run(MaxScore.class);
        // 1302. 层数最深叶子节点的和
        // run(DeepestLeavesSum.class);
        // 1224. 最大相等频率
        // run(MaxEqualFreq.class);
        // 1450. 在既定时间做作业的学生人数
        // run(BusyStudent.class);
        // 654. 最大二叉树
        // run(ConstructMaximumBinaryTree.class);
        // 1455. 检查单词是否为句中其他单词的前缀
        // run(PrefixOfWord.class);
        // run(PalindromeList.class);
        // run(FindMiddle.class);
        // 655. 输出二叉树
        // run(PrintTree.class);
        // 1460. 通过翻转子数组使两个数组相等
        // run(RotateBeEqual.class);
        // 20. 有效的括号
        // run(ValidParenthesis.class);
        // 计算表达式结果
        run(ComputeExpression.class);
    }

    /**
     * 反射运行指定的类
     *
     * @param cls  类的Class对象
     * @param args 参数
     */
    private static void run(Class<? extends Solution<?>> cls, Object... args) {
        try {
            Constructor<?> constructor = cls.getConstructor();
            Object instance = constructor.newInstance();
            Method solveMethod = instance.getClass().getDeclaredMethod("solve", Object[].class);
            solveMethod.invoke(instance, new Object[]{args});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

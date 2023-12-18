package com.wjd.practice.book.cracking.queue;

import java.util.*;

/**
 * 面试题 03.06. 动物收容所
 * <p>
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * <p>
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * <p>
 * 换言之，收养人不能自由挑选想收养的对象。
 * <p>
 * 请创建适用于这个系统的数据结构，实现各种操作方法，比如 enqueue、dequeueAny、dequeueDog和dequeueCat。
 * <p>
 * 允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog",
 * "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * <p>
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat",
 * "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * <p>
 * 说明:
 * <p>
 * 收纳所的最大容量为20000
 *
 * @author weijiaduo
 * @since 2023/12/18
 */
public class AnimalShelf {

    /**
     * 队列节点
     */
    static class Node {
        static int ids = 0;
        int id;
        int[] data;

        public Node(int[] data) {
            this.id = ids++;
            this.data = data;
        }
    }

    /**
     * 动物种类
     */
    static final int N = 2;
    /**
     * 分类队列集合
     */
    List<Queue<Node>> queues;

    /**
     * 思路：分类队列集合
     * <p>
     * 入队时，看动物类别，放入不同的队列中
     * <p>
     * 出队时，根据动物类别选择具体的队列
     * <p>
     * 执行耗时:68 ms,击败了48.87% 的Java用户
     * 内存消耗:54.2 MB,击败了6.39% 的Java用户
     */
    public AnimalShelf() {
        queues = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            queues.add(new ArrayDeque<>());
        }
    }

    public void enqueue(int[] animal) {
        int type = animal[1];
        queues.get(type).add(new Node(animal));
    }

    public int[] dequeueAny() {
        Queue<Node> q = null;
        for (Queue<Node> t : queues) {
            if (t.isEmpty()) {
                continue;
            }
            if (q == null || t.peek().id < q.peek().id) {
                q = t;
            }
        }
        if (q == null) {
            return new int[]{-1, -1};
        } else {
            return q.poll().data;
        }
    }

    public int[] dequeueDog() {
        return dequeue(1);
    }

    public int[] dequeueCat() {
        return dequeue(0);
    }

    private int[] dequeue(int type) {
        Queue<Node> q = queues.get(type);
        if (q.isEmpty()) {
            return new int[]{-1, -1};
        }
        return q.poll().data;
    }

    public static void main(String[] args) {
        AnimalShelf shelf = new AnimalShelf();
        shelf.enqueue(new int[]{0, 0});
        shelf.enqueue(new int[]{1, 0});
        shelf.enqueue(new int[]{2, 1});
        System.out.println(Arrays.toString(shelf.dequeueDog())); // {2,1}
        System.out.println(Arrays.toString(shelf.dequeueCat())); // {0,0}
        System.out.println(Arrays.toString(shelf.dequeueAny())); // {1,0}
    }

}

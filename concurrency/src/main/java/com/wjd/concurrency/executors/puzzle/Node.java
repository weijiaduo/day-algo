package com.wjd.concurrency.executors.puzzle;

import java.util.LinkedList;
import java.util.List;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 谜题节点
 * @since 2022/5/11
 */
public class Node<P, M> {

    final P pos;
    final M move;
    final Node<P, M> prev;

    public Node(P pos, M move, Node<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    List<M> asMoveList() {
      List<M> solution = new LinkedList<>();
      for (Node<P, M> n = this; n.move != null; n = n.prev) {
          solution.add(0, n.move);
      }
      return solution;
    }

}

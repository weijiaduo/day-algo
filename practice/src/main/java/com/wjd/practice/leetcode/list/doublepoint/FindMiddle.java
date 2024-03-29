package com.wjd.practice.leetcode.list.doublepoint;

import com.wjd.practice.leetcode.structure.Node;

/**
 * 查找链表的中点
 * <p>
 * 奇数节点时，中间的节点就是中点。
 * <p>
 * 偶数节点时，中间的节点有2个，仅返回左边节点即可
 *
 * @author weijiaduo
 * @since 2022/8/21
 */
public class FindMiddle {

    /**
     * 思路：快慢指针，慢指针最终指向的就是中点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param head 表头
     * @return 中点
     */
    public Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}

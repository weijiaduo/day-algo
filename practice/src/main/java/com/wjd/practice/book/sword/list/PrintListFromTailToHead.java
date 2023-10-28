package com.wjd.practice.book.sword.list;

import com.wjd.structure.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class PrintListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        ListNode p = listNode;
        while (p != null) {
            res.add(p.val);
            p = p.next;
        }

        if (res.size() > 0) {
            Collections.reverse(res);
        }

        return res;
    }
}

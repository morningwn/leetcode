package com.github.morningwn.t0001_t0500.t0301_t0400.t0321_t0330;

import com.github.morningwn.prefab.ListNode;

/**
 * 奇偶链表
 *
 * @author morningwn
 * @date 2020/11/13 8:42
 */
public class T0328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddNode = new ListNode();
        ListNode eventNode = new ListNode();
        ListNode res = head;
        ListNode oddHead = oddNode;
        ListNode eventHeaed = eventNode;
        int index = 1;

        while (res != null) {
            if (index++ % 2 == 0) {
                eventNode.next = res;
                eventNode = eventNode.next;
            } else {
                oddNode.next = res;
                oddNode = oddNode.next;
            }
            res = res.next;
        }

        eventNode.next = null;
        oddNode.next = eventHeaed.next;
        return oddHead.next;
    }
}

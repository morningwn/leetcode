package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.ListNode;

/**
 * @author morningwn
 * @description: 反转链表
 * @date Created in 2020/7/6 15:08
 * @version: 1.0
 */
public class T0023 {

    public ListNode reverseList(ListNode head) {
        ListNode per = null, cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = per;
            per = cur;
            cur = nex;
        }

        return per;
    }
}

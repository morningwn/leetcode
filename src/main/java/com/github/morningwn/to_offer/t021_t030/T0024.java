package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.ListNode;

/**
 * @author morningwn
 * @description: 合并两个排序的链表
 * @date Created in 2020/7/6 15:10
 * @version: 1.0
 */
public class T0024 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;

        while (l1 != null || l2 != null) {
//            Out.println( node.val );
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                node.next = l1;
                break;
            } else {
                node.next = l2;
                break;
            }
            node = node.next;
        }
        return head.next;

    }
}

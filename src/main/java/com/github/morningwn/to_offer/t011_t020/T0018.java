package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.ListNode;

/**
 * @author morningwn
 * @description: 删除链表的节点
 * @date Created in 2020/7/4 15:57
 * @version: 1.0
 */
public class T0018 {

    public T0018() {

    }

    /**
     * @author morningwn
     * @date 2020/7/4 16:02
     * @description: 直接循环找到要删除的节点，删除就行了
     * @param: head 头结点
     * @param: val 要删除节点的值
     * @return: prefab.ListNode 删除后链表的头结点
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        ListNode preNode = null;
        if (head != null && head.val == val) {
            return head.next;
        }

        while (node != null) {
            if (node.val == val) {
                preNode.next = node.next;
                return head;
            } else {
                preNode = node;
                node = node.next;
            }
        }

        return null;
    }
}

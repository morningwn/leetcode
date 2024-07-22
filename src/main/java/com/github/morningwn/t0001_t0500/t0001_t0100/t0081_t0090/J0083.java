package com.github.morningwn.t0001_t0500.t0001_t0100.t0081_t0090;

import com.github.morningwn.prefab.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
 *
 * @author morningwn
 * @date Created in 2024/7/22 19:12
 */
public class J0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head.next;
        ListNode preNode = head;
        while (node != null) {
            if (node.val == preNode.val) {
                preNode.next = node.next;
            } else {
                preNode = node;
            }
            node = node.next;
        }
        return head;
    }
}
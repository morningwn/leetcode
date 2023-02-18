package com.github.morningwn.t1501_t2000.t1601_t1700.t1661_t1670;

import com.github.morningwn.prefab.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-in-between-linked-lists/">1669. 合并两个链表</a>
 *
 * @author morningwn
 * @create in 2023/1/30 23:51
 */
public class T1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode tmp = null;
        for (int i = 0; i < a - 1; i++) {
            list1 = list1.next;
        }
        tmp = list1.next;
        list1.next = list2;
        list1 = tmp;
        while (list2.next != null) {
            list2 = list2.next;
        }
        for (int i = 0; i < b - a - 1; i++) {
            list1 = list1.next;
        }
        list2.next = list1.next;

        return head;
    }
}

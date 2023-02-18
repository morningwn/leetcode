package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0021 {

    @Test
    public void test() {

        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};

        ListNode l1 = new ListNode(nums1[0]);
        ListNode node = l1;
        for (int i = 1; i < nums1.length; i++) {
            node.next = new ListNode(nums1[i]);
            node = node.next;
        }

        ListNode l2 = new ListNode(nums2[0]);
        node = l2;
        for (int i = 1; i < nums2.length; i++) {
            node.next = new ListNode(nums2[i]);
            node = node.next;
        }

        ListNode head = mergeTwoLists(l1, l2);

        while (head != null) {
            Out.println(head.val);
            head = head.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);        //头结点
        ListNode node = head;                      //用于迭代的节点

        //只要有剩余的节点就继续进行循环
        while (l1 != null || l2 != null) {

            //如果两个节点均不为空，将较小的节点进行保存，较大的不管
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
                //仅l1不为空，将l1保存后退出
            } else if (l1 != null && l2 == null) {
                node.next = l1;
                break;
                //仅l2不为空，将l2保存后退出
            } else {
                node.next = l2;
                break;
            }

            node = node.next;
        }
        //头结点的下一个节点才是有效值
        return head.next;
    }
}


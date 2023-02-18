package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0019 {

    @Test
    public void test() {

        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {1};

        ListNode head = new ListNode(nums[0]);
        ListNode node = head;

        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        node = removeNthFromEnd(head, 5);

        while (node != null) {
            Out.println(node.val);
            node = node.next;
        }

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        //对一个不删除，输入为空，只输入一个节点的情况进行处理
        if (n == 0 || head == null) {
            return head;
        } else if (head.next == null) {
            return null;
        }

        ListNode node = head;           //用于迭代
        ListNode bfRemove = head;       //存储当前迭代的节点的前n个节点

        int count = 0;                  //当前是第几个节点了
        while (node != null) {
            count++;

            //在当前节点有前n个节点之时对bfRemove进行迭代
            if (count > n + 1) {
                bfRemove = bfRemove.next;
            }
            node = node.next;

        }
//        Out.println( bfRemove.val  + "\t" + count);

        //对删除的节点是头结点这种特殊情况的处理
        if (count == n) {
            bfRemove.val = bfRemove.next.val;
        }

        bfRemove.next = bfRemove.next.next;

        return head;
    }
}
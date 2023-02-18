package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import com.github.morningwn.prefab.ListNode;


public class T0237 {

    public void test() {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}



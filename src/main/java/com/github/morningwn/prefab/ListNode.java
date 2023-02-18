package com.github.morningwn.prefab;

/**
 * @author morningwn
 * @description: Definition for singly-linked list.
 * @date Created in 2020/7/1 16:40
 * @version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

package com.github.morningwn.t0001_t0500.t0401_t0500.t0421_t0430;

import com.github.morningwn.prefab.Node;

/**
 * <a href="https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/">430. 扁平化多级双向链表</a>
 *
 * @author moringwn
 * @date 2021/9/24 上午9:22
 */
public class T0430 {

    public Node flatten(Node head) {
        Node node = head;

        while (node != null) {
            Node next = node.next;

            if (node.child != null) {
                node.next = flatten(node.child);
                node.child = null;
                node.next.prev = node;

                while (node.next != null) {
                    node = node.next;
                }
                node.next = next;

                if (next != null) {
                    next.prev = node;
                }
            }

            node = node.next;
        }

        return head;
    }
}

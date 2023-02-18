package com.github.morningwn.t0001_t0500.t0001_t0100.t0001_t0010;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">2. 两数相加</a>
 *
 * @author morningwn
 * @date
 */
public class T0002 {

    @Test
    public void test() {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);

        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(7);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        ListNode o = addTwoNumbers(a, d);

        while (o != null) {
            Out.print(o.val);
            o = o.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode before = first;

        int up = 0;

        while (l1 != null || l2 != null || up != 0) {
            if (l1 != null && l2 != null) {
                before.next = new ListNode((l1.val + l2.val + up) % 10);
                up = (l1.val + l2.val + up) / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null) {
                before.next = new ListNode((l2.val + up) % 10);
                up = (l2.val + up) / 10;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                before.next = new ListNode((l1.val + up) % 10);
                up = (l1.val + up) / 10;
                l1 = l1.next;
            } else if (l1 == null && l2 == null && up != 0) {
                before.next = new ListNode(up);
                up = 0;
            }

            before = before.next;

        }

        return first.next;

    }
}


package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0234 {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(1);

        Out.println(isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {

        ListNode pre = head;
        ListNode cur = head;
        ListNode rev = null;

        boolean flag = false;

        while (cur != null) {

            if (flag) {
                flag = false;
                cur = cur.next;
                ListNode tmp = pre;
                pre = pre.next;

                tmp.next = rev;
                rev = tmp;

            } else {
                flag = true;
                cur = cur.next;
            }
        }
        if (flag) {
            pre = pre.next;
        }

        Out.println(cur);
        Out.println(pre);
        Out.println(rev);

        while (pre != null && rev != null) {

            if (pre.val != rev.val) {
                return false;
            } else {
                pre = pre.next;
                rev = rev.next;
            }
        }

        return pre == null && rev == null;
    }
}

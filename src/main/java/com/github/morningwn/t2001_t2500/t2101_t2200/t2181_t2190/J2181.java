package com.github.morningwn.t2001_t2500.t2101_t2200.t2181_t2190;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/merge-nodes-in-between-zeros">2181. 合并零之间的节点</a>
 *
 * @author morningwn
 * @date 2024-09-09 19:52:59
 */
public class J2181 {

    @Test
    public void test() {
        ListNode header = FormatInput.buildNodeList(0, 3, 1, 0, 4, 5, 2, 0);
        Out.println(header);
        Out.println(mergeNodes(header));
    }


    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int total = 0;
        for (ListNode cur = head.next; cur != null; cur = cur.next) {
            if (cur.val == 0) {
                ListNode node = new ListNode(total);
                tail.next = node;
                tail = tail.next;
                total = 0;
            } else {
                total += cur.val;
            }
        }

        return dummy.next;

    }
}
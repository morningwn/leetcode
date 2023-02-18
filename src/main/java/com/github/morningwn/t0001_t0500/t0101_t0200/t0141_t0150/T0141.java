package com.github.morningwn.t0001_t0500.t0101_t0200.t0141_t0150;

import com.github.morningwn.prefab.ListNode;

/**
 * 环形链表
 *
 * @author morningwn
 * @date 2020/10/9  9:02
 */
public class T0141 {

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


//    /**
//     * 简单的哈希表记忆
//     * @param head
//     * @return
//     */
//    public boolean hasCycle(ListNode head) {
//        List<ListNode> list = new ArrayList<>();
//        ListNode tmp = head;
//
//        while (tmp != null) {
//            if (list.contains(tmp)) {
//                return true;
//            }
//            list.add(tmp);
//            tmp = tmp.next;
//        }
//
//        return false;
//    }
}

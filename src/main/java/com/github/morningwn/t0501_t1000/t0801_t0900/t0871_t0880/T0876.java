package com.github.morningwn.t0501_t1000.t0801_t0900.t0871_t0880;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">876. 链表的中间结点</a>
 *
 * @author moringwn
 * @create in 2022/6/7 9:53
 */
public class T0876 {

    @Test
    public void test() {

        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        node = middleNode(null);
        while (node != null) {
            Out.println(node.val);
            node = node.next;
        }

    }

    public ListNode middleNode(ListNode head) {

        ListNode node = head;
        ListNode middle = head;

        boolean next = false;
        while (node != null) {
            if (next) {
                next = false;
                middle = middle.next;
                node = node.next;
            } else {
                next = true;
                node = node.next;
            }
        }

        return middle;
    }
}

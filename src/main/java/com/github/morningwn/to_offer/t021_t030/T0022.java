package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 链表中倒数第k个节点
 * @date Created in 2020/7/6 14:53
 * @version: 1.0
 */
public class T0022 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }

        Out.println(getKthFromEnd(head, 7).toString());
    }

    /**
     * @author morningwn
     * @date 2020/7/6 15:07
     * @description: 存储当前节点的前k个节点，找到结果后输出
     * @param: head 头结点
     * @param: k 输出倒数第几个节点
     * @return: prefab.ListNode 返回结果
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curNode = head;
        ListNode kNode = head;
        int count = 0;

        while (curNode != null) {
            if (count < k) {
                count++;
            } else {
                kNode = kNode.next;
            }
            curNode = curNode.next;
        }

        if (count < k) {
            return null;
        } else {
            return kNode;
        }
    }

}

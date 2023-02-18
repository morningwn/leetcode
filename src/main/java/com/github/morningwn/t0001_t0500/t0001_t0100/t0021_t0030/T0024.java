package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">24. 两两交换链表中的节点</a>
 *
 * @author morningwn
 * @date Created in 2020/4/27 20:53
 */
public class T0024 {

    @Test
    public void test() {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        Out.println(swapPairs(node).val);
    }

    /**
     * 将链表中的节点两两翻转
     *
     * @param head 链表的头节点
     * @return 翻转过的链表的头节点
     */
    public ListNode swapPairs(ListNode head) {

        //如果输入为空，之间返回null
        if (head == null) {
            return null;
        }

        //初始化一个根节点以及接下来用来循环的节点
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode listNode = root;

        //如过下一个节点不为空
        while (listNode.next != null) {

            //如果下下个节点不为空，也就是剩下的节点至少还有两个，可以进行翻转操作
            if (listNode.next.next != null) {

                //分别存储要翻转的两个节点
                ListNode node = listNode.next;
                ListNode nextNode = listNode.next.next;

                //将引用更改
                listNode.next = nextNode;
                node.next = nextNode.next;
                listNode.next.next = node;

                //因为是一次操作两个节点，所以直接进入下下个节点，进入下一次的循环
                listNode = listNode.next.next;
            } else {//剩余的节点只有一个，结束循环
                break;
            }
        }

        return root.next;
    }
}

package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">25. K 个一组翻转链表</a>
 *
 * @author morningwn
 * @date Created in 2020/4/28 7:54
 */
public class T0025 {

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        head = reverseKGroup(head, 2);
        while (head != null) {
            Out.println(head.val);
            head = head.next;
        }
    }

    /**
     * @param head 一个链表的头节点
     * @param k    几个节点为一组进行翻转
     * @return 翻转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        //初始化一个节点，以便进行翻转操作
        ListNode root = new ListNode(-1);

        //进入迭代的节点
        ListNode unRev = head;
        ListNode rev = root;

        int count = 0;

        while (unRev != null) {
            Out.println(unRev.val + "\t" + rev.val);
            if (count < k) {
                ListNode tmp = unRev.next;
                unRev.next = rev;
                rev = unRev;
                unRev = tmp;
                count++;
            } else {
                count = 0;
                for (int i = 0; i < k; i++) {
                    rev = rev.next;
                }
                rev.next = unRev;
                rev = rev.next;
                unRev = unRev.next;
            }
        }

        return rev;
    }

    /**
     * 先将k个节点获取，然后再进行翻转操作
     *
     * @param head 一个链表的头节点
     * @param k    几个节点为一组进行翻转
     * @return 翻转后的链表
     */
    public ListNode reverseKGroup1(ListNode head, int k) {

        //初始化一个节点，以便进行翻转操作
        ListNode root = new ListNode(0);
        root.next = head;

        //进入迭代的节点
        ListNode node = root;

        //初始化一个栈，用来存储接下来需要翻转的k个节点
        Stack<ListNode> stack = new Stack<>();

        //循环，每次翻转k个节点
        while (node.next != null) {
            //用于暂存循环的节点
            ListNode tmp = node;
            //将接下来的k个节点入栈，如果他们存在的话
            for (int i = 0; i < k && tmp.next != null; i++) {
                stack.push(tmp.next);
                tmp = tmp.next;
            }

            //获取下一个节点，在翻转后重新进行赋值，保证链表完整
            tmp = tmp.next;

            //如果当前栈中的元素够k个，进行翻转操作，否则结束循环
            if (stack.size() == k) {

                //暂存翻转部分的最后一个节点，用于赋值，进入下一轮的循环
                ListNode next = null;

                //将k个节点进行翻转
                for (int i = 0; i < k; i++) {
                    node.next = stack.pop();
                    node = node.next;
                    next = node;
                }

                //将翻转后的链表同后续的重新进行链接
                node.next = tmp;

                //将node的节点指向接下来需要翻转的k个节点的的前一个节点
                node = next;
            } else {//如果栈中不够k个节点，那么无需进行翻转，结束循环
                break;
            }
        }

        return root.next;
    }
}

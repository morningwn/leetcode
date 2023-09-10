package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;


import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">206. 反转链表</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0206 {

    @Test
    public void test() {

        int[] num = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(0);
        ListNode tmp = head;

        for (int i : num) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        head = reverseList(head);
        tmp = head;

        while (tmp != null) {
            Out.println(tmp.val);
            tmp = tmp.next;
        }

    }

    //递归法
    public ListNode reverseList1(ListNode head) {

        return reverse(null, head);
    }

    //参数per指向前一个节点，cur指向当前节点
    public ListNode reverse(ListNode per, ListNode cur) {

        //当当前节点为空时，代表循环已经到头了，返回前一个节点，结束循环
        if (cur == null) {
            return per;
        }

        //将当前节点的下一个节点存储起来
        ListNode tmp = cur.next;

        //更改当前节点的下一个节点为per所指向的节点
        cur.next = per;

        //返回下一次循环
        return reverse(cur, tmp);
    }

    //迭代法，优化
    public ListNode reverseList(ListNode head) {

        //per指向前一个节点，cur指向当前节点
        ListNode per = null, cur = head;

        //循环直到cur为空
        while (cur != null) {

            //存储当前节点的子节点
            ListNode nex = cur.next;

            //更改当前节点的子节点
            cur.next = per;

            //对per和cur重新进行赋值，进行下一次循环
            per = cur;
            cur = nex;
        }

        return per;
    }

    //迭代法
    public ListNode reverseList2(ListNode head) {

        if (head == null) {
            return null;
        }

        //用来存储当前链表的所有节点
        List<ListNode> list = new ArrayList<ListNode>();

        ListNode tmp = head;

        //将当前链表的所有节点存储在list中
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }

        //重新更改当前链表的顺序
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }

        //将原头结点的子节点更改奥null
        list.get(0).next = null;

        //返回原最后一个节点，现在的头结点
        return list.get(list.size() - 1);
    }

}

package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">23. 合并K个升序链表</a>
 *
 * @author morningwn
 * @date Created in 2020/4/26 0:08
 */
public class T0023 {

    /**
     * 两两合并，得到结果
     *
     * @param lists 含有n个链表的数组
     * @return 合并后的链表的头节点
     */
    public ListNode mergeKLists(ListNode[] lists) {

        //输入链表的个数
        int len = lists.length;

        //判断特殊情况
        if (len == 0) {
            return null;
        }

        //不断循环，直到剩余的链表个数为1
        while (len > 1) {

            //每次将第i个和第len-i-1个链表合并，头节点存储在第i个链表的位置
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoList(lists[i], lists[len - i - 1]);
            }

            //将链表个数减半，进行下一次合并
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    /**
     * 从小到大合并两个链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表的头节点
     */
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        //首先判断特殊输入
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //合并后链表的头节点，以及头节点的复制
        ListNode head = new ListNode(0);
        ListNode node = head;

        //循环，直到两个链表中至少有一个为空
        while (true) {

            //判断大小，然后合并链表
            if (list1.val > list2.val) {
                node.next = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                list1 = list1.next;
            }

            node = node.next;

            //判断是否达到结束循环的条件，即两个链表至少有一个为空
            //此时将另一个链表添加在合并后的链表里面，结束循环，合并结束
            if (list1 == null) {
                node.next = list2;
                break;
            }
            if (list2 == null) {
                node.next = list1;
                break;
            }
        }

        return head.next;
    }

    /**
     * 循环查找，将最小的合并
     *
     * @param lists 含有n个链表的数组
     * @return 合并后的链表的头节点
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        //头节点，头节点的复制品，用于判断是否结束循环的标记，以及最小值的索引
        ListNode head = new ListNode(0);
        ListNode node = head;
        boolean stop = false;
        int min = -1;

        //进行n*k次循环，k为链表的最长值
        while (!stop) {
            stop = true;

            //循环n次，查询最小的值
            for (int i = 0; i < lists.length; i++) {

                //如果当前节点已经是空的了，就跳过此次循环
                if (lists[i] == null) {
                    continue;
                }

                //如果最小值的索引为空，直接赋值
                //如果不为空就进行判断，取较小值的索引
                if (min == -1) {
                    min = i;
                } else if (lists[min].val > lists[i].val) {
                    min = i;
                }
            }

            //如果还有节点，就进行添加
            if (min != -1) {
                stop = false;
                node.next = lists[min];
                lists[min] = lists[min].next;
                node = node.next;
                min = -1;
            }
        }

        return head.next;
    }
}

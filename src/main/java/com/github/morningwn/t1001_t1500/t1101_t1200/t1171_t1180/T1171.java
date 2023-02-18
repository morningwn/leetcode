package com.github.morningwn.t1001_t1500.t1101_t1200.t1171_t1180;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">1171. 从链表中删去总和值为零的连续节点</a>
 *
 * @author morningwn
 * @date
 */
public class T1171 {

    @Test
    public void test() {

//        int[] nums = { 1,2,-3,3,1}; //[3,1]
//        int[] nums = { 1,2,3,-3,4}; //[1,2,4]
        int[] nums = {1, 2, 3, -3, -2}; //[1]


        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }

        node = removeZeroSumSublists(head);
        while (node != null) {
            Out.println(node.val);
            node = node.next;
        }

    }

    public ListNode removeZeroSumSublists(ListNode head) {

        List<Integer> list = new ArrayList<Integer>();        //用来存储输入的数
        ListNode node = head;        //头结点

        //将节点中的数存储在list中
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        boolean stop = false;        //用来判断啥时候结束循环
        //多次遍历，直到不再删除数字，代表结束
        while (!stop) {

            stop = true;
            for (int i = 0; i < list.size(); i++) {

                int count = 0;                //用来存储从第i个数到第j个数的和
                boolean next = false;         //用来判断，本次循环是否删除了数，如果删除了，就结束循环，进入下一次

                //遍历从i开始往后的所有数字，当他们的和为零时，将他们删除并结束循环
                for (int j = i; j < list.size(); j++) {

                    //求和
                    count += list.get(j);

                    //判断是否和为零
                    if (count == 0) {
                        //因为是从前往后删除的，所以在删除第i个数后，后面的数的索引减一，还是i
                        for (int k = i; k <= j; k++) {
                            list.remove(i);
                        }
                        stop = false;
                        next = true;
                        break;
                    }
                }

                //当在本次循环中删除了数的时候，结束此次循环
                if (next) {
                    break;
                }
            }
        }

        //当list为空时，返回null否则重新构建链表
        if (list.isEmpty()) {
            return null;
        } else {
            head = new ListNode(list.get(0));
            node = head;
            for (int i = 1; i < list.size(); i++) {
                node.next = new ListNode(list.get(i));
                node = node.next;
            }
        }

        return head;
    }

}

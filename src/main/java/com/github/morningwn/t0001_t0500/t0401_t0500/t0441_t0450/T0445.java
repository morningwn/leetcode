package com.github.morningwn.t0001_t0500.t0401_t0500.t0441_t0450;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">415. 字符串相加</a>
 *
 * @author moringwn
 * @date Created in 2020/4/14 10:43
 */
public class T0445 {

    @Test
    public void test() {
        int[] num1 = {7, 2, 4, 3};
        int[] num2 = {5, 6, 4, 8};
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(5);

        ListNode tmp = a;
        for (int i = 1; i < num1.length; i++) {
            tmp.next = new ListNode(num1[i]);
            tmp = tmp.next;
        }
        tmp = b;
        for (int i = 1; i < num2.length; i++) {
            tmp.next = new ListNode(num2[i]);
            tmp = tmp.next;

        }

        tmp = addTwoNumbers(a, b);
        while (tmp != null) {
            Out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //保存输入的两个数
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        num1.add(0);
        num2.add(0);
        ListNode node = l1;
        while (node != null) {
            num1.add(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            num2.add(node.val);
            node = node.next;
        }

        ListNode res = new ListNode(0);

        int i1 = num1.size() - 1;
        int i2 = num2.size() - 1;
        while (i1 > 0 || i2 > 0) {
            ListNode tmp = new ListNode((num1.get(i1) + num2.get(i2) + res.val) / 10);
            res.val = (num1.get(i1) + num2.get(i2) + res.val) % 10;
            tmp.next = res;
            res = tmp;
            if (i1 > 0) {
                i1--;
            }
            if (i2 > 0) {
                i2--;
            }
        }

        if (res.val != 0) {
            return res;
        } else {
            return res.next;
        }
    }
}

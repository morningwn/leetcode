package com.github.morningwn.to_offer.t001_t010;

import com.github.morningwn.prefab.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 从尾到头打印链表
 * @date Created in 2020/7/1 16:39
 * @version: 1.0
 */
public class T006 {

    public T006() {

    }

    /**
     * @param head 链表头结点
     * @return int[]
     * @author morningwn
     * @date 2020/7/1 16:52
     * @description: 遍历
     */
    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[len - i - 1] = list.get(i);
        }

        return res;
    }

    public void test() {
        new T006();
    }
}

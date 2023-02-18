package com.github.morningwn.t0501_t1000.t0701_t0800.t0721_t0730;

import com.github.morningwn.prefab.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分隔链表
 *
 * @author moringwn
 * @date 2021/9/22 上午9:45
 */
public class T0725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();

        ListNode node = head;

        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        int merchant = nodes.size() / k;
        int remainder = nodes.size() % k;
        boolean flag = remainder == 0;

        ListNode[] res = new ListNode[k];

        if (nodes.isEmpty()) {
            return res;
        }
        for (int i = 0, j = 0; i < k; i++) {
            if (flag) {
                res[i] = nodes.get(j);
                j += merchant;
                ListNode tmp = nodes.get(j - 1);
                tmp.next = null;
            } else {
                if (remainder-- > 0) {
                    res[i] = nodes.get(j);
                    j += 1 + merchant;
                    if (j < nodes.size()) {
                        ListNode tmp = nodes.get(j - 1);
                        tmp.next = null;
                    }
                } else {
                    if (j < nodes.size()) {
                        res[i] = nodes.get(j);
                        j += merchant;
                        ListNode tmp = nodes.get(j - 1);
                        tmp.next = new ListNode();
                    } else {
                        res[i] = new ListNode();
                    }
                }
            }
        }

        return res;

    }
}

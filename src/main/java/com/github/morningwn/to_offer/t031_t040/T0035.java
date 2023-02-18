package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author morningwn
 * @description: 复制带随机指针的链表
 * @date Created in 2020/7/10 11:00
 * @version: 1.0
 */
public class T0035 {


    /**
     * @author morningwn
     * @date 2020/7/11 17:10
     * @description: 使用哈希表存储每个阶段与其对应的复制节点，在复制完链表主体后重新构建random的引用
     * @param: head
     * @return: prefab.Node
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> dir = new HashMap<>();

        Node h = new Node(head.val);
        Node currNode = head;
        Node clone = h;
        dir.put(currNode, clone);
        while (currNode.next != null) {
            clone.next = new Node(currNode.next.val);
            clone = clone.next;
            currNode = currNode.next;
            dir.put(currNode, clone);
        }

        currNode = head;
        clone = h;
        while (currNode != null) {
            if (currNode.random != null) {
                clone.random = dir.get(currNode.random);
            }
            clone = clone.next;
            currNode = currNode.next;
        }

        return h;
    }
}

package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import com.github.morningwn.prefab.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * @author morningwn
 * @date 2020/9/28  14:48
 */
public class T0117 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size() - 1;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                node.next = queue.peek();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}

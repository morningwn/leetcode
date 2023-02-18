package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.Node;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/11 17:12
 */
public class T0036 {

    @Test
    public void test() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Out.println(treeToDoublyList(root).val);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node head = new Node();
        Node cur = root;

        while (cur.left != null) {
            cur = cur.left;
        }
        head.right = cur;

        Node l = findRight(root.left);
        Node r = findLeft(root.right);

        combine(l, root);
        combine(root, r);


        cur = head;
        while (cur.right != null) {
            cur = cur.right;
            Out.println(cur.val);
        }
        combine(cur, head.right);

        Out.println();
        cur = head.right;
        for (int i = 0; i < 9; i++) {
            Out.println(cur.val);
            cur = cur.right;
        }
        return head.right;
    }

    public Node findLeft(Node cur) {
        if (cur == null) {
            return null;
        }

        Node l = findRight(cur.left);
        Node r = findLeft(cur.right);

        combine(l, cur);
        combine(cur, r);

        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public Node findRight(Node cur) {
        if (cur == null) {
            return null;
        }

        Node l = findRight(cur.left);
        Node r = findLeft(cur.right);

        combine(l, cur);
        combine(cur, r);

        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public void combine(Node n1, Node n2) {
        if (n1 != null) {
            n1.right = n2;
        }
        if (n2 != null) {
            n2.left = n1;
        }
    }

}

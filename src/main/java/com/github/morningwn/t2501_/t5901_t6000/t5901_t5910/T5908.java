package com.github.morningwn.t2501_.t5901_t6000.t5901_t5910;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2021/10/24 11:29
 */
public class T5908 {


    @Test
    public void test() {
        int[] parents = {-1, 2, 0, 2, 0};

        Out.println(countHighestScoreNodes(parents));
    }

    public int countHighestScoreNodes(int[] parents) {

        Node helper = this.helper(parents);

        return helper2(helper)[1];
    }

    private Node helper(int[] parents) {
        Node[] nodes = new Node[parents.length];
        nodes[0] = new Node(0);

        for (int i = 1; i < parents.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node(i);
            }
            if (nodes[parents[i]] == null) {
                nodes[parents[i]] = new Node(parents[i]);
            }
            nodes[parents[i]].add(nodes[i]);
        }

        return nodes[0];
    }

    private int[] helper2(Node node) {
        int res = 1;

        if (node.parent != null) {
            res *= node.parent.size - node.size;
        }

        if (node.left != null) {
            res *= node.left.size;
        }

        if (node.right != null) {
            res *= node.right.size;
        }

        int index = node.val;

        if (node.left != null) {
            int[] tmp = helper2(node.left);
            if (tmp[0] > res) {
                res = tmp[0];
                index = tmp[1];
            }
        }
        if (node.right != null) {
            int[] tmp = helper2(node.right);
            if (tmp[0] > res) {
                res = tmp[0];
                index = tmp[1];
            }
        }
        return new int[]{res, index};
    }

    class Node {
        Node parent;
        Node left;
        Node right;
        int size;
        int val;

        public Node(int val) {
            this.size = 1;
            this.val = val;
        }

        public void add(Node node) {
            if (this.left != null) {
                this.right = node;
            } else {
                this.left = node;
            }
            node.parent = this;
            this.ref();
        }

        public void ref() {
            if (left != null) {
                this.size = left.size + 1;
            }
            if (right != null) {
                this.size += right.size;
            }
            if (parent != null) {
                parent.ref();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", size=" + size +
                    ", val=" + val +
                    '}';
        }
    }
}

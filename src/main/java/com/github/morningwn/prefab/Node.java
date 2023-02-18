package com.github.morningwn.prefab;

/**
 * @author morningwn
 * @description: Definition for a Node.
 * @date Created in 2020/7/10 10:59
 * @version: 1.0
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node left;
    public Node right;

    public Node prev;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", child=" + child +
                '}';
    }
}

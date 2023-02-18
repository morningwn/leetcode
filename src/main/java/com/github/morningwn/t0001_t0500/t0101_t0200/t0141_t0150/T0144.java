package com.github.morningwn.t0001_t0500.t0101_t0200.t0141_t0150;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 * @date 2020/10/27 8:40
 */
public class T0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        TreeNode node = null;

        while (!deque.isEmpty()) {
            node = deque.pollFirst();
            if (node == null) {
                continue;
            }

            list.add(node.val);
            deque.addFirst(node.right);
            deque.addFirst(node.left);
        }

        return list;
    }

//    /**
//     * 递归算法
//     * @param root
//     * @return
//     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        helper(root, list);
//        return list;
//    }
//
//    public void helper(TreeNode root, List<Integer> list) {
//        if (root == null) { return; }
//
//        list.add(root.val);
//        helper(root.left, list);
//        helper(root.right, list);
//    }
}

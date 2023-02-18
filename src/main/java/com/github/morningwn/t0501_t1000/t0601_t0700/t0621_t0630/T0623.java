package com.github.morningwn.t0501_t1000.t0601_t0700.t0621_t0630;

import com.github.morningwn.prefab.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/add-one-row-to-tree/">623. 在二叉树中增加一行</a>
 *
 * @author morningwn
 * @create in 2022/8/5 9:24
 */
public class T0623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int h = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                if (h == depth - 1) {
                    addNode(queue.pollFirst(), val);
                } else {
                    TreeNode node = queue.pollFirst();
                    if (node.left != null) {
                        tmp.addLast(node.left);
                    }
                    if (node.right != null) {
                        tmp.addLast(node.right);
                    }
                }
            }
            h++;
            queue = tmp;
        }

        return root;
    }

    private void addNode(TreeNode root, int val) {
        TreeNode left = new TreeNode(val);
        left.left = root.left;
        root.left = left;
        TreeNode right = new TreeNode(val);
        right.right = root.right;
        root.right = right;
    }

}

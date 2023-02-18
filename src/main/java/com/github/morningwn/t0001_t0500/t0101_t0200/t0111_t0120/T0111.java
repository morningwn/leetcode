package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;


import com.github.morningwn.prefab.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author morningwn
 * @description: 二叉树的最小深度
 * @date Created in 2020/5/13 20:57
 * @version: 1.0
 */
public class T0111 {
    public T0111() {

    }

    public int minDepth(TreeNode root) {
        int h = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            h++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (tmp.left == null && tmp.right == null) {
                    return h;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return h;
    }

    public void test() {

    }
}

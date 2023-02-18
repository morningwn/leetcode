package com.github.morningwn.t0501_t1000.t0601_t0700.t0671_t0680;


import com.github.morningwn.prefab.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/">671. 二叉树中第二小的节点</a>
 *
 * @author morningwn
 * @date Created in 2020/5/31 12:52
 */
public class T0671 {

    public int findSecondMinimumValue(TreeNode root) {

        int min = Integer.MAX_VALUE;
        long secondMin = min + 1L;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            min = root.val;
        } else {
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    if (tmp.val > min && tmp.val < secondMin) {
                        secondMin = tmp.val;
                    } else if (tmp.val == min) {
                        queue.offer(tmp.left);
                        queue.offer(tmp.right);
                    }
                }
            }
        }

        return secondMin == (Integer.MAX_VALUE + 1L) ? -1 : (int) secondMin;

    }

}

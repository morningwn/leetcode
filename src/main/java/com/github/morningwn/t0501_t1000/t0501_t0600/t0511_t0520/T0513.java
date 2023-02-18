package com.github.morningwn.t0501_t1000.t0501_t0600.t0511_t0520;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">513. 找树左下角的值</a>
 *
 * @author moringwn
 * @create in 2022/6/22 16:38
 */
public class T0513 {

    public int findBottomLeftValue(TreeNode root) {
        int result = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            result = queue.peek().val;
            TreeNode treeNode = queue.poll();
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
        }

        return result;
    }
}

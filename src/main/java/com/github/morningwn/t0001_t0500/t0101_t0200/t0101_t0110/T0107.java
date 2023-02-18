package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @date Created in 2020/5/13 10:30
 */
public class T0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            if (tmp.size() > 0) {
                res.add(0, tmp);
            }
        }
        return res;
    }
}

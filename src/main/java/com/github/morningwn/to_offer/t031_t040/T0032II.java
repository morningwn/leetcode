package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @description: 从上到下打印二叉树II
 * @date Created in 2020/7/9 10:28
 * @version: 1.0
 */
public class T0032II {

    /**
     * @author morningwn
     * @date 2020/7/9 10:32
     * @description: 层次遍历
     * @param: root
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    tmp.add(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }
            }

            if (!tmp.isEmpty()) {
                res.add(tmp);
            }
        }

        return res;

    }
}

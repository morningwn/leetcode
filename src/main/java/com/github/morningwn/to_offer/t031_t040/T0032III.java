package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @description: 从上到下打印二叉树 III
 * @date Created in 2020/7/9 13:00
 * @version: 1.0
 */
public class T0032III {

    /**
     * @author morningwn
     * @date 2020/7/9 13:06
     * @description: 层次遍历，增加一个记录当前第几行的标记，根据标记确定插入位置
     * @param: root
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean reverse = (level++ & 1) == 1;
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    if (reverse) {
                        tmp.add(0, currNode.val);
                    } else {
                        tmp.add(currNode.val);
                    }
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

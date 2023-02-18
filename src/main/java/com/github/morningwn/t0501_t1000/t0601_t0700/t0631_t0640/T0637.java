package com.github.morningwn.t0501_t1000.t0601_t0700.t0631_t0640;

import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">637. 二叉树的层平均值</a>
 *
 * @author morningwn
 * @date Created in 2020/5/13 10:32
 */
public class T0637 {
    @Test
    public void test() {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

            if (size > 0) {
                res.add(sum / size);
            }
        }
        return res;
    }

}

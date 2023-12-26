package com.github.morningwn.t1001_t1500.t1301_t1400.t1301_t1310;

import com.github.morningwn.prefab.TreeNode;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/deepest-leaves-sum/">1302. 层数最深叶子节点的和</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Tree}</li>
 * <li>{@link Topic#DepthFirstSearch}</li>
 * <li>{@link Topic#BreadthFirstSearch}</li>
 * <li>{@link Topic#BinaryTree}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-26 17:47:15
 */
public class J1302 {

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        int res = 0;
        while (!deque.isEmpty()) {
            res = 0;
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                res += node.val;
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }

        return res;
    }

}

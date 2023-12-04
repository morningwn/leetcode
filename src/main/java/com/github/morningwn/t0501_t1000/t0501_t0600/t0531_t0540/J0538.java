package com.github.morningwn.t0501_t1000.t0501_t0600.t0531_t0540;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import com.github.morningwn.prefab.Node;
import com.github.morningwn.prefab.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. 把二叉搜索树转换为累加树</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Tree}</li>
 * <li>{@link Topic#DepthFirstSearch}</li>
 * <li>{@link Topic#BinarySearchTree}</li>
 * <li>{@link Topic#BinaryTree}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-04 17:29:41
 */
public class J0538 {
    public TreeNode convertBST(TreeNode root) {
        hepler(root, 0);
        return root;
    }

    public int hepler(TreeNode node, int parent) {
        if (node == null) {
            return 0;
        }
        int right = hepler(node.right, parent);
        int val = node.val;

        node.val = right + parent + node.val;

        int left = hepler(node.left, node.val);

        return left + right + val;
    }
}

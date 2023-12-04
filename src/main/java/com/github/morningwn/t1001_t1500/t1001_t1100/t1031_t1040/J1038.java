package com.github.morningwn.t1001_t1500.t1001_t1100.t1031_t1040;

import com.github.morningwn.prefab.TreeNode;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/">1038. 从二叉搜索树到更大和树</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Tree}</li>
 * <li>{@link Topic#DepthFirstSearch}</li>
 * <li>{@link Topic#BinarySearchTree}</li>
 * <li>{@link Topic#BinaryTree}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-04 17:19:12
 */
public class J1038 {
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

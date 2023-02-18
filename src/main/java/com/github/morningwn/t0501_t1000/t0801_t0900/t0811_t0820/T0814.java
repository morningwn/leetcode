package com.github.morningwn.t0501_t1000.t0801_t0900.t0811_t0820;

import com.github.morningwn.prefab.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-pruning/">814. 二叉树剪枝</a>
 *
 * @author morningwn
 * @create in 2022/7/21 16:26
 */
public class T0814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 1 || root.left != null || root.right != null) {
            return root;
        } else {
            return null;
        }
    }
}

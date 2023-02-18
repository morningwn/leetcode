package com.github.morningwn.t0501_t1000.t0701_t0800.t0701_0710;

import com.github.morningwn.prefab.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/">701. 二叉搜索树中的插入操作</a>
 *
 * @author morningwn
 * @date 2020/9/30  8:41
 */
public class T0701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return helper(root, val);
        } else {
            helper(root, val);
        }

        return root;
    }

    public TreeNode helper(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }

        if (node.val < val) {
            node.right = helper(node.right, val);
        } else {
            node.left = helper(node.left, val);
        }

        return node;
    }
}

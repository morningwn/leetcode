package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import com.github.morningwn.prefab.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/same-tree/">100. 相同的树</a>
 *
 * @author morningwn
 * @date Created in 2024/7/23 17:26
 */
public class J0100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
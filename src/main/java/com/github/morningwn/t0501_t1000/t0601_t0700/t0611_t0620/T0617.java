package com.github.morningwn.t0501_t1000.t0601_t0700.t0611_t0620;

import com.github.morningwn.prefab.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/">617. 合并二叉树</a>
 *
 * @author morningwn
 * @date 2020/9/23  8:35
 */
public class T0617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}

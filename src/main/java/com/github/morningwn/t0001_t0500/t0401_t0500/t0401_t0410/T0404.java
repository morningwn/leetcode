package com.github.morningwn.t0001_t0500.t0401_t0500.t0401_t0410;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @date 2020/9/19  16:14
 */
public class T0404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res = root.left.val;
            } else {
                res = sumOfLeftLeaves(root.left);
            }
        }

        res += sumOfLeftLeaves(root.right);

        return res;
    }
}

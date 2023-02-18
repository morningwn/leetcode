package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @description: 路径总和
 * @date Created in 2020/5/13 10:41
 * @version: 1.0
 */
public class T0112 {
    public T0112() {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            return getOneSum(root, 0, sum);
        } else {
            return false;
        }
    }

    public boolean getOneSum(TreeNode root, int sum, int target) {

        if (sum > target) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum + root.val == target;
        }

        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = getOneSum(root.left, sum + root.val, target);
        }
        if (root.right != null) {
            right = getOneSum(root.right, sum + root.val, target);
        }

        return left || right;
    }

    public void test() {

    }
}

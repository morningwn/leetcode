package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/31 11:12
 */
public class T0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return helper(root.left, root.right);
        } else {
            return true;
        }
    }

    public boolean helper(TreeNode l, TreeNode r) {

        if (l != null && r != null) {
            if (l.val == r.val) {
                return helper(l.left, r.right) && helper(l.right, r.left);
            } else {
                return false;
            }
        } else return l == null && r == null;
    }

    @Test
    public void test() {

    }
}

package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/13 23:45
 */
public class T0110 {
    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        Out.println(isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
//        Out.println(getheight(root));
        return getheight(root) != -1;
    }

    public int getheight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getheight(root.left);
        int right = getheight(root.right);

        if (Math.abs(left - right) > 1 || right == -1 || left == -1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    /**
     * 自顶向下
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            return isBalanced1(root.left) && isBalanced1(root.right);
        } else {
            return false;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}

package com.github.morningwn.t0001_t0500.t0101_t0200.t0121_t0130;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/">129. 求根节点到叶节点数字之和</a>
 *
 * @author morningwn
 * @date Created in 2020/8/14 22:26
 */
public class J0129 {

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        Out.println(sumNumbers(node));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        sum = sum * 10 + root.val;
        if (root.left != null && root.right != null) {
            return helper(root.left, sum) + helper(root.right, sum);
        } else if (root.left != null && root.right == null) {
            return helper(root.left, sum);
        } else if (root.left == null && root.right != null) {
            return helper(root.right, sum);
        } else {
            return sum;
        }
    }
}

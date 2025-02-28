package com.github.morningwn.t2001_t2500.t2301_t2400.t2331_t2340;

import com.github.morningwn.prefab.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/evaluate-boolean-binary-tree/">2331. 计算布尔二叉树的值</a>
 *
 * @author morningwn
 * @create in 2023/2/6 10:13
 */
public class J2331 {

    public boolean evaluateTree(TreeNode root) {
        // 规则内，输入数据不可能为null
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}

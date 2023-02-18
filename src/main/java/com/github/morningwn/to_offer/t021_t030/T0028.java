package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @description: 对称的二叉树
 * @date Created in 2020/7/8 17:59
 * @version: 1.0
 */
public class T0028 {


    /**
     * @author morningwn
     * @date 2020/7/8 18:16
     * @description: 判断一个二叉树是不是对称的
     * @param: root
     * @return: boolean
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return helper(root.left, root.right);
        }
    }

    /**
     * @author morningwn
     * @date 2020/7/8 18:16
     * @description: 递归的判断输入的两个节点是不是对称，其子树是不是对称
     * @param: l
     * @param: r
     * @return: boolean
     */
    public boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l != null && r != null) {
            if (l.val == r.val) {
                return helper(l.left, r.right) && helper(l.right, r.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

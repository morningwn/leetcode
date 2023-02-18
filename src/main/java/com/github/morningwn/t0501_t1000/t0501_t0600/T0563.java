package com.github.morningwn.t0501_t1000.t0501_t0600;

import com.github.morningwn.prefab.TreeNode;

/**
 * 563. 二叉树的坡度
 * <link>https://leetcode-cn.com/problems/binary-tree-tilt/</link>
 *
 * @author morningwn
 * @date Created in 2021/11/18 10:14
 */
public class T0563 {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = findTilt(root.left);
        res += findTilt(root.right);

        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;

        res += Math.abs(left - right);
        root.val += left + right;

        return res;
    }
}

package com.github.morningwn.t0501_t1000.t0701_t0800.t0781_t0790;

import com.github.morningwn.prefab.TreeNode;

/**
 * 二叉搜索树节点最小距离
 * <p>
 * 题目同530 {@link T0530}
 *
 * @author morningwn
 * @date 2020/10/12  15:18
 */
public class T0783 {
    private int res = Integer.MAX_VALUE;
    private int pre = -1;

    public int minDiffInBST(TreeNode root) {

        hepler(root);

        return res;
    }

    public void hepler(TreeNode root) {
        if (root == null) {
            return;
        }

        hepler(root.left);
        if (pre != -1) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        hepler(root.right);
    }
}

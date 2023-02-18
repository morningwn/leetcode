package com.github.morningwn.t0501_t1000.t0501_t0600.t0521_t0530;

import com.github.morningwn.prefab.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * <p>
 * 题目同783{@link T0783}
 *
 * @author morningwn
 * @date 2020/10/12  14:15
 */
public class T0530 {
    private int res = Integer.MAX_VALUE;
    private int pre = -1;

    /**
     * 中序遍历，这个是最优解法
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
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

//    /**
//     * 垃圾算法
//     * @param root
//     * @return
//     */
//    public int getMinimumDifference(TreeNode root) {
//        helper(root);
//
//        return res;
//    }
//
//    public int[] helper(TreeNode root) {
//        int[] left = {root.val, root.val};
//        int[] right = {root.val, root.val};;
//        if (root.left != null) {
//            left = helper(root.left);
//            res = Math.min(res, root.val - left[1]);
//
//        }
//
//        if (root.right != null) {
//            right = helper(root.right);
//            res = Math.min(res, right[0] - root.val);
//        }
//        return new int[] {left[0], right[1]};
//    }

}

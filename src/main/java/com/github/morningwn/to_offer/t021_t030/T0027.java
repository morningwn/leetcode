package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @description: 二叉树的镜像
 * @date Created in 2020/7/8 17:45
 * @version: 1.0
 */
public class T0027 {


    /**
     * @author morningwn
     * @date 2020/7/8 17:54
     * @description: 递归的去将数组的每个子节点翻转，然后返回本节点
     * @param: root  跟节点
     * @return: prefab.TreeNode 翻转后的根节点
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;
    }
}

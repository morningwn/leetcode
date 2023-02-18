package com.github.morningwn.t0001_t0500.t0101_t0200.t0141_t0150;

import com.github.morningwn.prefab.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author morningwn
 * @date 2020/9/29  16:10
 */
public class T0145 {

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();

        return list;
    }

//    /**
//     * 递归法
//     * @param root 根节点
//     * @return 后序遍历的结果
//     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        helper(root, list);
//
//        return list;
//    }
//
//    public void helper(TreeNode root, List<Integer> list) {
//        if (root == null) { return; }
//
//        helper(root.left, list);
//        helper(root.right, list);
//        list.add(root.val);
//    }
}

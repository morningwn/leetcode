package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author morningwn
 * @date 2020/9/14  15:21
 */
public class T0094 {


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            TreeNode tmp = stack1.pop();
        }

        return list;
    }

//    /**
//     * 使用递归的中序遍历
//     * @param root
//     * @return
//     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        helper(list, root);
//
//        return list;
//    }
//
//    public void helper(List<Integer> list, TreeNode root) {
//        if (root == null) { return; }
//
//        helper(list, root.left);
//        list.add(root.val);
//        helper(list, root.right);
//    }
}

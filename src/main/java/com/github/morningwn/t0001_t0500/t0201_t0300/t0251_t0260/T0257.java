package com.github.morningwn.t0001_t0500.t0201_t0300.t0251_t0260;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">257. 二叉树的所有路径</a>
 *
 * @author morningwn
 * @date 2020/9/4  13:25
 */
public class T0257 {
    private List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> queue = new LinkedList<>();
        res = new ArrayList<>();
        helper(queue, root);

        return res;
    }

    public void helper(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (node.left == null && node.right == null) {
            addRes(list);
        } else {
            helper(list, node.left);
            helper(list, node.right);
        }
        list.remove(list.size() - 1);

    }

    public void addRes(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));

            if (i < list.size() - 1) {
                sb.append('-');
                sb.append('>');
            }
        }
        res.add(sb.toString());
    }
}
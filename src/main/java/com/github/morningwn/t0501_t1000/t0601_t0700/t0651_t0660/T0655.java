package com.github.morningwn.t0501_t1000.t0601_t0700.t0651_t0660;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/print-binary-tree/">655. 输出二叉树</a>
 *
 * @author morningwn
 * @create in 2022/8/22 14:18
 */
public class T0655 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(3);

        List<List<String>> lists = printTree(root);
        Out.println(lists);
    }

    int high;
    int m;
    int n;

    public List<List<String>> printTree(TreeNode root) {
        high = getHigh(root, 0);
        m = high + 1;
        n = (1 << (high + 1)) - 1;

        System.out.println(high);
        System.out.println(m);
        System.out.println(n);
        List<List<String>> tree = new ArrayList<>(m);

        helper(tree, 0, (n - 1) / 2, root);

        return tree;
    }

    private void helper(List<List<String>> tree, int r, int c, TreeNode node) {
        if (node == null) {
            return;
        }
        List<String> line;
        if (tree.size() > r) {
            line = tree.get(r);
        } else {
            line = fill();
            tree.add(line);
        }
        line.set(c, String.valueOf(node.val));

        helper(tree, r + 1, c - (1 << (high - r - 1)), node.left);
        helper(tree, r + 1, c + (1 << (high - r - 1)), node.right);
    }

    private int getHigh(TreeNode node, int level) {
        if (node != null) {
            return Math.max(getHigh(node.left, level + 1), getHigh(node.right, level + 1));
        }
        return level - 1;
    }

    private List<String> fill() {
        List<String> line = new ArrayList<>(n);
        while (line.size() < n) {
            line.add("");
        }
        return line;
    }
}

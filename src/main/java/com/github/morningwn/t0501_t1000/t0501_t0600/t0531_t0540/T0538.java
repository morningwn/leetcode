package com.github.morningwn.t0501_t1000.t0501_t0600.t0531_t0540;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. 把二叉搜索树转换为累加树</a>
 *
 * @author morningwn
 * @create in
 */
public class T0538 {

    @Test
    public void test() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(13);

        node = convertBST(node);

        Out.println(node);
    }

    public TreeNode convertBST(TreeNode root) {
        hepler(root, 0);

        return root;
    }

    public int hepler(TreeNode node, int parent) {
        if (node == null) {
            return 0;
        }

        int right = hepler(node.right, parent);
        int val = node.val;

        node.val = right + parent + node.val;

        int left = hepler(node.left, node.val);

        return left + right + val;
    }
}

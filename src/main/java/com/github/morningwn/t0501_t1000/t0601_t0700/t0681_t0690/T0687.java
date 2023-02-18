package com.github.morningwn.t0501_t1000.t0601_t0700.t0681_t0690;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/longest-univalue-path/">687. 最长同值路径</a>
 *
 * @author morningwn
 * @create in 2022/9/2 9:29
 */
public class T0687 {

    @Test
    public void test() {
        String s = "[1,4,5,4,4,null,5]";
        TreeNode root = FormatInput.formatTreeNode(s);
        Out.println(longestUnivaluePath(root));
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxVal;
    }

    int maxVal = 1;

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (node.left != null && node.left.val == node.val) {
            left++;
        } else {
            left = 0;
        }
        if (node.right != null && node.right.val == node.val) {
            right++;
        } else {
            right = 0;
        }

        Out.printlnf("left: %d, right: %d, node: %s", left, right, node);
        maxVal = Math.max(maxVal, left + right);
        return Math.max(left, right);
    }
}

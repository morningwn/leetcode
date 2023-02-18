package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/9/25  10:01
 */
public class T0106 {

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};


        Out.println(buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend) {
        if (istart > iend) {
            return null;
        }

        int val = postorder[pend];
        int count = 0;

        //分割
        for (; count + istart <= iend; count++) {
            if (inorder[count + istart] == val) {
                break;
            }
        }

        TreeNode node = new TreeNode(val);
        if (count > 0) {
            node.left = helper(inorder, postorder, istart, istart + count - 1, pstart, pstart + count - 1);
            node.right = helper(inorder, postorder, istart + count + 1, iend, pstart + count, pend - 1);
        }

        return node;
    }
}

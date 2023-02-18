package com.github.morningwn.t1001_t1500.t1001_t1100.t1001_t1010;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/">1008. 前序遍历构造二叉搜索树</a>
 *
 * @author morningwn
 * @date 2020/9/16  0:28
 */
public class T1008 {

    @Test
    public void test() {
        int[] nums = {8, 5};

        Out.println(bstFromPreorder(nums));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
//        Out.println("start:" + start +"\t end:" + end);
        if (start > end) {
            return null;
        }

        int val = preorder[start];
        int middle = start + 1;

        while (middle <= end && preorder[middle] < val) {
            middle++;
        }

        TreeNode node = new TreeNode(val);

        node.left = helper(preorder, start + 1, middle - 1);
        node.right = helper(preorder, middle, end);

        return node;
    }

}

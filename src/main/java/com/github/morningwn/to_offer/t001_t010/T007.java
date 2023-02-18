package com.github.morningwn.to_offer.t001_t010;

import com.github.morningwn.prefab.TreeNode;

import java.util.Arrays;

/**
 * @author morningwn
 * @description: 重建二叉树
 * @date Created in 2020/7/1 17:00
 * @version: 1.0
 */
public class T007 {

    public T007() {

    }

    /**
     * @param preorder 先序遍历
     * @param inorder  中序遍历值
     * @return prefab.TreeNode
     * @author morningwn
     * @date 2020/7/1 17:02
     * @description: 递归得到结果
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //若数组长度为0则表示到头了，返回null
        if (preorder.length != 0) {

            //初始化父节点
            TreeNode node = new TreeNode(preorder[0]);
            //查找分割点的位置
            int count = 0;
            while (inorder[count] != preorder[0]) {
                count++;
            }

            //进入左子树的递归
            node.left = buildTree(Arrays.copyOfRange(preorder, 1, count + 1), Arrays.copyOfRange(inorder, 0, count));
            //进入右子树的递归
            node.right = buildTree(Arrays.copyOfRange(preorder, count + 1, preorder.length), Arrays.copyOfRange(inorder, count + 1, inorder.length));
            //返回父节点
            return node;
        } else {
            return null;
        }
    }
}

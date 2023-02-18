package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.Arrays;

public class T0105 {

    //我自己写的方法
    private int[] preorder;
    private int[] inorder;

    @Test
    public void test() {
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};

        int[] preorder = {3, 9, 4, 6, 5, 20, 15, 16, 12, 13, 8, 7, 10, 11, 14};
        int[] inorder = {4, 6, 9, 5, 3, 12, 16, 13, 15, 8, 20, 10, 7, 14, 11};

//        int[] preorder = {};
//        int[] inorder = {};

        TreeNode treeNode = buildTree(preorder, inorder);

        show(treeNode);
    }

    //大佬的代码后改过的
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

    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        //若输入长度为零
        if (preorder.length == 0) {
            return null;
        }

        //将数组赋值
        this.preorder = preorder;
        this.inorder = inorder;

        //初始化头结点
        TreeNode node = new TreeNode(preorder[0]);

        //查找分割点的位置
        int count = 0;
        while (inorder[count] != preorder[0]) {
            count++;
        }
//        Out.println( count );

        //如果count就代表左子树不为空，进入左子树递归
        if (count > 0) {
            build(true, node, 1, count, 0, count - 1);
        }

        //右子树不为空，进入右子树
        if (count + 1 <= inorder.length - 1) {
            build(false, node, count + 1, inorder.length - 1, count + 1, inorder.length - 1);
        }

        return node;
    }

    private void build(boolean dir, TreeNode node, int perStart, int perEnd, int inStart, int inEnd) {

//        Out.println( preorder[perStart] + "\t " +perStart +"\t "+ perEnd +"\t "+ inStart + "\t " + inEnd );

        //根据dir传入的值判断是左子树还是右子树，然后进行赋值
        if (dir) {
            node.left = new TreeNode(preorder[perStart]);
            node = node.left;
        } else {
            node.right = new TreeNode(preorder[perStart]);
            node = node.right;
        }

        //如果传入数组的长度大于一，也就是存在分割的可能
        if (perEnd > perStart) {
            int count = 0;
            while (inorder[inStart + count] != preorder[perStart]) {
                count++;
            }

            //左子树不为空，进入左子树递归
            if (count > 0) {
                build(true, node, perStart + 1, perStart + count, inStart, inStart + count - 1);
            }

            //右子树不为空，进入右子树
            if (perStart + count + 1 <= perEnd) {
                build(false, node, perStart + count + 1, perEnd, inStart + count + 1, inEnd);
            }
        }

    }

    public void show(TreeNode node) {

        if (node != null) {
            Out.println(node.val);
            show(node.left);
            show(node.right);
        }

    }
}



package com.github.morningwn.t0501_t1000.t0601_t0700.t0651_t0660;

import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 *
 * @author morningwn
 * @date Created in 2020/12/7 21:22
 */
public class T0654 {

    @Test
    public void test() {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        TreeNode root = new TreeNode(nums[0]);
        TreeNode parent = root;
        //用于查询上一个结点
        ArrayList<TreeNode> heap = new ArrayList<>();
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            //将上一次循环创建的节点压入栈中
            heap.add(parent);
            index++;

            //判断当前的值是不是比父节点大，小就直接进行创建，大就进行else
            if (parent.val > nums[i]) {

                parent.right = new TreeNode(nums[i]);
                parent = parent.right;

            } else {

                //弹栈，寻找合适的节点，注意判断栈内是不是空了
                while (heap.size() > 0 && heap.get(index - 1).val < nums[i]) {
                    heap.remove(index - 1);
                    index--;
                }

                TreeNode temp = new TreeNode(nums[i]);

                //如果栈空了的话就代表当前树中所有的值都没接下来的这个大，就把这个值创建成根节点，原来的树变为左子树
                if (heap.size() == 0) {

                    temp.left = root;
                    root = temp;
                    parent = root;
                    //没空就进行交换，得到结果
                } else {

                    temp.left = heap.get(heap.size() - 1).right;
                    heap.get(heap.size() - 1).right = temp;
                    parent = temp;
                }
            }

        }

        return root;
    }

}


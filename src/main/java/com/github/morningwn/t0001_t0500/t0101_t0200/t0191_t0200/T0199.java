package com.github.morningwn.t0001_t0500.t0101_t0200.t0191_t0200;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @date Created in 2020/4/22 12:34
 */
public class T0199 {

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(8);

        Out.println(rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        } else {
            return res;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }

                if (i == size - 1) {
                    res.add(tmp.val);
                }
            }
        }

        return res;
    }

    /**
     * 广度优先遍历，未优化
     *
     * @param root 二叉树的根节点
     * @return 右侧视图
     */
    public List<Integer> rightSideView1(TreeNode root) {

        Queue<TreeNode> a = new LinkedList<TreeNode>();
        Queue<TreeNode> b = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();


        if (root == null) {
            return res;
        }

        a.offer(root);

        while (!a.isEmpty()) {
            TreeNode tmp = a.poll();
            if (tmp.left != null) {
                b.offer(tmp.left);
            }
            if (tmp.right != null) {
                b.offer(tmp.right);
            }

            if (a.isEmpty()) {
                a = new LinkedList<>(b);
                b.clear();
                res.add(tmp.val);
            }
        }

        return res;
    }

}

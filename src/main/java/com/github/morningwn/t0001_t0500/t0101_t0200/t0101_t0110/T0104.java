package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author morningwn
 * @date Created in 2020/5/13 10:30
 */
public class T0104 {

    @Test
    public void test() {


/*        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode( 4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right = new TreeNode( 6 );*/

/*        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode( 4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);*/

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(10);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(-1);
        root.right.right.right = new TreeNode(8);


        Out.println(maxDepth(root));
//        Out.println( maxDepth1(root));

    }

    //非递归
    public int maxDepth(TreeNode root) {

        int h = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            h++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return h;
    }

    //递归
    public int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
        }
    }

}

package com.github.morningwn.t0001_t0500.t0201_t0300.t0231_t0240;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author morningwn
 * @date Created in 2020/5/10 16:10
 */
public class T0236 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode res = root;
        boolean isChanged = true;

        while (!queue.isEmpty() && isChanged) {

            isChanged = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (hasTreeNode(tmp, p) && hasTreeNode(tmp, q)) {
                    queue.clear();
                    res = tmp;
                    isChanged = true;
                }

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }

                if (isChanged) {
                    break;
                }
            }
        }

        return res;
    }

    public boolean hasTreeNode(TreeNode root, TreeNode tag) {
        boolean has = false;

        if (root.val == tag.val) {
            has = true;
        } else {
            if (root.left != null) {
                has = has || hasTreeNode(root.left, tag);
            }
            if (root.right != null) {
                has = has || hasTreeNode(root.right, tag);
            }
        }
        return has;
    }

}

package com.github.morningwn.t0501_t1000.t0901_t1000.t0911_t0920;

import com.github.morningwn.prefab.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/">919. 完全二叉树插入器</a>
 *
 * @author morningwn
 * @create in 2022/7/25 15:23
 */
public class T0919 {

    class CBTInserter {
        private final TreeNode root;
        private final Deque<TreeNode> deque;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.deque = new LinkedList<>();
            init();
        }

        private void init() {
            Deque<TreeNode> tmpQue = new LinkedList<>();
            tmpQue.addLast(root);
            while (!tmpQue.isEmpty()) {
                TreeNode tmp = tmpQue.pollFirst();
                if (tmp == null) {
                    continue;
                }
                if (tmp.left == null || tmp.right == null) {
                    deque.addLast(tmp);
                }
                tmpQue.addLast(tmp.left);
                tmpQue.addLast(tmp.right);
            }

        }

        public int insert(int val) {
            TreeNode treeNode = deque.peekFirst();
            while (treeNode == null) {
                deque.pollFirst();
                treeNode = deque.peekFirst();
            }

            if (treeNode.left == null) {
                treeNode.left = new TreeNode(val);
                deque.addLast(treeNode.left);
                return treeNode.val;
            } else {
                treeNode.right = new TreeNode(val);
                deque.pollFirst();
                deque.addLast(treeNode.right);
                return treeNode.val;
            }
        }

        public TreeNode get_root() {
            return root;
        }
    }

}

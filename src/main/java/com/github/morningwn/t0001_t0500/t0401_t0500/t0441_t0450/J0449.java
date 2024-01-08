package com.github.morningwn.t0001_t0500.t0401_t0500.t0441_t0450;

import cn.hutool.json.JSONUtil;
import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-bst/">449. 序列化和反序列化二叉搜索树</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Tree}</li>
 * <li>{@link Topic#DepthFirstSearch}</li>
 * <li>{@link Topic#BreadthFirstSearch}</li>
 * <li>{@link Topic#Design}</li>
 * <li>{@link Topic#BinarySearchTree}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#BinaryTree}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2022/5/11 14:31
 */
public class J0449 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Codec codec = new Codec();
        String serialize = codec.serialize(root);

        Out.println(serialize);
        TreeNode res = codec.deserialize(serialize);

        Out.println(JSONUtil.toJsonStr(res));
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.pollFirst();
                if (tmp != null) {
                    sb.append(tmp.val);
                    sb.append(",");
                    queue.addFirst(tmp.right);
                    queue.addFirst(tmp.left);
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            char[] chars = data.toCharArray();

            TreeNode root = null;
            Deque<TreeNode> queue = new LinkedList<>();

            int num = 0;
            for (char c : chars) {
                if (c != ',') {
                    num = getNum(num, c);
                } else {
                    if (root == null) {
                        root = new TreeNode(num);
                        queue.addFirst(root);
                    } else {
                        TreeNode tmp = queue.getFirst();
                        if (tmp.val > num) {
                            tmp.left = new TreeNode(num);
                            queue.addFirst(tmp.left);
                        } else {
                            while (!queue.isEmpty() && queue.peekFirst().val < num) {
                                tmp = queue.pollFirst();
                            }
                            tmp.right = new TreeNode(num);
                            queue.addFirst(tmp.right);
                        }
                    }
                    num = 0;
                }
            }

            return root;
        }

        private int getNum(int num, char c) {
            return num * 10 + c - '0';
        }
    }

}

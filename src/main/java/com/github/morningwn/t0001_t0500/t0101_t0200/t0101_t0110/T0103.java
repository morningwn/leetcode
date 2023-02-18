package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 二叉树的锯齿形层次遍历
 * @date Created in 2020/5/13 20:46
 * @version: 1.0
 */
public class T0103 {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            doOneLeve(root, 0);
            return res;
        } else {
            return res;
        }
    }

    public void doOneLeve(TreeNode node, int h) {
        List<Integer> list;
        if (res.size() <= h) {
            list = new ArrayList<>();
            res.add(list);
        } else {
            list = res.get(h);
        }

        if (h % 2 == 0) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        if (node.left != null) {
            doOneLeve(node.left, h + 1);
        }
        if (node.right != null) {
            doOneLeve(node.right, h + 1);
        }
    }

    @Test
    public void test() {

    }
}

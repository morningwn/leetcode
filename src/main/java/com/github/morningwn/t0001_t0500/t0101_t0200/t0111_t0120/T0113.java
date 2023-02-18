package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 路径总和 II
 * @date Created in 2020/5/13 10:54
 * @version: 1.0
 */
public class T0113 {
    private final List<List<Integer>> res = new ArrayList<>();

    public T0113() {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            OnePath(root, sum, new ArrayList());
            return res;
        } else {
            return res;
        }
    }

    public void OnePath(TreeNode root, int sum, List<Integer> list) {
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(list);
            }
            return;
        }

        if (root.left != null) {
            OnePath(root.left, sum - root.val, new ArrayList<>(list));
        }

        if (root.right != null) {
            OnePath(root.right, sum - root.val, new ArrayList<>(list));
        }
    }

    public void test() {

    }

}

package com.github.morningwn.t0501_t1000.t0501_t0600.t0511_t0520;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/">515. 在每个树行中找最大值</a>
 *
 * @author morningwn
 * @create in 2022/6/24 9:43
 */
public class T0515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        helper(res, root, 0);

        return res;
    }

    private void helper(List<Integer> res, TreeNode treeNode, int level) {
        if (res.size() > level) {
            if (res.get(level) < treeNode.val) {
                res.set(level, treeNode.val);
            }
        } else {
            Out.println(treeNode + "\t " + level);
            res.add(treeNode.val);
        }

        if (treeNode.left != null) {
            helper(res, treeNode.left, level + 1);
        }
        if (treeNode.right != null) {
            helper(res, treeNode.right, level + 1);
        }
    }
}

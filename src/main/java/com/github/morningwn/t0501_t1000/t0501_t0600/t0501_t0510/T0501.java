package com.github.morningwn.t0501_t1000.t0501_t0600.t0501_t0510;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/">501. 二叉搜索树中的众数</a>
 *
 * @author morningwn
 * @date 2020/9/24  16:31
 */
public class T0501 {
    private int cur;
    private int count;
    private int maxCount;
    private final List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        update(root);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void update(TreeNode node) {
        if (node == null) {
            return;
        }

        update(node.left);
        if (cur == node.val) {
            count++;
        } else {
            cur = node.val;
            count = 1;
        }

        if (maxCount < count) {
            list.clear();
            list.add(cur);
            maxCount = count;
        } else if (maxCount == count) {
            if (!list.contains(cur)) {
                list.add(cur);
            }
        }

        cur = node.val;
        count = 1;
        update(node.right);
    }
}

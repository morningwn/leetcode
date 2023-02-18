package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 二叉树中和为某一值的路径
 * @date Created in 2020/7/9 13:08
 * @version: 1.0
 */
public class T0034 {

    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            helper(root, sum, list);
        }

        return res;
    }

    /**
     * @author morningwn
     * @date 2020/7/10 10:55
     * @description: 遍历整棵树，得到结果就将其添加在结果集中
     * @param: node
     * @param: sum
     * @param: list
     * @return: void
     */
    public void helper(TreeNode node, int sum, List<Integer> list) {
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                list.add(node.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        } else if (node.left == null && node.right != null) {
            list.add(node.val);
            helper(node.right, sum - node.val, list);
            list.remove(list.size() - 1);
        } else if (node.left != null && node.right == null) {
            list.add(node.val);
            helper(node.left, sum - node.val, list);
            list.remove(list.size() - 1);
        } else {
            list.add(node.val);
            helper(node.left, sum - node.val, list);
            helper(node.right, sum - node.val, list);
            list.remove(list.size() - 1);
        }

    }
}

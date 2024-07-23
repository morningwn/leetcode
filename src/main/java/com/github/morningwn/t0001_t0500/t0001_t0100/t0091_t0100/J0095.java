package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/description/">95. 不同的二叉搜索树 II</a>
 *
 * @author morningwn
 * @date Created in 2020/7/21 15:33
 */
public class J0095 {

    @Test
    public void test() {
        List<TreeNode> list = generateTrees(1);
        for (TreeNode node : list) {
            Out.println(node);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i, left, right);
                    list.add(node);
                }
            }
        }

        return list;
    }
}

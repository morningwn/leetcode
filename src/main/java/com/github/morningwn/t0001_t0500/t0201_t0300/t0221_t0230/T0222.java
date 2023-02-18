package com.github.morningwn.t0001_t0500.t0201_t0300.t0221_t0230;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/2/20 18:41
 */
public class T0222 {

    @Test
    public void test() {
        Out.println(Integer.toBinaryString(9));
    }

    /**
     * 二分查找，根据题解的最优解
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;

        //计算树的高度
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            level++;
        }

        //计算节点个数的范围
        int min = 1 << level;
        int max = (1 << (level + 1)) - 1;

        //二分查询，得到结果
        while (min < max) {
            //得到当前范围的中间值，判断中间值对应的节点是否存在
            int mid = (min + max + 1) / 2;
            //判断中间节点是否存在
            if (exists(root, level, mid)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }

    /**
     * 判断当前节点是否存在
     * 方法：第K个节点，的二进制数据，除最高位的剩余位数，从高到低，0是左节点，1为右节点，据此定位
     *
     * @param root  根节点
     * @param level 树的高度
     * @param k     第几个节点
     * @return 判断结果
     */
    private Boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);

        TreeNode node = root;

        while (node != null && bits > 0) {
            //判断对应的位数是否为0
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            //右移一位
            bits >>= 1;
        }

        return node != null;
    }

    /**
     * 遍历所有的笨办法
     *
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
}

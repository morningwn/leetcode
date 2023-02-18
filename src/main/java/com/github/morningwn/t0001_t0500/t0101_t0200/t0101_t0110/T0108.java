package com.github.morningwn.t0001_t0500.t0101_t0200.t0101_t0110;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @date Created in 2020/7/3 12:37
 */
public class T0108 {

    /**
     * @author morningwn
     * @date 2020/7/3 12:56
     * @description: 根据排序数组构建二叉搜索树
     * @param: nums 排序数组，从小到大
     * @return: prefab.TreeNode 二叉树根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * @author morningwn
     * @date 2020/7/3 12:57
     * @description: 根据输入的数组及范围，创建一个根节点，然后递归调用创建子节点
     * @param: nums 排序数组
     * @param: start 数组的起始位置
     * @param: end 结束位置
     * @return: prefab.TreeNode 根节点
     */
    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;

        TreeNode node = new TreeNode(nums[middle]);
        node.left = helper(nums, start, middle - 1);
        node.right = helper(nums, middle + 1, end);

        return node;
    }
}

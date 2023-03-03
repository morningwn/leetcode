package com.github.morningwn.t0501_t1000.t0501_t0600;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @description:
 * @date Created in 2020/5/7 15:00
 * @version: 1.0
 */
public class T0572 {

    /**
     * 递归的调用，在查询到当前s树的根节点值与t树根节点的值相同后调用判罚是否和子节点相同的函数
     * s树的根节点值与t树根节点的值不同就递归的调用当前函数，继续查询s树的子树
     *
     * @param s 树一
     * @param t 树二
     * @return 判断结果
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        //s树为空，结束递归调用，返回false
        if (s != null) {

            //如果当前两个数的根节点的值相同就调用判断函数，并继续进入左右子树，取最后结果的或
            if (s.val == t.val) {
                return judge(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
            } else {//如果不同就进入左右子树，取结果的或
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        } else {
            return false;
        }
    }

    /**
     * 递归的调用，判断输入的两棵树是否相同
     *
     * @param s 树一
     * @param t 树二
     * @return 判断结果
     */
    public boolean judge(TreeNode s, TreeNode t) {

        //如果当前节点的值相同
        if (s.val == t.val) {

            //存储左右子树的判断结果
            boolean left = false;
            boolean right = false;

            //左子树均为空结果为true
            if (s.left == null && t.left == null) {
                left = true;
            } else if (s.left != null && t.left != null) { //左右子树均不为空继续进行判断
                left = judge(s.left, t.left);
            } else {//其他情况均为false
                return false;
            }

            //同上
            if (s.right == null && t.right == null) {
                right = true;
            } else if (s.right != null && t.right != null) {
                right = judge(s.right, t.right);
            } else {
                return false;
            }

            //返回判断结果
            return left && right;
        } else { //不同直接返回false
            return false;
        }
    }
}

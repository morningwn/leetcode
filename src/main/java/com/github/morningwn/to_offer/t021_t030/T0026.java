package com.github.morningwn.to_offer.t021_t030;

import com.github.morningwn.prefab.TreeNode;

/**
 * @author morningwn
 * @description: 树的子结构
 * @date Created in 2020/7/6 22:01
 * @version: 1.0
 */
public class T0026 {

    /**
     * @author morningwn
     * @date 2020/7/8 17:37
     * @description: 递归的去判断A的每一个子树
     * @param: A 树A
     * @param: B 树B
     * @return: boolean 判断结果
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        } else {
            return helper1(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    /**
     * @author morningwn
     * @date 2020/7/8 17:38
     * @description: 判断两个树是否相等
     * @param: A 树A
     * @param: B 树B
     * @return: boolean 判断结果
     */
    public boolean helper1(TreeNode A, TreeNode B) {

        if (A == null && B == null) {
            return true;
        } else if (A != null && B != null) {
            if (A.val == B.val) {
                boolean r = B.right == null || helper1(A.right, B.right);
                boolean l = B.left == null || helper1(A.left, B.left);

                return r && l;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

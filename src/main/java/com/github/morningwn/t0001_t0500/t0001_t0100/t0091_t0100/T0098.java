package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author morningwn
 * @date Created in 2020/5/5 16:50
 */
public class T0098 {

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);


        Out.println(isValidBST(root));
    }

    /**
     * 非递归，二叉搜索树的中根遍历从大到小
     *
     * @param root 二叉树的根节点
     * @return 判断结果
     */
    public boolean isValidBST(TreeNode root) {

        //初始化当前遍历过的节点的最大值
        long min = Long.MIN_VALUE;

        //使用两个栈，分别存储未遍历过的节点和遍历过但未输出的节点
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        //判断特殊情况
        if (root != null) {
            stack1.push(root);
        } else {
            return true;
        }

        //只要两个栈中不为空，就一直进行下去
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            //首先遍历stack1，这个里面未遍历过的栈
            if (!stack1.isEmpty()) {

                //将栈顶元素弹栈
                TreeNode tmp = stack1.pop();

                //如果左子树不为空就将左子树压入stack1，当前节点压入stack2
                if (tmp.left != null) {
                    stack2.push(tmp);
                    stack1.push(tmp.left);
                } else {//如果左子树为空

                    //判断当前节点的值是否大于前一个节点的值，不大就结束循环，返回结果false
                    if (min < tmp.val) {
                        min = tmp.val;
                    } else {
                        return false;
                    }

                    //如果右子树不为空就将右子树压入stack1中
                    if (tmp.right != null) {
                        stack1.push(tmp.right);
                    }
                }
            } else {//如果stack1已经空了
                //因为stack2中的元素之前已经遍历过左子树，所以直接判断当前节点和他们的右子树就行了

                //将stack2的栈顶元素弹栈
                TreeNode tmp = stack2.pop();

                //直接判断当前的值是否大于
                if (tmp.val > min) {
                    min = tmp.val;
                } else {
                    return false;
                }

                //若右子树存在就将其压入stack1中
                if (tmp.right != null) {
                    stack1.push(tmp.right);
                }
            }
        }

        return true;
    }

    /**
     * 递归算法，最优解
     *
     * @param root 二叉树的根节点
     * @return 判断结果
     */
    public boolean isValidBST1(TreeNode root) {

        //如果根节点不为空，进入判断
        if (root != null) {
            return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
        } else {//直接返回结果，true
            return true;
        }
    }


    /**
     * 递归调用，判断每个节点是否符合条件，大于min小于max
     *
     * @param node 当前节点
     * @param min  当前节点的最小值（不包含）
     * @param max  当前节点的最大值（不包含）
     * @return 判断结果
     */
    public boolean isValidNode(TreeNode node, long min, long max) {

        //如果符合条件，就进入判断子树的大小
        if (node.val > min && node.val < max) {

            //初始化两个值，分别用来存储左右子树的判断结果
            boolean leftRes = true;
            boolean rightRes = true;

            //如果左子树不为空
            if (node.left != null) {
                //左子树的范围应该比当前节点的值小，比当前节点的最小值大
                leftRes = isValidNode(node.left, min, node.val);
            }

            //如果右子树不为空
            if (node.right != null) {
                //右子树的范围应该比当前节点的值大，比当前节点的最大范围小
                rightRes = isValidNode(node.right, node.val, max);
            }
            return leftRes && rightRes;
        } else {//不符合就返回false
            return false;
        }
    }
}

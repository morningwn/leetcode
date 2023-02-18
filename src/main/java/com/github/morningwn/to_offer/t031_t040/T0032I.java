package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.prefab.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @description: 从上到下打印二叉树
 * @date Created in 2020/7/9 10:19
 * @version: 1.0
 */
public class T0032I {

    @Test
    public void test() {

    }

    /**
     * @author morningwn
     * @date 2020/7/9 10:26
     * @description: 非递归的层次遍历
     * @param: root
     * @return: int[]
     */
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        Out.println(list);
        res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}

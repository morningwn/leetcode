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
 * @date Created in 2020/7/11 18:17
 */
public class T0037 {

    @Test
    public void test() {

//        String data = "[1,2,3,null,null,4,5]";
        String data = "[5, 2, 3, null, null, 2, 4, 3, 1]";

        Codec codec = new Codec();
        TreeNode node = codec.deserialize(data);
        preOrder(node);
        String a = codec.serialize(node);
        Out.println(a);
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            Out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res.toString();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    res.add(null);
                } else {
                    res.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            int size = res.size() - 1;
            while (res.get(size) == null) {
                res.remove(size--);
            }
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data) || data == null || "[null]".equals(data) || data == "[]" || data == "[null]") {
                return null;
            }
            String[] nums = data.split(", ");
            int len = nums.length;
            nums[0] = nums[0].substring(1);
            nums[len - 1] = nums[len - 1].substring(0, nums[len - 1].length() - 1);

//            Out.println();
//            Out.println(Arrays.toString(nums));
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
            queue.offer(root);

            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (index < len && !("null".equals(nums[index]) || "null" == nums[index])) {
                    node.left = new TreeNode(Integer.parseInt(nums[index]));
                    queue.offer(node.left);
                }
                index++;
                if (index < len && !("null".equals(nums[index]) || "null" == nums[index])) {
                    node.right = new TreeNode(Integer.parseInt(nums[index]));
                    queue.offer(node.right);
                }

                index++;

            }

            return root;
        }
    }

}

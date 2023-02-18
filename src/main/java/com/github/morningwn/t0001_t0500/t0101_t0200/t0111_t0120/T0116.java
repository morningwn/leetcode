package com.github.morningwn.t0001_t0500.t0101_t0200.t0111_t0120;

import com.github.morningwn.prefab.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @date 2020/10/15  8:28
 */
public class T0116 {

    private List<Node> nodes;

    public Node connect(Node root) {
        nodes = new ArrayList<>();

        helper(root, 0);

        return root;
    }

    public void helper(Node node, int level) {
        if (node == null) {
            return;
        }
        if (nodes.size() <= level) {
            nodes.add(node);
        } else {
            nodes.get(level).next = node;
            nodes.set(level, node);
        }

        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}

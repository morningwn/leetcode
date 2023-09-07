package t1121_t1130

import . "github.com/morningwn/leetcode/src/main/go/prefab"

// 1123. 最深叶节点的最近公共祖先
// https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/

func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	level := getMaxLevel(root)
	node, _ := helper(root, 0, level)
	return node
}

func getMaxLevel(node *TreeNode) int {
	if node == nil {
		return 0
	}
	return max(getMaxLevel(node.Left), getMaxLevel(node.Right)) + 1
}

func helper(root *TreeNode, level, maxLevel int) (*TreeNode, bool) {
	if root == nil {
		return nil, false
	}

	if level+1 == maxLevel {
		return root, true
	}

	nodeL, resL := helper(root.Left, level+1, maxLevel)
	nodeR, resR := helper(root.Right, level+1, maxLevel)

	if resL && resR {
		return root, true
	} else if resL {
		return nodeL, true
	} else if resR {
		return nodeR, true
	}

	return nil, false
}

func max(num1, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}

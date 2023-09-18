package t0331_t0340

import . "github.com/morningwn/leetcode/src/main/go/prefab"

// 337. 打家劫舍 III
// https://leetcode.cn/problems/house-robber-iii/description/
func rob(root *TreeNode) int {
	noRobMaps := make(map[*TreeNode]int)
	robMaps := make(map[*TreeNode]int)

	return robNode(root, true, noRobMaps, robMaps)
}

func robNode(root *TreeNode, canRob bool, noRobMaps, robMaps map[*TreeNode]int) int {
	if root == nil {
		return 0
	}
	if canRob {
		if price, ok := robMaps[root]; ok {
			return price
		}
		// 不偷
		noRobPrice := robNode(root.Left, true, noRobMaps, robMaps) + robNode(root.Right, true, noRobMaps, robMaps)
		// 偷
		robPrice := robNode(root.Left, false, noRobMaps, robMaps) + robNode(root.Right, false, noRobMaps, robMaps) + root.Val
		maxPrice := maxInt(noRobPrice, robPrice)
		robMaps[root] = maxPrice
		return maxPrice
	} else {
		if price, ok := noRobMaps[root]; ok {
			return price
		}
		// 不偷
		maxPrice := robNode(root.Left, true, noRobMaps, robMaps) + robNode(root.Right, true, noRobMaps, robMaps)
		noRobMaps[root] = maxPrice
		return maxPrice
	}
}

func maxInt(num1, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}

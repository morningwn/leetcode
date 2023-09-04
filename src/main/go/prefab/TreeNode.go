package prefab

import "encoding/json"

/**
 * Definition for a binary tree node.
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (node *TreeNode) ToString() string {
	marshal, _ := json.Marshal(node)
	return string(marshal)
}

func (node *TreeNode) Println() {
	println(node.ToString())
}

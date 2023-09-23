package t1991_t2000

// 1993. 树上的操作
// https://leetcode.cn/problems/operations-on-tree/description/

var (
	statusLocked   = 23
	statusUnLocked = 0
)

type treeNode struct {
	id                  int
	parent              *treeNode
	children            []*treeNode
	status              int
	user                int
	parentLockedCount   int
	childrenLockedCount int
}

func (node *treeNode) lock(user int) bool {
	if node.status != statusUnLocked {
		return false
	}
	node.user = user
	node.status = statusLocked
	if len(node.children) > 0 {
		for _, child := range node.children {
			child.sendParentLocked()
		}
	}
	if node.parent != nil {
		node.parent.sendChildLocked()
	}
	return true
}

func (node *treeNode) unLock(user int) bool {
	if node.status != statusLocked || node.user != user {
		return false
	}
	node.user = 0
	node.status = statusUnLocked
	if len(node.children) > 0 {
		for _, child := range node.children {
			child.sendParentUnLocked()
		}
	}
	if node.parent != nil {
		node.parent.sendChildUnLocked()
	}
	return true
}

func (node *treeNode) sendParentLocked() {
	node.parentLockedCount++
	if len(node.children) > 0 {
		for _, child := range node.children {
			child.sendParentLocked()
		}
	}
}

func (node *treeNode) sendParentUnLocked() {
	node.parentLockedCount--
	if len(node.children) > 0 {
		for _, child := range node.children {
			child.sendParentUnLocked()
		}
	}
}

func (node *treeNode) sendChildLocked() {
	node.childrenLockedCount++
	if node.parent != nil {
		node.parent.sendChildLocked()
	}
}

func (node *treeNode) sendChildUnLocked() {
	node.childrenLockedCount--
	if node.parent != nil {
		node.parent.sendChildUnLocked()
	}
}

type LockingTree struct {
	nodeMap map[int]*treeNode
}

func Constructor(parent []int) LockingTree {
	nodeMap := make(map[int]*treeNode)
	for i, pN := range parent {
		p, okP := nodeMap[pN]
		n, okN := nodeMap[i]
		if !okP {
			p = &treeNode{id: pN}
			nodeMap[pN] = p
		}
		if okN {
			n.parent = p
			p.children = append(p.children, n)
		} else {
			n := &treeNode{id: i, parent: p}
			nodeMap[i] = n
			p.children = append(p.children, n)
		}
	}
	return LockingTree{
		nodeMap: nodeMap,
	}
}

func (this *LockingTree) Lock(num int, user int) bool {
	node, _ := this.nodeMap[num]
	return node.lock(user)
}

func (this *LockingTree) Unlock(num int, user int) bool {
	node, _ := this.nodeMap[num]
	return node.unLock(user)
}

func (this *LockingTree) Upgrade(num int, user int) bool {
	node, _ := this.nodeMap[num]

	if node.status != statusUnLocked || node.parentLockedCount != 0 || node.childrenLockedCount == 0 {
		return false
	}

	nodeQueue := make([]*treeNode, 0)
	nodeQueue = append(nodeQueue, node.children...)

	for len(nodeQueue) > 0 {
		tmpNode := nodeQueue[0]
		nodeQueue = nodeQueue[1:]
		tmpNode.status = statusUnLocked
		tmpNode.childrenLockedCount = 0
		tmpNode.parentLockedCount = 0
		tmpNode.user = 0
		nodeQueue = append(nodeQueue, tmpNode.children...)
	}
	parent := node.parent
	for parent != nil {
		parent.childrenLockedCount -= node.childrenLockedCount
		parent = parent.parent
	}

	node.childrenLockedCount = 0
	node.lock(user)
	return true
}

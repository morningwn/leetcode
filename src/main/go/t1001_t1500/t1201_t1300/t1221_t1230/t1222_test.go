package t1221_t1230

import (
	"github.com/morningwn/leetcode/src/main/go/prefab"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_queensAttacktheKing(t *testing.T) {
	var queens [][]int
	var king []int

	queens = prefab.StringTo2Array("[[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]]", 2)
	king = prefab.StringToArray("[0,0]")

	assert.Equal(t, prefab.StringTo2Array("[[0,1],[1,0],[3,3]]", 2), queensAttacktheKing(queens, king))
}

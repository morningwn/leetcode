package t0191_t0200

import (
	"github.com/morningwn/leetcode/src/main/go/prefab"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_rob(t *testing.T) {
	var nums []int
	nums = prefab.StringToArray("[1,2,3,1]")
	assert.Equal(t, 4, rob(nums))

	nums = prefab.StringToArray("[2,7,9,3,1]")
	assert.Equal(t, 12, rob(nums))
}

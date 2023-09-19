package t2551_t2560

import (
	"github.com/morningwn/leetcode/src/main/go/prefab"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_minCapability(t *testing.T) {
	nums := prefab.StringToArray("[2,3,5,9]")
	k := 2
	assert.Equal(t, 5, minCapability(nums, k))
}

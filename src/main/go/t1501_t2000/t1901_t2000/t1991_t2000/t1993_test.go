package t1991_t2000

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_Lock(t *testing.T) {
	t.Run("case1", func(t *testing.T) {
		lockingTree := Constructor([]int{-1, 0, 0, 1, 1, 2, 2})
		assert.Equal(t, true, lockingTree.Lock(2, 2))
		assert.Equal(t, false, lockingTree.Unlock(2, 3))
		assert.Equal(t, true, lockingTree.Unlock(2, 2))
		assert.Equal(t, true, lockingTree.Lock(4, 5))
		assert.Equal(t, true, lockingTree.Upgrade(0, 1))
		assert.Equal(t, false, lockingTree.Lock(0, 1))
	})

	t.Run("case2", func(t *testing.T) {
		lockingTree := Constructor([]int{-1, 4, 9, 0, 6, 1, 0, 6, 3, 1})
		assert.Equal(t, false, lockingTree.Upgrade(9, 43))
		assert.Equal(t, false, lockingTree.Upgrade(4, 27))
		assert.Equal(t, false, lockingTree.Upgrade(5, 34))
		assert.Equal(t, false, lockingTree.Upgrade(7, 31))
		assert.Equal(t, false, lockingTree.Upgrade(4, 27))
		assert.Equal(t, true, lockingTree.Lock(2, 47))
		assert.Equal(t, false, lockingTree.Unlock(7, 21))
		assert.Equal(t, true, lockingTree.Upgrade(4, 12))
		//assert.Equal(t, true, lockingTree.Unlock())

	})
}

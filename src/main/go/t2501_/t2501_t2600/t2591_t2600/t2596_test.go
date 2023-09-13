package t2591_t2600

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_checkValidGrid(t *testing.T) {
	grid := [][]int{{8, 3, 6}, {5, 0, 1}, {2, 7, 4}}
	assert.Equal(t, false, checkValidGrid(grid))
}


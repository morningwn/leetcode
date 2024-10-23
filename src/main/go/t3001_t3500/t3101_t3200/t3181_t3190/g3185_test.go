package t3181t3190

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_countCompleteDayPairs(t *testing.T) {
	hours := []int{12, 12, 30, 24, 24}
	assert.Equal(t, int64(2), countCompleteDayPairs(hours))
}

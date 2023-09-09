package t0201_t0210

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_canFinish(t *testing.T) {
	var numCourses int
	var prerequisites [][]int

	t.Run("0", func(t *testing.T) {
		numCourses = 2
		prerequisites = [][]int{{1, 0}}
		assert.Equal(t, true, canFinish(numCourses, prerequisites))
	})
	t.Run("1", func(t *testing.T) {
		numCourses = 2
		prerequisites = [][]int{{1, 0}, {0, 1}}
		assert.Equal(t, false, canFinish(numCourses, prerequisites))
	})
	t.Run("3", func(t *testing.T) {
		numCourses = 20
		prerequisites = [][]int{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}
		assert.Equal(t, false, canFinish(numCourses, prerequisites))
	})
}

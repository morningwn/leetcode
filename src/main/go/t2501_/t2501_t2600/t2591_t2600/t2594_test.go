package t2591_t2600

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_repairCars(t *testing.T) {
	ranks := []int{4, 2, 3, 1}
	cars := 10
	assert.Equal(t, int64(16), repairCars(ranks, cars))

	ranks = make([]int, 100)
	for i := 1; i <= 100; i++ {
		ranks[i-1] = i
		fmt.Printf("%d,", i)
	}
	cars = 100000

	assert.Equal(t, int64(28965924), repairCars(ranks, cars))

}

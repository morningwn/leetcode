package t041_t050

import "math"

// LCP 50. 宝石补给
// https://leetcode.cn/problems/WHnhjV/description/

func giveGem(gem []int, operations [][]int) int {

	for _, operation := range operations {
		gem[operation[1]] += gem[operation[0]] / 2
		gem[operation[0]] -= gem[operation[0]] / 2
	}
	maxGem, minGem := 0, math.MaxInt32

	for _, g := range gem {
		if g < minGem {
			minGem = g
		}
		if g > maxGem {
			maxGem = g
		}
	}

	return maxGem - minGem
}

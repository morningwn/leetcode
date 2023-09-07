package t2591_t2600

import "math"

// 2594. 修车的最少时间
// https://leetcode.cn/problems/minimum-time-to-repair-cars/

func repairCars(ranks []int, cars int) int64 {
	l, r := 0, ranks[0]*cars*cars

	for l < r {
		m := (l + r) / 2
		count := 0
		for _, rank := range ranks {
			count += int(math.Sqrt(float64(m / rank)))
		}
		if count >= cars {
			r = m
		} else {
			l = m + 1
		}
	}

	return int64(r)
}
